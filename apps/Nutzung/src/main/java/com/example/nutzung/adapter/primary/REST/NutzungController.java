package com.example.nutzung.adapter.primary.REST;

import com.example.nutzung.application.dto.NutzungRequest;
import com.example.nutzung.application.dto.NutzungResponse;
import com.example.nutzung.application.port.primary.NutzungAppService;
import com.example.nutzung.application.exception.NutzungAppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für die Verwaltung von Nutzungen.
 */
@RestController
@RequestMapping("/nutzung")
public class NutzungController {

    private final NutzungAppService service;

    public NutzungController(NutzungAppService service) {
        this.service = service;
    }

    /**
     * Legt eine neue Nutzung an.
     *
     * @param id  die ID des Ladepunkts
     * @param dto die Daten der neuen Nutzung
     * @return eine ResponseEntity mit der ID der neuen Nutzung
     * @throws NutzungAppException wenn ein Fehler auftritt
     */
    @PostMapping("/{ladepunktId}")
    public ResponseEntity<String> nutzungAnlegen(@PathVariable("ladepunktId") int id, @RequestBody NutzungRequest dto)
            throws NutzungAppException {
        int newId = service.nutzungAnlegen(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Neue Nutzung mit ID=" + newId);
    }

    /**
     * Findet eine Nutzung anhand ihrer ID.
     *
     * @param id die ID der Nutzung
     * @return eine ResponseEntity mit den Daten der Nutzung
     * @throws NutzungAppException wenn ein Fehler auftritt
     */
    @GetMapping("/{id}")
    public ResponseEntity<NutzungResponse> nutzungFinden(@PathVariable("id") int id) throws NutzungAppException {
        return ResponseEntity.ok(service.nutzungFinden(id));
    }

    /**
     * Gibt die Nutzungshistorie für einen Halter zurück.
     *
     * @param halterId die ID des Halters
     * @return eine Liste von NutzungResponse-Objekten
     * @throws NutzungAppException wenn ein Fehler auftritt
     */
    @GetMapping("/historie/{halterId}")
    public List<NutzungResponse> nutzungsHistorieFuerHalter(@PathVariable("halterId") int halterId)
            throws NutzungAppException {
        return service.nutzungsHistorieFuerHalter(halterId);
    }

    /**
     * Löscht eine Nutzung anhand ihrer ID.
     *
     * @param id die ID der Nutzung
     * @return eine ResponseEntity mit einer Bestätigungsmeldung
     * @throws NutzungAppException wenn ein Fehler auftritt
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> nutzungLoeschen(@PathVariable("id") int id) throws NutzungAppException {
        service.nutzungLoeschen(id);
        return ResponseEntity.ok("Nutzung gelöscht");
    }
}
