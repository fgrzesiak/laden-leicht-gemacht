package com.example.infrastruktur.application;

import com.example.infrastruktur.application.domain.*;
import com.example.infrastruktur.application.dto.AnsprechpartnerRequest;
import com.example.infrastruktur.application.dto.AnsprechpartnerResponse;
import com.example.infrastruktur.application.dto.EigentuemerRequest;
import com.example.infrastruktur.application.dto.EigentuemerResponse;
import com.example.infrastruktur.application.dto.LadepunktRequest;
import com.example.infrastruktur.application.dto.LadepunktResponse;
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

        // Konstruktor (jetzt mit ladepunktDomainService)
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
        public Integer ladepunktAnlegen(LadepunktRequest ladepunkt) {
                Ladepunkt neuerLadepunkt = LadepunktMapper.toDomain(ladepunkt);
                ladepunktRepository.save(neuerLadepunkt);
                ladepunktDomainService.speichereLadepunkt(neuerLadepunkt);
                return neuerLadepunkt.getLadepunktId().getId();
        }

        @Override
        public LadepunktResponse ladepunktFinden(Integer ladepunktId) {
                Ladepunkt ladepunkt = ladepunktRepository.findById(new LadepunktId(ladepunktId));
                if (ladepunkt == null) {
                        return null;
                }
                return LadepunktMapper.toResponse(ladepunkt);
        }

        @Override
        public boolean ladepunktAktualisieren(Integer ladepunktId, LadepunktRequest neueDaten) {
                LadepunktId lpId = new LadepunktId(ladepunktId);
                Ladepunkt ladepunktAlt = ladepunktRepository.findById(lpId);
                if (ladepunktAlt == null) {
                        return false;
                }
                Ladepunkt ladepunktNeu = LadepunktMapper.toDomain(neueDaten);
                ladepunktNeu.setLadepunktId(lpId);
                ladepunktRepository.save(ladepunktNeu);
                ladepunktDomainService.speichereLadepunkt(ladepunktNeu);
                return true;
        }

        @Override
        public boolean ladepunktLoeschen(Integer ladepunktId) {
                Ladepunkt lp = ladepunktRepository.findById(new LadepunktId(ladepunktId));
                if (lp == null) {
                        return false;
                }
                ladepunktRepository.delete(lp.getLadepunktId());
                return true;
        }

        @Override
        public List<LadepunktResponse> alleLadepunkteAnzeigen() {
                List<Ladepunkt> ladepunkte = ladepunktRepository.findAll();
                return ladepunkte.stream().map(LadepunktMapper::toResponse).collect(Collectors.toList());
        }

        /**
         * NEU: Beispielmethode, die einen Ladevorgang verbucht.
         * Ruft den Domain Service auf, der dann Events etc. publiziert.
         */
        public boolean ladevorgangVerbuchen(LadepunktId ladepunktId, double geladeneKWh) {
                Ladepunkt lp = ladepunktRepository.findById(ladepunktId);
                if (lp == null) {
                        return false;
                }
                ladepunktDomainService.verarbeiteLadevorgang(lp, geladeneKWh);
                ladepunktRepository.save(lp);
                return true;
        }

        // ------------------------------------------------------
        // Eigentümer-Funktionen
        // ------------------------------------------------------

        @Override
        public Integer eigentuemerAnlegen(EigentuemerRequest eigentuemer) {
                Eigentuemer neu = EigentuemerMapper.toDomain(eigentuemer);
                eigentuemerRepository.save(neu);
                return neu.getEigentuemerId().getId();
        }

        @Override
        public EigentuemerResponse eigentuemerFinden(Integer eigentuemerId) {
                Eigentuemer eigentuemer = eigentuemerRepository.findById(new EigentuemerId(eigentuemerId));
                if (eigentuemer == null) {
                        return null;
                }
                return EigentuemerMapper.toResponse(eigentuemer);
        }

        @Override
        public boolean eigentuemerAktualisieren(Integer eigentuemerId, EigentuemerRequest neueDaten) {
                EigentuemerId eigentuemerIdObj = new EigentuemerId(eigentuemerId);
                Eigentuemer alt = eigentuemerRepository.findById(eigentuemerIdObj);
                if (alt == null) {
                        return false;
                }
                Eigentuemer neu = EigentuemerMapper.toDomain(neueDaten);
                neu.setEigentuemerId(eigentuemerIdObj);
                eigentuemerRepository.save(neu);
                return true;
        }

        @Override
        public boolean eigentuemerLoeschen(Integer eigentuemerId) {
                Eigentuemer eig = eigentuemerRepository
                                .findById(new EigentuemerId(eigentuemerId));
                if (eig == null) {
                        return false;
                }
                eigentuemerRepository.delete(eig.getEigentuemerId());
                return true;
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
        public Integer ansprechpartnerAnlegen(AnsprechpartnerRequest dto) {
                Ansprechpartner ap = AnsprechpartnerMapper.toDomain(dto);
                ansprechpartnerRepository.save(ap);
                return ap.getAnsprechpartnerId().getId();
        }

        @Override
        public AnsprechpartnerResponse ansprechpartnerFinden(Integer ansprechpartnerId) {
                Ansprechpartner ap = ansprechpartnerRepository.findById(new AnsprechpartnerId(ansprechpartnerId));
                if (ap == null)
                        return null;
                return AnsprechpartnerMapper.toResponse(ap);
        }

        @Override
        public boolean ansprechpartnerAktualisieren(Integer ansprechpartnerId, AnsprechpartnerRequest dto) {
                AnsprechpartnerId apId = new AnsprechpartnerId(ansprechpartnerId);
                Ansprechpartner apAlt = ansprechpartnerRepository.findById(apId);
                if (apAlt == null)
                        return false;
                Ansprechpartner apNeu = AnsprechpartnerMapper.toDomain(dto);
                apNeu.setAnsprechpartnerId(apId);
                ansprechpartnerRepository.save(apNeu);
                return true;
        }

        @Override
        public boolean ansprechpartnerLoeschen(Integer ansprechpartnerId) {
                Ansprechpartner ap = ansprechpartnerRepository.findById(new AnsprechpartnerId(ansprechpartnerId));
                if (ap == null)
                        return false;
                ansprechpartnerRepository.delete(ap.getAnsprechpartnerId());
                return true;
        }

        @Override
        public List<AnsprechpartnerResponse> alleAnsprechpartnerFuerEigentuemer(Integer eigentuemerId) {
                List<Ansprechpartner> aps = ansprechpartnerRepository
                                .findByEigentuemerId(new EigentuemerId(eigentuemerId));
                return aps.stream().map(AnsprechpartnerMapper::toResponse).collect(Collectors.toList());
        }

        // ------------------------------------------------------
        // RabbitMq-Funktionen
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
