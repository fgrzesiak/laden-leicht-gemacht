package com.example.infrastruktur.adapter.primary.REST;

import com.example.infrastruktur.application.dto.EigentuemerRequest;
import com.example.infrastruktur.application.dto.EigentuemerResponse;
import com.example.infrastruktur.application.port.primary.InfrastrukturAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eigentuemer")
public class EigentuemerController {

    private final InfrastrukturAppService service;

    public EigentuemerController(InfrastrukturAppService service) {
        this.service = service;
    }

    /**
     * GET /eigentuemer/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<EigentuemerResponse> eigentuemerFinden(@PathVariable("id") Integer id) {
        EigentuemerResponse eigentuemer = service.eigentuemerFinden(id);
        if (eigentuemer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(eigentuemer, HttpStatus.OK);
    }

    /**
     * PUT /eigentuemer/{id}
     * Aktualisiert Daten eines Eigentümers
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> eigentuemerAktualisieren(
            @PathVariable("id") Integer id,
            @RequestBody EigentuemerRequest eigentuemerDto) {
        boolean success = service.eigentuemerAktualisieren(id, eigentuemerDto);
        if (!success) {
            return new ResponseEntity<>("Eigentümer nicht gefunden", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Eigentümer aktualisiert", HttpStatus.OK);
    }

    /**
     * POST /eigentuemer
     * Legt einen neuen Eigentümer an
     */
    @PostMapping
    public ResponseEntity<String> eigentuemerAnlegen(@RequestBody EigentuemerRequest eigentuemerDto) {
        Integer newId = service.eigentuemerAnlegen(eigentuemerDto); // gibt String-ID zurück
        if (newId != null) {
            return new ResponseEntity<>("Neuer Eigentümer mit ID=" + newId + " angelegt.", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Fehler beim Anlegen des Eigentümers", HttpStatus.BAD_REQUEST);
    }

    /**
     * DELETE /eigentuemer/{id}
     * Löscht Eigentümer
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eigentuemerLoeschen(@PathVariable("id") Integer id) {
        boolean deleted = service.eigentuemerLoeschen(id);
        if (!deleted) {
            return new ResponseEntity<>("Eigentümer nicht gefunden", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Eigentümer gelöscht", HttpStatus.OK);
    }

    /**
     * GET /eigentuemer
     * Liefert alle Eigentümer
     */
    @GetMapping
    public List<EigentuemerResponse> alleEigentuemer() {
        return service.alleEigentuemerAnzeigen();
    }
}
