package com.example.nutzung.application.mapper;

import com.example.nutzung.adapter.secondary.persistence.FahrzeughalterEntity;
import com.example.nutzung.application.domain.Fahrzeughalter;
import com.example.nutzung.application.domain.FahrzeughalterId;
import com.example.nutzung.application.dto.FahrzeughalterRequest;
import com.example.nutzung.application.dto.FahrzeughalterResponse;

public class FahrzeughalterMapper {

    public static FahrzeughalterEntity toEntity(Fahrzeughalter fahrzeughalter) {
        return new FahrzeughalterEntity(
                fahrzeughalter.getHalterId().getId(),
                fahrzeughalter.getName(),
                fahrzeughalter.getBankverbindung(),
                AdresseMapper.toEntity(fahrzeughalter.getAdresse()));
    }

    public static Fahrzeughalter toDomain(FahrzeughalterEntity fahrzeughalterEntity) {
        return new Fahrzeughalter(
                new FahrzeughalterId(fahrzeughalterEntity.getHalterId()),
                fahrzeughalterEntity.getName(),
                fahrzeughalterEntity.getBankverbindung(),
                AdresseMapper.toDomain(fahrzeughalterEntity.getAdresse()));
    }

    public static Fahrzeughalter toDomain(FahrzeughalterRequest fahrzeughalterRequest) {
        return new Fahrzeughalter(
                new FahrzeughalterId(),
                fahrzeughalterRequest.getName(),
                fahrzeughalterRequest.getBankverbindung(),
                AdresseMapper.toDomain(fahrzeughalterRequest.getAdresse()));
    }

    public static FahrzeughalterResponse toResponse(Fahrzeughalter fahrzeughalter) {
        return new FahrzeughalterResponse(
                fahrzeughalter.getHalterId().getId(),
                fahrzeughalter.getName(),
                fahrzeughalter.getBankverbindung(),
                AdresseMapper.toDTO(fahrzeughalter.getAdresse()));
    }
}
