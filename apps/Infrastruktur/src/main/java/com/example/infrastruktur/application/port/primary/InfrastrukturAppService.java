package com.example.infrastruktur.application.port.primary;

import com.example.infrastruktur.application.dto.AnsprechpartnerDto;
import com.example.infrastruktur.application.dto.EigentuemerRequest;
import com.example.infrastruktur.application.dto.EigentuemerResponse;
import com.example.infrastruktur.application.dto.LadepunktRequest;
import com.example.infrastruktur.application.dto.LadepunktResponse;

import java.util.List;

public interface InfrastrukturAppService {

    // Ladepunkt-Funktionen
    Integer ladepunktAnlegen(LadepunktRequest request);

    LadepunktResponse ladepunktFinden(Integer ladepunktId);

    boolean ladepunktAktualisieren(Integer ladepunktId, LadepunktRequest neueDaten);

    boolean ladepunktLoeschen(Integer ladepunktId);

    List<LadepunktResponse> alleLadepunkteAnzeigen();

    // Eigentümer-Funktionen
    Integer eigentuemerAnlegen(EigentuemerRequest request);

    EigentuemerResponse eigentuemerFinden(Integer eigentuemerId);

    boolean eigentuemerAktualisieren(Integer eigentuemerId, EigentuemerRequest neueDaten);

    boolean eigentuemerLoeschen(Integer eigentuemerId);

    List<EigentuemerResponse> alleEigentuemerAnzeigen();

    // Ansprechpartner-Funktionen
    Integer ansprechpartnerAnlegen(AnsprechpartnerDto dto);

    AnsprechpartnerDto ansprechpartnerFinden(Integer ansprechpartnerId);

    boolean ansprechpartnerAktualisieren(Integer ansprechpartnerId, AnsprechpartnerDto dto);

    boolean ansprechpartnerLoeschen(Integer ansprechpartnerId);

    List<AnsprechpartnerDto> alleAnsprechpartnerFuerEigentuemer(Integer eigentuemerId);

}
