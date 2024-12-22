package com.example.infrastruktur.adapter.primary.REST;

import com.example.infrastruktur.application.dto.EigentuemerRequest;
import com.example.infrastruktur.application.dto.EigentuemerResponse;
import com.example.infrastruktur.application.exception.InfrastrukturAppException;
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
    public ResponseEntity<EigentuemerResponse> eigentuemerFinden(@PathVariable("id") Integer id)
            throws InfrastrukturAppException {
        return ResponseEntity.ok(service.eigentuemerFinden(id));
    }

    /**
     * PUT /eigentuemer/{id}
     * Aktualisiert Daten eines Eigentümers
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> eigentuemerAktualisieren(
            @PathVariable("id") Integer id,
            @RequestBody EigentuemerRequest eigentuemerDto) throws InfrastrukturAppException {
        service.eigentuemerAktualisieren(id, eigentuemerDto);
        return new ResponseEntity<>("Eigentümer aktualisiert", HttpStatus.OK);
    }

    /**
     * POST /eigentuemer
     * Legt einen neuen Eigentümer an
     */
    @PostMapping
    public ResponseEntity<String> eigentuemerAnlegen(@RequestBody EigentuemerRequest eigentuemerDto) {
        Integer newId = service.eigentuemerAnlegen(eigentuemerDto); // gibt String-ID zurück
        return ResponseEntity.status(HttpStatus.CREATED).body("Neuer Eigentümer mit ID=" + newId + " angelegt.");
    }

    /**
     * DELETE /eigentuemer/{id}
     * Löscht Eigentümer
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eigentuemerLoeschen(@PathVariable("id") Integer id) throws InfrastrukturAppException {
        service.eigentuemerLoeschen(id);
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
