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

    // ------------------------------------------------------
    // Ladepunkt-Funktionen
    // ------------------------------------------------------

    int ladepunktAnlegen(LadepunktRequest request) throws InfrastrukturAppException;

    LadepunktResponse ladepunktFinden(int ladepunktId) throws InfrastrukturAppException;

    void ladepunktAktualisieren(int ladepunktId, LadepunktRequest neueDaten) throws InfrastrukturAppException;

    void ladepunktLoeschen(int ladepunktId) throws InfrastrukturAppException;

    List<LadepunktResponse> alleLadepunkteAnzeigen();

    // ------------------------------------------------------
    // Eigentuemer-Funktionen
    // ------------------------------------------------------

    int eigentuemerAnlegen(EigentuemerRequest request);

    EigentuemerResponse eigentuemerFinden(int eigentuemerId) throws InfrastrukturAppException;

    void eigentuemerAktualisieren(int eigentuemerId, EigentuemerRequest neueDaten) throws InfrastrukturAppException;

    void eigentuemerLoeschen(int eigentuemerId) throws InfrastrukturAppException;

    List<EigentuemerResponse> alleEigentuemerAnzeigen();

    // ------------------------------------------------------
    // Ansprechpartner-Funktionen
    // ------------------------------------------------------

    int ansprechpartnerAnlegen(AnsprechpartnerRequest dto);

    AnsprechpartnerResponse ansprechpartnerFinden(int ansprechpartnerId) throws InfrastrukturAppException;

    void ansprechpartnerAktualisieren(int ansprechpartnerId, AnsprechpartnerRequest dto)
            throws InfrastrukturAppException;

    void ansprechpartnerLoeschen(int ansprechpartnerId) throws InfrastrukturAppException;

    List<AnsprechpartnerResponse> alleAnsprechpartnerAnzeigen();

    List<AnsprechpartnerResponse> alleAnsprechpartnerFuerEigentuemer(int eigentuemerId);

    // ------------------------------------------------------
    // Event-Funktionen
    // ------------------------------------------------------
    void verarbeiteLadevorgang(int ladepunktId, double ladeleistungKWH);

}
