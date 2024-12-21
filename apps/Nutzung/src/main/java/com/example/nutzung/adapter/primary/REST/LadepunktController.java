package com.example.nutzung.adapter.primary.REST;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nutzung.application.dto.LadepunktResponse;
import com.example.nutzung.application.port.primary.NutzungAppService;

@RestController
@RequestMapping("/ladepunkte")
public class LadepunktController {

    private final NutzungAppService service;

    public LadepunktController(NutzungAppService service) {
        this.service = service;
    }

    @GetMapping
    public List<LadepunktResponse> alleLadepunkte() {
        return service.alleLadepunkteAnzeigen();
    }

}
