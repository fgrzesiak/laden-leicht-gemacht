package com.example.infrastruktur.application.mapper;

import com.example.infrastruktur.adapter.secondary.persistence.LadepunktEntity;
import com.example.infrastruktur.application.domain.EigentuemerId;
import com.example.infrastruktur.application.domain.Ladepunkt;
import com.example.infrastruktur.application.domain.LadepunktId;
import com.example.infrastruktur.application.dto.LadepunktRequest;
import com.example.infrastruktur.application.dto.LadepunktResponse;

public class LadepunktMapper {

    public static LadepunktEntity toEntity(Ladepunkt ladepunkt) {
        return new LadepunktEntity(
                ladepunkt.getLadepunktId().getId(),
                ladepunkt.getEigentuemerId().getId(),
                AdresseMapper.toEntity(ladepunkt.getAdresse()),
                ladepunkt.getLadeleistungKW(),
                ladepunkt.getAnschlussart(),
                ladepunkt.getVerfuegbarkeit(),
                ladepunkt.getGesamtleistungKWH());
    }

    public static Ladepunkt toDomain(LadepunktEntity ladepunktEntity) {
        return new Ladepunkt(
                new LadepunktId(ladepunktEntity.getLadepunktId()),
                new EigentuemerId(ladepunktEntity.getEigentuemerId()),
                AdresseMapper.toDomain(ladepunktEntity.getAdresse()),
                ladepunktEntity.getLadeleistungKW(),
                ladepunktEntity.getAnschlussart(),
                ladepunktEntity.getVerfuegbarkeit(),
                ladepunktEntity.getGesamtleistungKWH());
    }

    public static Ladepunkt toDomain(LadepunktRequest ladepunktRequest) {
        return new Ladepunkt(
                new LadepunktId(),
                new EigentuemerId(ladepunktRequest.getEigentuemerId()),
                AdresseMapper.toDomain(ladepunktRequest.getAdresse()),
                ladepunktRequest.getLadeleistungKW(),
                ladepunktRequest.getAnschlussart(),
                ladepunktRequest.getVerfuegbarkeit().toString(),
                ladepunktRequest.getGesamtleistungKWH());
    }

    public static LadepunktResponse toResponse(Ladepunkt ladepunkt) {
        return new LadepunktResponse(
                ladepunkt.getLadepunktId().getId(),
                ladepunkt.getEigentuemerId().getId(),
                AdresseMapper.toDTO(ladepunkt.getAdresse()),
                ladepunkt.getLadeleistungKW(),
                ladepunkt.getAnschlussart(),
                ladepunkt.getVerfuegbarkeit(),
                ladepunkt.getGesamtleistungKWH());
    }
}