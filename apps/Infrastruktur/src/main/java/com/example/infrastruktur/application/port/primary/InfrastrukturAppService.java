package com.example.infrastruktur.application.port.primary;

import com.example.infrastruktur.application.dto.AnsprechpartnerRequest;
import com.example.infrastruktur.application.dto.AnsprechpartnerResponse;
import com.example.infrastruktur.application.dto.EigentuemerRequest;
import com.example.infrastruktur.application.dto.EigentuemerResponse;
import com.example.infrastruktur.application.dto.LadepunktRequest;
import com.example.infrastruktur.application.dto.LadepunktResponse;
import com.example.infrastruktur.application.exception.InfrastrukturAppException;

import java.util.List;

public interface InfrastrukturAppService {

    // Ladepunkt-Funktionen
    Integer ladepunktAnlegen(LadepunktRequest request);

    LadepunktResponse ladepunktFinden(Integer ladepunktId) throws InfrastrukturAppException;

    void ladepunktAktualisieren(Integer ladepunktId, LadepunktRequest neueDaten) throws InfrastrukturAppException;

    void ladepunktLoeschen(Integer ladepunktId) throws InfrastrukturAppException;

    List<LadepunktResponse> alleLadepunkteAnzeigen();

    // Eigentümer-Funktionen
    Integer eigentuemerAnlegen(EigentuemerRequest request);

    EigentuemerResponse eigentuemerFinden(Integer eigentuemerId) throws InfrastrukturAppException;

    void eigentuemerAktualisieren(Integer eigentuemerId, EigentuemerRequest neueDaten) throws InfrastrukturAppException;

    void eigentuemerLoeschen(Integer eigentuemerId) throws InfrastrukturAppException;

    List<EigentuemerResponse> alleEigentuemerAnzeigen();

    // Ansprechpartner-Funktionen
    Integer ansprechpartnerAnlegen(AnsprechpartnerRequest dto);

    AnsprechpartnerResponse ansprechpartnerFinden(Integer ansprechpartnerId) throws InfrastrukturAppException;

    void ansprechpartnerAktualisieren(Integer ansprechpartnerId, AnsprechpartnerRequest dto)
            throws InfrastrukturAppException;

    void ansprechpartnerLoeschen(Integer ansprechpartnerId) throws InfrastrukturAppException;

    List<AnsprechpartnerResponse> alleAnsprechpartnerFuerEigentuemer(Integer eigentuemerId);

    // RabbitMq-Funktionen
    void verarbeiteLadevorgang(int ladepunktId, double ladeleistungKWH);

}
