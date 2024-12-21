package com.example.nutzung.application;

import com.example.nutzung.application.domain.*;
import com.example.nutzung.application.dto.FahrzeughalterRequest;
import com.example.nutzung.application.dto.FahrzeughalterResponse;
import com.example.nutzung.application.dto.NutzungRequest;
import com.example.nutzung.application.dto.NutzungResponse;
import com.example.nutzung.application.exception.BadRequestException;
import com.example.nutzung.application.exception.NotFoundException;
import com.example.nutzung.application.exception.NutzungAppException;
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
    private final NutzungDomainService nutzungDomainService;

    public NutzungAppServiceImpl(FahrzeughalterRepository halterRepo, NutzungRepository nutzungRepo,
            LadepunktRepository ladepunktRepo, NutzungDomainService nutzungDomainService) {
        this.halterRepo = halterRepo;
        this.nutzungRepo = nutzungRepo;
        this.ladepunktRepo = ladepunktRepo;
        this.nutzungDomainService = nutzungDomainService;
    }

    @Override
    public int halterAnlegen(FahrzeughalterRequest dto) {
        Fahrzeughalter halter = FahrzeughalterMapper.toDomain(dto);
        halterRepo.save(halter);
        return halter.getHalterId().getId();
    }

    @Override
    public FahrzeughalterResponse halterFinden(int halterId) throws NutzungAppException {
        Fahrzeughalter halter = halterRepo.findById(new FahrzeughalterId(halterId));
        if (halter == null) {
            throw new NotFoundException("Fahrzeughalter nicht gefunden");
        }
        return FahrzeughalterMapper.toResponse(halter);
    }

    @Override
    public void halterAktualisieren(int halterId, FahrzeughalterRequest dto) throws NutzungAppException {
        FahrzeughalterId hid = new FahrzeughalterId(halterId);
        Fahrzeughalter alt = halterRepo.findById(hid);
        if (alt == null) {
            throw new NotFoundException("Fahrzeughalter nicht gefunden");
        }
        Fahrzeughalter neu = FahrzeughalterMapper.toDomain(dto);
        neu.setHalterId(hid);
        halterRepo.save(neu);
    }

    @Override
    public void halterLoeschen(int halterId) throws NutzungAppException {
        Fahrzeughalter halter = halterRepo.findById(new FahrzeughalterId(halterId));
        if (halter == null) {
            throw new NotFoundException("Fahrzeughalter nicht gefunden");
        }
        halterRepo.delete(halter.getHalterId());
    }

    @Override
    public List<FahrzeughalterResponse> alleHalterAnzeigen() {
        List<Fahrzeughalter> halter = halterRepo.findAll();
        return halter.stream().map(FahrzeughalterMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public int nutzungAnlegen(int ladepunktId, NutzungRequest dto) throws NutzungAppException {
        Ladepunkt ladepunkt = ladepunktRepo.findById(new LadepunktId(ladepunktId));
        if (ladepunkt == null) {
            throw new NotFoundException("Ladepunkt nicht gefunden");
        }
        if (!ladepunkt.getVerfuegbarkeit().equals("verfügbar")) {
            throw new BadRequestException("Ladepunkt nicht verfügbar");
        }
        Fahrzeughalter halter = halterRepo.findById(new FahrzeughalterId(dto.getHalterId()));
        if (halter == null) {
            throw new NotFoundException("Fahrzeughalter nicht gefunden");
        }
        dto.setladeleistungKWH(dto.getLadezeitMin() * ladepunkt.getLadeleistungKW() / 60);
        Nutzung nutzung = NutzungMapper.toDomain(ladepunktId, dto);
        nutzungRepo.save(nutzung);
        nutzungDomainService.verarbeiteLadevorgang(nutzung);
        return nutzung.getNutzungsId().getId();
    }

    @Override
    public NutzungResponse nutzungFinden(int nutzungId) throws NutzungAppException {
        Nutzung nutzung = nutzungRepo.findById(new NutzungId(nutzungId));
        if (nutzung == null) {
            throw new NotFoundException("Nutzung nicht gefunden");
        }
        return NutzungMapper.toResponse(nutzung);
    }

    @Override
    public void nutzungLoeschen(int nutzungId) throws NutzungAppException {
        Nutzung nutzung = nutzungRepo.findById(new NutzungId(nutzungId));
        if (nutzung == null) {
            throw new NotFoundException("Nutzung nicht gefunden");
        }
        nutzungRepo.delete(nutzung.getNutzungsId());
    }

    @Override
    public List<NutzungResponse> nutzungsHistorieFuerHalter(int halterId) throws NutzungAppException {
        Fahrzeughalter halter = halterRepo.findById(new FahrzeughalterId(halterId));
        if (halter == null) {
            throw new NotFoundException("Fahrzeughalter nicht gefunden");
        }
        List<Nutzung> nutzungen = nutzungRepo.findAllByHalterId(halter.getHalterId());
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
