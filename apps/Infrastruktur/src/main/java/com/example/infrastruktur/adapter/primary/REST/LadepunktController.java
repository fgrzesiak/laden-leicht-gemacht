package com.example.infrastruktur.adapter.primary.REST;

import com.example.infrastruktur.application.dto.LadepunktRequest;
import com.example.infrastruktur.application.dto.LadepunktResponse;
import com.example.infrastruktur.application.exception.InfrastrukturAppException;
import com.example.infrastruktur.application.port.primary.InfrastrukturAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für die Verwaltung von Ladepunkten.
 */
@RestController
@RequestMapping("/ladepunkte")
public class LadepunktController {

    private final InfrastrukturAppService service;

    public LadepunktController(InfrastrukturAppService service) {
        this.service = service;
    }

    /**
     * Legt einen neuen Ladepunkt an.
     *
     * @param ladepunktRequest die Daten des neuen Ladepunkts
     * @return eine ResponseEntity mit einer Bestätigungsnachricht und dem
     *         HTTP-Status 201 (Created)
     */
    @PostMapping
    public ResponseEntity<String> ladepunktAnlegen(@RequestBody LadepunktRequest ladepunktRequest) {
        Integer newId = service.ladepunktAnlegen(ladepunktRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Neuer Ladepunkt mit ID=" + newId + " angelegt.");
    }

    /**
     * Findet einen Ladepunkt anhand der ID.
     *
     * @param id die ID des Ladepunkts
     * @return eine ResponseEntity mit den Daten des Ladepunkts
     * @throws InfrastrukturAppException wenn der Ladepunkt nicht gefunden wird
     */
    @GetMapping("/{id}")
    public ResponseEntity<LadepunktResponse> ladepunktFinden(@PathVariable("id") Integer id)
            throws InfrastrukturAppException {
        return ResponseEntity.ok(service.ladepunktFinden(id));
    }

    /**
     * Liefert eine Liste aller Ladepunkte.
     *
     * @return eine Liste aller Ladepunkte
     */
    @GetMapping
    public List<LadepunktResponse> alleLadepunkte() {
        return service.alleLadepunkteAnzeigen();
    }

    /**
     * Aktualisiert die Daten eines Ladepunkts.
     *
     * @param id        die ID des Ladepunkts
     * @param neueDaten die neuen Daten des Ladepunkts
     * @return eine ResponseEntity mit einer Bestätigungsnachricht und dem
     *         HTTP-Status 200 (OK)
     * @throws InfrastrukturAppException wenn der Ladepunkt nicht gefunden wird
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> ladepunktAktualisieren(@PathVariable("id") Integer id,
            @RequestBody LadepunktRequest neueDaten) throws InfrastrukturAppException {
        service.ladepunktAktualisieren(id, neueDaten);
        return ResponseEntity.ok("Ladepunkt aktualisiert");
    }

    /**
     * Löscht einen Ladepunkt.
     *
     * @param id die ID des Ladepunkts
     * @return eine ResponseEntity mit einer Bestätigungsnachricht und dem
     *         HTTP-Status 200 (OK)
     * @throws InfrastrukturAppException wenn der Ladepunkt nicht gefunden wird
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> ladepunktLoeschen(@PathVariable("id") Integer id) throws InfrastrukturAppException {
        service.ladepunktLoeschen(id);
        return ResponseEntity.ok("Ladepunkt gelöscht");
    }
}
