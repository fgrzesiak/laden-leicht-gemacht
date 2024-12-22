package com.example.infrastruktur.adapter.primary.REST;

import com.example.infrastruktur.application.dto.AnsprechpartnerRequest;
import com.example.infrastruktur.application.dto.AnsprechpartnerResponse;
import com.example.infrastruktur.application.exception.InfrastrukturAppException;
import com.example.infrastruktur.application.port.primary.InfrastrukturAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ansprechpartner")
public class AnsprechpartnerController {

    private final InfrastrukturAppService service;

    public AnsprechpartnerController(InfrastrukturAppService service) {
        this.service = service;
    }

    @PostMapping("/eigentuemer/{eigentuemerId}")
    public ResponseEntity<String> ansprechpartnerAnlegen(@RequestBody AnsprechpartnerRequest dto) {
        Integer newId = service.ansprechpartnerAnlegen(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Neuer Ansprechpartner mit ID=" + newId + " angelegt.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> ansprechpartnerFinden(@PathVariable("id") Integer id) throws InfrastrukturAppException {
        return ResponseEntity.ok(service.ansprechpartnerFinden(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> ansprechpartnerAktualisieren(@PathVariable("id") Integer id,
            @RequestBody AnsprechpartnerRequest dto) throws InfrastrukturAppException {
        service.ansprechpartnerAktualisieren(id, dto);
        return new ResponseEntity<>("Ansprechpartner aktualisiert", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> ansprechpartnerLoeschen(@PathVariable("id") Integer id)
            throws InfrastrukturAppException {
        service.ansprechpartnerLoeschen(id);
        return new ResponseEntity<>("Ansprechpartner gelöscht", HttpStatus.OK);
    }

    @GetMapping("/eigentuemer/{eigentuemerId}")
    public List<AnsprechpartnerResponse> alleAnsprechpartnerFuerEigentuemer(
            @PathVariable("eigentuemerId") Integer eigentuemerId) {
        return service.alleAnsprechpartnerFuerEigentuemer(eigentuemerId);
    }
}
