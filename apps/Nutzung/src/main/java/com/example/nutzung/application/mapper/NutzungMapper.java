package com.example.nutzung.application.mapper;

import com.example.nutzung.adapter.secondary.persistence.NutzungEntity;
import com.example.nutzung.application.domain.FahrzeughalterId;
import com.example.nutzung.application.domain.LadepunktId;
import com.example.nutzung.application.domain.Nutzung;
import com.example.nutzung.application.domain.NutzungId;
import com.example.nutzung.application.dto.NutzungRequest;
import com.example.nutzung.application.dto.NutzungResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NutzungMapper {

    public static NutzungEntity toEntity(Nutzung nutzung) {
        return new NutzungEntity(
                nutzung.getNutzungsId().getId(),
                nutzung.getLadepunktId().getId(),
                nutzung.getDatum(),
                nutzung.getLadezeitMin(),
                nutzung.getladeleistungKWH(),
                nutzung.getHalterId().getId());
    }

    public static Nutzung toDomain(NutzungEntity nutzungEntity) {
        return new Nutzung(
                new NutzungId(nutzungEntity.getNutzungsId()),
                new LadepunktId(nutzungEntity.getLadepunktId()),
                nutzungEntity.getDatum(),
                nutzungEntity.getLadezeitMin(),
                nutzungEntity.getladeleistungKWH(),
                new FahrzeughalterId(nutzungEntity.getHalterId()));
    }

    public static Nutzung toDomain(int ladepunktId, NutzungRequest nutzungRequest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse(nutzungRequest.getDatum(), formatter);
        return new Nutzung(
                new NutzungId(),
                new LadepunktId(ladepunktId),
                datum,
                nutzungRequest.getLadezeitMin(),
                nutzungRequest.getladeleistungKWH(),
                new FahrzeughalterId(nutzungRequest.getHalterId()));
    }

    public static NutzungResponse toResponse(Nutzung nutzung) {
        return new NutzungResponse(
                nutzung.getNutzungsId().getId(),
                nutzung.getLadepunktId().getId(),
                nutzung.getDatum().toString(),
                nutzung.getLadezeitMin(),
                nutzung.getladeleistungKWH(),
                nutzung.getHalterId().getId());
    }
}
