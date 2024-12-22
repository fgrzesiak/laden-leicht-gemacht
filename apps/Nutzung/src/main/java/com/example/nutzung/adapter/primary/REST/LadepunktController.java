package com.example.nutzung.adapter.primary.REST;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nutzung.application.dto.LadepunktResponse;
import com.example.nutzung.application.port.primary.NutzungAppService;

/**
 * REST-Controller für den Überblick über Ladepunkte.
 */
@RestController
@RequestMapping("/ladepunkte")
public class LadepunktController {

    private final NutzungAppService service;

    /**
     * Erstellt einen neuen LadepunktController mit dem angegebenen
     * NutzungAppService.
     * 
     * @param service der NutzungAppService, der von diesem Controller verwendet
     *                wird
     */
    public LadepunktController(NutzungAppService service) {
        this.service = service;
    }

    /**
     * Ruft eine Liste aller Ladepunkte ab.
     * 
     * @return eine Liste von LadepunktResponse-Objekten, die alle Ladepunkte
     *         darstellen
     */
    @GetMapping
    public List<LadepunktResponse> alleLadepunkte() {
        return service.alleLadepunkteAnzeigen();
    }

}
