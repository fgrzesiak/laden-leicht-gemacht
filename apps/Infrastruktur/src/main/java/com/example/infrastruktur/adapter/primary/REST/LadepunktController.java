package com.example.infrastruktur.adapter.primary.REST;

import com.example.infrastruktur.application.dto.LadepunktRequest;
import com.example.infrastruktur.application.dto.LadepunktResponse;
import com.example.infrastruktur.application.port.primary.InfrastrukturAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ladepunkte")
public class LadepunktController {

    private final InfrastrukturAppService service;

    public LadepunktController(InfrastrukturAppService service) {
        this.service = service;
    }

    /**
     * POST /ladepunkte
     * Legt einen neuen Ladepunkt an.
     */
    @PostMapping
    public ResponseEntity<String> ladepunktAnlegen(@RequestBody LadepunktRequest ladepunktRequest) {
        // print json
        System.out.println(ladepunktRequest);
        Integer newId = service.ladepunktAnlegen(ladepunktRequest);
        return new ResponseEntity<>("Neuer Ladepunkt mit ID=" + newId + " angelegt.", HttpStatus.CREATED);
    }

    /**
     * GET /ladepunkte/{id}
     * Holt einen Ladepunkt anhand seiner ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> ladepunktFinden(@PathVariable("id") Integer id) {
        LadepunktResponse ladepunkt = service.ladepunktFinden(id);
        if (ladepunkt == null) {
            return new ResponseEntity<>("Ladepunkt nicht gefunden", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ladepunkt, HttpStatus.OK);
    }

    /**
     * PUT /ladepunkte/{id}
     * Aktualisiert einen bestehenden Ladepunkt.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> ladepunktAktualisieren(
            @PathVariable("id") Integer id,
            @RequestBody LadepunktRequest neueDaten) {
        boolean success = service.ladepunktAktualisieren(id, neueDaten);
        if (!success) {
            return new ResponseEntity<>("Ladepunkt nicht gefunden", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Ladepunkt aktualisiert", HttpStatus.OK);
    }

    /**
     * DELETE /ladepunkte/{id}
     * Löscht einen Ladepunkt.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> ladepunktLoeschen(@PathVariable("id") Integer id) {
        boolean deleted = service.ladepunktLoeschen(id);
        if (!deleted) {
            return new ResponseEntity<>("Ladepunkt nicht gefunden", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Ladepunkt gelöscht", HttpStatus.OK);
    }

    /**
     * GET /ladepunkte
     * Liefert eine Liste aller Ladepunkte.
     */
    @GetMapping
    public List<LadepunktResponse> alleLadepunkte() {
        return service.alleLadepunkteAnzeigen();
    }
}
