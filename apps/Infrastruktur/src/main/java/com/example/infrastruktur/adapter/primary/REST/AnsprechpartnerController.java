package com.example.infrastruktur.adapter.primary.REST;

import com.example.infrastruktur.application.dto.AnsprechpartnerDto;
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

    @PostMapping("/{eigentuemerId}")
    public ResponseEntity<String> ansprechpartnerAnlegen(@RequestBody AnsprechpartnerDto dto) {
        Integer newId = service.ansprechpartnerAnlegen(dto);
        if (newId == null) {
            return new ResponseEntity<>("Eigentümer nicht gefunden", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Neuer Ansprechpartner mit ID=" + newId + " angelegt.", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnsprechpartnerDto> ansprechpartnerFinden(@PathVariable("id") Integer id) {
        AnsprechpartnerDto dto = service.ansprechpartnerFinden(id);
        if (dto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> ansprechpartnerAktualisieren(@PathVariable("id") Integer id,
            @RequestBody AnsprechpartnerDto dto) {
        boolean success = service.ansprechpartnerAktualisieren(id, dto);
        if (!success) {
            return new ResponseEntity<>("Ansprechpartner nicht gefunden", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Ansprechpartner aktualisiert");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> ansprechpartnerLoeschen(@PathVariable("id") Integer id) {
        boolean deleted = service.ansprechpartnerLoeschen(id);
        if (!deleted) {
            return new ResponseEntity<>("Ansprechpartner nicht gefunden", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Ansprechpartner gelöscht");
    }

    @GetMapping("/vonEigentuemer/{eigentuemerId}")
    public List<AnsprechpartnerDto> alleAnsprechpartnerFuerEigentuemer(
            @PathVariable("eigentuemerId") Integer eigentuemerId) {
        return service.alleAnsprechpartnerFuerEigentuemer(eigentuemerId);
    }
}
