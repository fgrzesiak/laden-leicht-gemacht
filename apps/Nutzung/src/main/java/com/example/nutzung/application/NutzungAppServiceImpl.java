package com.example.nutzung.application;

import com.example.nutzung.application.domain.*;
import com.example.nutzung.application.dto.FahrzeughalterRequest;
import com.example.nutzung.application.dto.FahrzeughalterResponse;
import com.example.nutzung.application.dto.NutzungRequest;
import com.example.nutzung.application.dto.NutzungResponse;
import com.example.nutzung.application.mapper.FahrzeughalterMapper;
import com.example.nutzung.application.mapper.NutzungMapper;
import com.example.nutzung.application.port.primary.NutzungAppService;
import com.example.nutzung.application.port.secondary.FahrzeughalterRepository;
import com.example.nutzung.application.port.secondary.LadepunktRepository;
import com.example.nutzung.application.port.secondary.NutzungRepository;

import java.util.List;
import java.util.stream.Collectors;

public class NutzungAppServiceImpl implements NutzungAppService {

    private final FahrzeughalterRepository halterRepo;
    private final NutzungRepository nutzungRepo;
    private final LadepunktRepository ladepunktRepo;

    public NutzungAppServiceImpl(FahrzeughalterRepository halterRepo, NutzungRepository nutzungRepo,
            LadepunktRepository ladepunktRepo) {
        this.halterRepo = halterRepo;
        this.nutzungRepo = nutzungRepo;
        this.ladepunktRepo = ladepunktRepo;
    }

    @Override
    public int halterAnlegen(FahrzeughalterRequest dto) {
        Fahrzeughalter halter = FahrzeughalterMapper.toDomain(dto);
        halterRepo.save(halter);
        return halter.getHalterId().getId();
    }

    @Override
    public FahrzeughalterResponse halterFinden(int halterId) {
        Fahrzeughalter halter = halterRepo.findById(new FahrzeughalterId(halterId));
        if (halter == null) {
            return null;
        }
        return FahrzeughalterMapper.toResponse(halter);
    }

    @Override
    public boolean halterAktualisieren(int halterId, FahrzeughalterRequest dto) {
        FahrzeughalterId hid = new FahrzeughalterId(halterId);
        Fahrzeughalter alt = halterRepo.findById(hid);
        if (alt == null) {
            return false;
        }
        Fahrzeughalter neu = FahrzeughalterMapper.toDomain(dto);
        neu.setHalterId(hid);
        halterRepo.save(neu);
        return true;
    }

    @Override
    public boolean halterLoeschen(int halterId) {
        Fahrzeughalter halter = halterRepo.findById(new FahrzeughalterId(halterId));
        if (halter == null) {
            return false;
        }
        halterRepo.delete(halter.getHalterId());
        return true;
    }

    @Override
    public List<FahrzeughalterResponse> alleHalterAnzeigen() {
        List<Fahrzeughalter> halter = halterRepo.findAll();
        return halter.stream().map(FahrzeughalterMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public int nutzungAnlegen(NutzungRequest dto) {
        Nutzung nutzung = NutzungMapper.toDomain(dto);
        nutzungRepo.save(nutzung);
        return nutzung.getNutzungsId().getId();
    }

    @Override
    public NutzungResponse nutzungFinden(int nutzungId) {
        Nutzung nutzung = nutzungRepo.findById(new NutzungId(nutzungId));
        if (nutzung == null) {
            return null;
        }
        return NutzungMapper.toResponse(nutzung);
    }

    @Override
    public boolean nutzungLoeschen(int nutzungId) {
        Nutzung nutzung = nutzungRepo.findById(new NutzungId(nutzungId));
        if (nutzung == null) {
            return false;
        }
        nutzungRepo.delete(nutzung.getNutzungsId());
        return true;
    }

    @Override
    public List<NutzungResponse> nutzungsHistorieFuerHalter(int halterId) {
        List<Nutzung> nutzungen = nutzungRepo.findAllByHalterId(new FahrzeughalterId(halterId));
        return nutzungen.stream().map(NutzungMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public void ladepunktAktualisieren(int ladepunktId, double ladeleistungKW, String verfuegbarkeit) {
        Ladepunkt ladepunktAlt = ladepunktRepo.findById(new LadepunktId(ladepunktId));
        if (ladepunktAlt == null) {
            Ladepunkt ladepunktNeu = new Ladepunkt(new LadepunktId(ladepunktId), ladeleistungKW, verfuegbarkeit);
            ladepunktRepo.save(ladepunktNeu, true);
            return;
        }
        ladepunktAlt.setLadeleistungKW(ladeleistungKW);
        ladepunktAlt.setVerfuegbarkeit(verfuegbarkeit);
        ladepunktRepo.save(ladepunktAlt, false);
    }
}
