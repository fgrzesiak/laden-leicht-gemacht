package com.example.nutzung.adapter.primary.REST;

import com.example.nutzung.application.dto.NutzungRequest;
import com.example.nutzung.application.dto.NutzungResponse;
import com.example.nutzung.application.port.primary.NutzungAppService;
import com.example.nutzung.application.exception.NutzungAppException;
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

    @PostMapping("/{ladepunktId}")
    public ResponseEntity<String> nutzungAnlegen(@PathVariable("ladepunktId") int id, @RequestBody NutzungRequest dto)
            throws NutzungAppException {
        int newId = service.nutzungAnlegen(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Neue Nutzung mit ID=" + newId);

    }

    @GetMapping("/{id}")
    public ResponseEntity<NutzungResponse> nutzungFinden(@PathVariable("id") int id) throws NutzungAppException {
        return ResponseEntity.ok(service.nutzungFinden(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> nutzungLoeschen(@PathVariable("id") int id) throws NutzungAppException {
        service.nutzungLoeschen(id);
        return ResponseEntity.ok("Nutzung gelöscht");
    }

    @GetMapping("/historie/{halterId}")
    public List<NutzungResponse> nutzungsHistorieFuerHalter(@PathVariable("halterId") int halterId)
            throws NutzungAppException {
        return service.nutzungsHistorieFuerHalter(halterId);
    }
}
