package com.example.nutzung.adapter.primary.REST;

import com.example.nutzung.application.dto.FahrzeughalterRequest;
import com.example.nutzung.application.dto.FahrzeughalterResponse;
import com.example.nutzung.application.exception.NutzungAppException;
import com.example.nutzung.application.port.primary.NutzungAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fahrzeughalter")
public class FahrzeughalterController {

    private final NutzungAppService service;

    public FahrzeughalterController(NutzungAppService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> halterAnlegen(@RequestBody FahrzeughalterRequest dto) {
        int newId = service.halterAnlegen(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Neuer Halter mit ID=" + newId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FahrzeughalterResponse> halterFinden(@PathVariable("id") int id) throws NutzungAppException {
        return ResponseEntity.ok(service.halterFinden(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> halterAktualisieren(@PathVariable("id") int id,
            @RequestBody FahrzeughalterRequest dto) throws NutzungAppException {
        service.halterAktualisieren(id, dto);
        return ResponseEntity.ok("Fahrzeughalter aktualisiert");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> halterLoeschen(@PathVariable("id") int id) throws NutzungAppException {
        service.halterLoeschen(id);
        return ResponseEntity.ok("Fahrzeughalter gelöscht");
    }

    @GetMapping
    public List<FahrzeughalterResponse> alleHalter() {
        return service.alleHalterAnzeigen();
    }
}
