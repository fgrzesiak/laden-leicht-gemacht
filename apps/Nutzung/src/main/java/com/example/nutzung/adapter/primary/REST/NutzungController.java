package com.example.nutzung.adapter.primary.REST;

import com.example.nutzung.application.dto.NutzungRequest;
import com.example.nutzung.application.dto.NutzungResponse;
import com.example.nutzung.application.port.primary.NutzungAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutzung")
public class NutzungController {

    private final NutzungAppService service;

    public NutzungController(NutzungAppService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> nutzungAnlegen(@RequestBody NutzungRequest dto) {
        int newId = service.nutzungAnlegen(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Neue Nutzung mit ID=" + newId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutzungResponse> nutzungFinden(@PathVariable("id") int id) {
        NutzungResponse dto = service.nutzungFinden(id);
        if (dto == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> nutzungLoeschen(@PathVariable("id") int id) {
        boolean deleted = service.nutzungLoeschen(id);
        if (!deleted)
            return new ResponseEntity<>("Nutzung nicht gefunden", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok("Nutzung gelöscht");
    }

    @GetMapping("/historie/{halterId}")
    public List<NutzungResponse> nutzungsHistorieFuerHalter(@PathVariable("halterId") int halterId) {
        return service.nutzungsHistorieFuerHalter(halterId);
    }
}
