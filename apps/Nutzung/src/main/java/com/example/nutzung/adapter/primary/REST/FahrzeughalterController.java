package com.example.nutzung.adapter.primary.REST;

import com.example.nutzung.application.dto.FahrzeughalterRequest;
import com.example.nutzung.application.dto.FahrzeughalterResponse;
import com.example.nutzung.application.exception.NutzungAppException;
import com.example.nutzung.application.port.primary.NutzungAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für Fahrzeughalter-Operationen.
 */
@RestController
@RequestMapping("/fahrzeughalter")
public class FahrzeughalterController {

    private final NutzungAppService service;

    public FahrzeughalterController(NutzungAppService service) {
        this.service = service;
    }

    /**
     * Legt einen neuen Fahrzeughalter an.
     *
     * @param dto die Daten des neuen Fahrzeughalters
     * @return eine ResponseEntity mit der ID des neuen Fahrzeughalters
     */
    @PostMapping
    public ResponseEntity<String> halterAnlegen(@RequestBody FahrzeughalterRequest dto) {
        int newId = service.halterAnlegen(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Neuer Halter mit ID=" + newId + " angelegt");
    }

    /**
     * Findet einen Fahrzeughalter anhand der ID.
     *
     * @param id die ID des Fahrzeughalters
     * @return eine ResponseEntity mit den Daten des gefundenen Fahrzeughalters
     * @throws NutzungAppException wenn der Fahrzeughalter nicht gefunden wird
     */
    @GetMapping("/{id}")
    public ResponseEntity<FahrzeughalterResponse> halterFinden(@PathVariable("id") int id) throws NutzungAppException {
        return ResponseEntity.ok(service.halterFinden(id));
    }

    /**
     * Zeigt alle Fahrzeughalter an.
     *
     * @return eine Liste aller Fahrzeughalter
     */
    @GetMapping
    public List<FahrzeughalterResponse> alleHalter() {
        return service.alleHalterAnzeigen();
    }

    /**
     * Aktualisiert die Daten eines Fahrzeughalters.
     *
     * @param id  die ID des Fahrzeughalters
     * @param dto die neuen Daten des Fahrzeughalters
     * @return eine ResponseEntity mit einer Bestätigungsmeldung
     * @throws NutzungAppException wenn der Fahrzeughalter nicht gefunden wird
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> halterAktualisieren(@PathVariable("id") int id,
            @RequestBody FahrzeughalterRequest dto) throws NutzungAppException {
        service.halterAktualisieren(id, dto);
        return ResponseEntity.ok("Fahrzeughalter aktualisiert");
    }

    /**
     * Löscht einen Fahrzeughalter.
     *
     * @param id die ID des Fahrzeughalters
     * @return eine ResponseEntity mit einer Bestätigungsmeldung
     * @throws NutzungAppException wenn der Fahrzeughalter nicht gefunden wird
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> halterLoeschen(@PathVariable("id") int id) throws NutzungAppException {
        service.halterLoeschen(id);
        return ResponseEntity.ok("Fahrzeughalter gelöscht");
    }
}
