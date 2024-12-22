package com.example.infrastruktur.adapter.primary.REST;

import com.example.infrastruktur.application.dto.LadepunktRequest;
import com.example.infrastruktur.application.dto.LadepunktResponse;
import com.example.infrastruktur.application.exception.InfrastrukturAppException;
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

    @PostMapping
    public ResponseEntity<String> ladepunktAnlegen(@RequestBody LadepunktRequest ladepunktRequest) {
        Integer newId = service.ladepunktAnlegen(ladepunktRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Neuer Ladepunkt mit ID=" + newId + " angelegt.");
    }

    /**
     * GET /ladepunkte/{id}
     * Holt einen Ladepunkt anhand seiner ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> ladepunktFinden(@PathVariable("id") Integer id) throws InfrastrukturAppException {
        return ResponseEntity.ok(service.ladepunktFinden(id));
    }

    /**
     * PUT /ladepunkte/{id}
     * Aktualisiert einen bestehenden Ladepunkt.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> ladepunktAktualisieren(@PathVariable("id") Integer id,
            @RequestBody LadepunktRequest neueDaten) throws InfrastrukturAppException {
        service.ladepunktAktualisieren(id, neueDaten);
        return new ResponseEntity<>("Ladepunkt aktualisiert", HttpStatus.OK);
    }

    /**
     * DELETE /ladepunkte/{id}
     * Löscht einen Ladepunkt.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> ladepunktLoeschen(@PathVariable("id") Integer id) throws InfrastrukturAppException {
        service.ladepunktLoeschen(id);
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
