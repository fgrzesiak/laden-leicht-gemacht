package com.example.infrastruktur.adapter.primary.REST;

import com.example.infrastruktur.application.dto.AnsprechpartnerRequest;
import com.example.infrastruktur.application.dto.AnsprechpartnerResponse;
import com.example.infrastruktur.application.exception.InfrastrukturAppException;
import com.example.infrastruktur.application.port.primary.InfrastrukturAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für die Verwaltung von Ansprechpartnern.
 */
@RestController
@RequestMapping("/ansprechpartner")
public class AnsprechpartnerController {

    private final InfrastrukturAppService service;

    public AnsprechpartnerController(InfrastrukturAppService service) {
        this.service = service;
    }

    /**
     * Legt einen neuen Ansprechpartner an.
     *
     * @param dto Die Daten des neuen Ansprechpartners.
     * @return Eine ResponseEntity mit der ID des neuen Ansprechpartners.
     */
    @PostMapping("/eigentuemer/{eigentuemerId}")
    public ResponseEntity<String> ansprechpartnerAnlegen(@RequestBody AnsprechpartnerRequest dto) {
        Integer newId = service.ansprechpartnerAnlegen(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Neuer Ansprechpartner mit ID=" + newId + " angelegt.");
    }

    /**
     * Findet einen Ansprechpartner anhand der ID.
     *
     * @param id Die ID des Ansprechpartners.
     * @return Eine ResponseEntity mit den Daten des Ansprechpartners.
     * @throws InfrastrukturAppException Wenn der Ansprechpartner nicht gefunden
     *                                   wird.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> ansprechpartnerFinden(@PathVariable("id") Integer id) throws InfrastrukturAppException {
        return ResponseEntity.ok(service.ansprechpartnerFinden(id));
    }

    /**
     * Aktualisiert die Daten eines Ansprechpartners.
     *
     * @param id  Die ID des Ansprechpartners.
     * @param dto Die neuen Daten des Ansprechpartners.
     * @return Eine ResponseEntity mit einer Bestätigungsmeldung.
     * @throws InfrastrukturAppException Wenn der Ansprechpartner nicht gefunden
     *                                   wird.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> ansprechpartnerAktualisieren(@PathVariable("id") Integer id,
            @RequestBody AnsprechpartnerRequest dto) throws InfrastrukturAppException {
        service.ansprechpartnerAktualisieren(id, dto);
        return new ResponseEntity<>("Ansprechpartner aktualisiert", HttpStatus.OK);
    }

    /**
     * Löscht einen Ansprechpartner anhand der ID.
     *
     * @param id Die ID des Ansprechpartners.
     * @return Eine ResponseEntity mit einer Bestätigungsmeldung.
     * @throws InfrastrukturAppException Wenn der Ansprechpartner nicht gefunden
     *                                   wird.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> ansprechpartnerLoeschen(@PathVariable("id") Integer id)
            throws InfrastrukturAppException {
        service.ansprechpartnerLoeschen(id);
        return new ResponseEntity<>("Ansprechpartner gelöscht", HttpStatus.OK);
    }

    /**
     * Findet alle Ansprechpartner für einen bestimmten Eigentümer.
     *
     * @param eigentuemerId Die ID des Eigentümers.
     * @return Eine Liste von Ansprechpartnern.
     */
    @GetMapping("/eigentuemer/{eigentuemerId}")
    public List<AnsprechpartnerResponse> alleAnsprechpartnerFuerEigentuemer(
            @PathVariable("eigentuemerId") Integer eigentuemerId) {
        return service.alleAnsprechpartnerFuerEigentuemer(eigentuemerId);
    }
}
