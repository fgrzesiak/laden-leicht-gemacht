package com.example.infrastruktur.adapter.primary.REST;

import com.example.infrastruktur.application.dto.EigentuemerRequest;
import com.example.infrastruktur.application.dto.EigentuemerResponse;
import com.example.infrastruktur.application.exception.InfrastrukturAppException;
import com.example.infrastruktur.application.port.primary.InfrastrukturAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für die Verwaltung von Eigentümern.
 */
@RestController
@RequestMapping("/eigentuemer")
public class EigentuemerController {

    private final InfrastrukturAppService service;

    public EigentuemerController(InfrastrukturAppService service) {
        this.service = service;
    }

    /**
     * Legt einen neuen Eigentümer an
     *
     * @param eigentuemerDto Die Daten des neuen Eigentümers
     * @return ResponseEntity mit einer Nachricht und dem HTTP-Status
     */
    @PostMapping
    public ResponseEntity<String> eigentuemerAnlegen(@RequestBody EigentuemerRequest eigentuemerDto) {
        int newId = service.eigentuemerAnlegen(eigentuemerDto); // gibt String-ID zurück
        return ResponseEntity.status(HttpStatus.CREATED).body("Neuer Eigentümer mit ID=" + newId + " angelegt.");
    }

    /**
     * Findet einen Eigentümer anhand der ID
     *
     * @param id Die ID des Eigentümers
     * @return ResponseEntity mit den Daten des Eigentümers und dem HTTP-Status
     * @throws InfrastrukturAppException Wenn ein Fehler auftritt
     */
    @GetMapping("/{id}")
    public ResponseEntity<EigentuemerResponse> eigentuemerFinden(@PathVariable("id") int id)
            throws InfrastrukturAppException {
        return ResponseEntity.ok(service.eigentuemerFinden(id));
    }

    /**
     * Liefert eine Liste aller Eigentümer
     *
     * @return Liste aller Eigentümer
     */
    @GetMapping
    public List<EigentuemerResponse> alleEigentuemer() {
        return service.alleEigentuemerAnzeigen();
    }

    /**
     * Aktualisiert die Daten eines Eigentümers
     *
     * @param id             Die ID des Eigentümers
     * @param eigentuemerDto Die neuen Daten des Eigentümers
     * @return ResponseEntity mit einer Nachricht und dem HTTP-Status
     * @throws InfrastrukturAppException Wenn ein Fehler auftritt
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> eigentuemerAktualisieren(
            @PathVariable("id") int id,
            @RequestBody EigentuemerRequest eigentuemerDto) throws InfrastrukturAppException {
        service.eigentuemerAktualisieren(id, eigentuemerDto);
        return new ResponseEntity<>("Eigentümer aktualisiert", HttpStatus.OK);
    }

    /**
     * Löscht einen Eigentümer
     *
     * @param id Die ID des Eigentümers
     * @return ResponseEntity mit einer Nachricht und dem HTTP-Status
     * @throws InfrastrukturAppException Wenn ein Fehler auftritt
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eigentuemerLoeschen(@PathVariable("id") int id) throws InfrastrukturAppException {
        service.eigentuemerLoeschen(id);
        return new ResponseEntity<>("Eigentümer gelöscht", HttpStatus.OK);
    }
}
