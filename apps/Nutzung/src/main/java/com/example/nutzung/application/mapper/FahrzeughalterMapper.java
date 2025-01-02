package com.example.nutzung.application.mapper;

import com.example.nutzung.application.domain.Fahrzeughalter;
import com.example.nutzung.application.domain.FahrzeughalterId;
import com.example.nutzung.application.dto.FahrzeughalterRequest;
import com.example.nutzung.application.dto.FahrzeughalterResponse;

public class FahrzeughalterMapper {

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
