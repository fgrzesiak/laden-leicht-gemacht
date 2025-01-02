package com.example.nutzung.application.mapper;

import com.example.nutzung.application.domain.Ladepunkt;
import com.example.nutzung.application.dto.LadepunktResponse;

public class LadepunktMapper {

    public static LadepunktResponse toResponse(Ladepunkt ladepunkt) {
        return new LadepunktResponse(
                ladepunkt.getLadepunktId().getId(),
                ladepunkt.getLadeleistungKW(),
                ladepunkt.getVerfuegbarkeit());
    }
}
