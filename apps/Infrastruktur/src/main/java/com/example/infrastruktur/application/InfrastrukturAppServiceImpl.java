package com.example.infrastruktur.application;

import com.example.infrastruktur.application.domain.*;
import com.example.infrastruktur.application.dto.AnsprechpartnerRequest;
import com.example.infrastruktur.application.dto.AnsprechpartnerResponse;
import com.example.infrastruktur.application.dto.EigentuemerRequest;
import com.example.infrastruktur.application.dto.EigentuemerResponse;
import com.example.infrastruktur.application.dto.LadepunktRequest;
import com.example.infrastruktur.application.dto.LadepunktResponse;
import com.example.infrastruktur.application.exception.InfrastrukturAppException;
import com.example.infrastruktur.application.exception.NotFoundException;
import com.example.infrastruktur.application.mapper.AnsprechpartnerMapper;
import com.example.infrastruktur.application.mapper.EigentuemerMapper;
import com.example.infrastruktur.application.mapper.LadepunktMapper;
import com.example.infrastruktur.application.port.secondary.LadepunktRepository;
import com.example.infrastruktur.application.port.secondary.AnsprechpartnerRepository;
import com.example.infrastruktur.application.port.secondary.EigentuemerRepository;
import com.example.infrastruktur.application.port.primary.InfrastrukturAppService;

import java.util.List;
import java.util.stream.Collectors;

public class InfrastrukturAppServiceImpl implements InfrastrukturAppService {

        private final LadepunktRepository ladepunktRepository;
        private final EigentuemerRepository eigentuemerRepository;
        private final AnsprechpartnerRepository ansprechpartnerRepository;
        private final LadepunktDomainService ladepunktDomainService;

        public InfrastrukturAppServiceImpl(
                        LadepunktRepository ladepunktRepository,
                        EigentuemerRepository eigentuemerRepository,
                        AnsprechpartnerRepository ansprechpartnerRepository,
                        LadepunktDomainService ladepunktDomainService) {
                this.ladepunktRepository = ladepunktRepository;
                this.eigentuemerRepository = eigentuemerRepository;
                this.ansprechpartnerRepository = ansprechpartnerRepository;
                this.ladepunktDomainService = ladepunktDomainService;
        }

        // ------------------------------------------------------
        // Ladepunkt-Funktionen
        // ------------------------------------------------------

        @Override
        public int ladepunktAnlegen(LadepunktRequest ladepunkt) throws InfrastrukturAppException {
                Eigentuemer eigentuemer = eigentuemerRepository
                                .findById(new EigentuemerId(ladepunkt.getEigentuemerId()));
                if (eigentuemer == null) {
                        throw new NotFoundException("Eigentümer nicht gefunden");
                }
                Ladepunkt neuerLadepunkt = LadepunktMapper.toDomain(ladepunkt);
                ladepunktRepository.save(neuerLadepunkt);
                ladepunktDomainService.speichereLadepunkt(neuerLadepunkt);
                return neuerLadepunkt.getLadepunktId().getId();
        }

        @Override
        public LadepunktResponse ladepunktFinden(int ladepunktId) throws InfrastrukturAppException {
                Ladepunkt ladepunkt = ladepunktRepository.findById(new LadepunktId(ladepunktId));
                if (ladepunkt == null) {
                        throw new NotFoundException("Ladepunkt nicht gefunden");
                }
                return LadepunktMapper.toResponse(ladepunkt);
        }

        @Override
        public void ladepunktAktualisieren(int ladepunktId, LadepunktRequest neueDaten)
                        throws InfrastrukturAppException {
                LadepunktId lpId = new LadepunktId(ladepunktId);
                Ladepunkt ladepunktAlt = ladepunktRepository.findById(lpId);
                if (ladepunktAlt == null) {
                        throw new NotFoundException("Ladepunkt nicht gefunden");
                }
                Ladepunkt ladepunktNeu = LadepunktMapper.toDomain(neueDaten);
                ladepunktNeu.setLadepunktId(lpId);
                ladepunktRepository.save(ladepunktNeu);
                ladepunktDomainService.speichereLadepunkt(ladepunktNeu);
        }

        @Override
        public void ladepunktLoeschen(int ladepunktId) throws InfrastrukturAppException {
                Ladepunkt lp = ladepunktRepository.findById(new LadepunktId(ladepunktId));
                if (lp == null) {
                        throw new NotFoundException("Ladepunkt nicht gefunden");
                }
                ladepunktRepository.delete(lp.getLadepunktId());
        }

        @Override
        public List<LadepunktResponse> alleLadepunkteAnzeigen() {
                List<Ladepunkt> ladepunkte = ladepunktRepository.findAll();
                return ladepunkte.stream().map(LadepunktMapper::toResponse).collect(Collectors.toList());
        }

        // ------------------------------------------------------
        // Eigentümer-Funktionen
        // ------------------------------------------------------

        @Override
        public int eigentuemerAnlegen(EigentuemerRequest eigentuemer) {
                Eigentuemer neu = EigentuemerMapper.toDomain(eigentuemer);
                eigentuemerRepository.save(neu);
                return neu.getEigentuemerId().getId();
        }

        @Override
        public EigentuemerResponse eigentuemerFinden(int eigentuemerId) throws InfrastrukturAppException {
                Eigentuemer eigentuemer = eigentuemerRepository.findById(new EigentuemerId(eigentuemerId));
                if (eigentuemer == null) {
                        throw new NotFoundException("Eigentümer nicht gefunden");
                }
                return EigentuemerMapper.toResponse(eigentuemer);
        }

        @Override
        public void eigentuemerAktualisieren(int eigentuemerId, EigentuemerRequest neueDaten)
                        throws InfrastrukturAppException {
                EigentuemerId eigentuemerIdObj = new EigentuemerId(eigentuemerId);
                Eigentuemer alt = eigentuemerRepository.findById(eigentuemerIdObj);
                if (alt == null) {
                        throw new NotFoundException("Eigentümer nicht gefunden");
                }
                Eigentuemer neu = EigentuemerMapper.toDomain(neueDaten);
                neu.setEigentuemerId(eigentuemerIdObj);
                eigentuemerRepository.save(neu);
        }

        @Override
        public void eigentuemerLoeschen(int eigentuemerId) throws InfrastrukturAppException {
                Eigentuemer eig = eigentuemerRepository.findById(new EigentuemerId(eigentuemerId));
                if (eig == null) {
                        throw new NotFoundException("Eigentümer nicht gefunden");
                }
                eigentuemerRepository.delete(eig.getEigentuemerId());
        }

        @Override
        public List<EigentuemerResponse> alleEigentuemerAnzeigen() {
                List<Eigentuemer> eigentuemer = eigentuemerRepository.findAll();
                return eigentuemer.stream().map(EigentuemerMapper::toResponse).collect(Collectors.toList());
        }

        // ------------------------------------------------------
        // Ansprechpartner-Funktionen
        // ------------------------------------------------------

        @Override
        public int ansprechpartnerAnlegen(AnsprechpartnerRequest dto) {
                Ansprechpartner ap = AnsprechpartnerMapper.toDomain(dto);
                ansprechpartnerRepository.save(ap);
                return ap.getAnsprechpartnerId().getId();
        }

        @Override
        public AnsprechpartnerResponse ansprechpartnerFinden(int ansprechpartnerId)
                        throws InfrastrukturAppException {
                Ansprechpartner ap = ansprechpartnerRepository.findById(new AnsprechpartnerId(ansprechpartnerId));
                if (ap == null) {
                        throw new NotFoundException("Ansprechpartner nicht gefunden");
                }
                return AnsprechpartnerMapper.toResponse(ap);
        }

        @Override
        public void ansprechpartnerAktualisieren(int ansprechpartnerId, AnsprechpartnerRequest dto)
                        throws InfrastrukturAppException {
                AnsprechpartnerId apId = new AnsprechpartnerId(ansprechpartnerId);
                Ansprechpartner apAlt = ansprechpartnerRepository.findById(apId);
                if (apAlt == null) {
                        throw new NotFoundException("Ansprechpartner nicht gefunden");
                }
                Ansprechpartner apNeu = AnsprechpartnerMapper.toDomain(dto);
                apNeu.setAnsprechpartnerId(apId);
                ansprechpartnerRepository.save(apNeu);
        }

        @Override
        public void ansprechpartnerLoeschen(int ansprechpartnerId) throws InfrastrukturAppException {
                Ansprechpartner ap = ansprechpartnerRepository.findById(new AnsprechpartnerId(ansprechpartnerId));
                if (ap == null) {
                        throw new NotFoundException("Ansprechpartner nicht gefunden");
                }
                ansprechpartnerRepository.delete(ap.getAnsprechpartnerId());
        }

        @Override
        public List<AnsprechpartnerResponse> alleAnsprechpartnerAnzeigen() {
                List<Ansprechpartner> ansprechpartner = ansprechpartnerRepository.findAll();
                return ansprechpartner.stream().map(AnsprechpartnerMapper::toResponse).collect(Collectors.toList());
        }

        @Override
        public List<AnsprechpartnerResponse> alleAnsprechpartnerFuerEigentuemer(int eigentuemerId) {
                List<Ansprechpartner> aps = ansprechpartnerRepository
                                .findByEigentuemerId(new EigentuemerId(eigentuemerId));
                return aps.stream().map(AnsprechpartnerMapper::toResponse).collect(Collectors.toList());
        }

        // ------------------------------------------------------
        // Event-Funktionen
        // ------------------------------------------------------
        @Override
        public void verarbeiteLadevorgang(int ladepunktId, double ladeleistungKWH) {
                Ladepunkt ladepunkt = ladepunktRepository.findById(new LadepunktId(ladepunktId));
                if (ladepunkt == null) {
                        return;
                }
                ladepunkt.verarbeiteLadevorgang(ladeleistungKWH);
                ladepunktRepository.save(ladepunkt);
        }

}