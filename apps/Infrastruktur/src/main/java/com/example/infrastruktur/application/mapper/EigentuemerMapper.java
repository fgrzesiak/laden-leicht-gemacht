package com.example.infrastruktur.application.mapper;

import com.example.infrastruktur.adapter.secondary.persistence.EigentuemerEntity;
import com.example.infrastruktur.application.domain.Eigentuemer;
import com.example.infrastruktur.application.domain.EigentuemerId;
import com.example.infrastruktur.application.dto.EigentuemerRequest;
import com.example.infrastruktur.application.dto.EigentuemerResponse;

public class EigentuemerMapper {

    public static Eigentuemer toDomain(EigentuemerEntity eigentuemerEntity) {
        return new Eigentuemer(
                new EigentuemerId(eigentuemerEntity.getEigentuemerId()),
                eigentuemerEntity.getName(),
                AdresseMapper.toDomain(eigentuemerEntity.getAdresse()));
    }

    public static Eigentuemer toDomain(EigentuemerRequest eigentuemerRequest) {
        return new Eigentuemer(
                new EigentuemerId(),
                eigentuemerRequest.getName(),
                AdresseMapper.toDomain(eigentuemerRequest.getAdresse()));
    }

    public static EigentuemerResponse toResponse(Eigentuemer eigentuemer) {
        return new EigentuemerResponse(
                eigentuemer.getEigentuemerId().getId(),
                eigentuemer.getName(),
                AdresseMapper.toDTO(eigentuemer.getAdresse()));
    }

}