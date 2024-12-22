package com.example.nutzung.application.mapper;

import com.example.nutzung.adapter.secondary.persistence.LadepunktEntity;
import com.example.nutzung.application.domain.Ladepunkt;
import com.example.nutzung.application.domain.LadepunktId;
import com.example.nutzung.application.dto.LadepunktResponse;

public class LadepunktMapper {
    public static LadepunktEntity toEntity(Ladepunkt ladepunkt) {
        return new LadepunktEntity(
                ladepunkt.getLadepunktId().getId(),
                ladepunkt.getLadeleistungKW(),
                ladepunkt.getVerfuegbarkeit());
    }

    public static Ladepunkt toDomain(LadepunktEntity ladepunktEntity) {
        return new Ladepunkt(
                new LadepunktId(ladepunktEntity.getId()),
                ladepunktEntity.getLadeleistungKW(),
                ladepunktEntity.getVerfuegbarkeit());
    }

    public static LadepunktResponse toResponse(Ladepunkt ladepunkt) {
        return new LadepunktResponse(
                ladepunkt.getLadepunktId().getId(),
                ladepunkt.getLadeleistungKW(),
                ladepunkt.getVerfuegbarkeit());
    }
}
