package com.example.infrastruktur.application.mapper;

import com.example.infrastruktur.application.domain.Ansprechpartner;
import com.example.infrastruktur.application.domain.AnsprechpartnerId;
import com.example.infrastruktur.application.domain.EigentuemerId;
import com.example.infrastruktur.application.dto.AnsprechpartnerRequest;
import com.example.infrastruktur.application.dto.AnsprechpartnerResponse;

public class AnsprechpartnerMapper {

    public static Ansprechpartner toDomain(AnsprechpartnerRequest ansprechpartnerRequest) {
        return new Ansprechpartner(
                new AnsprechpartnerId(),
                new EigentuemerId(ansprechpartnerRequest.getEigentuemerId()),
                ansprechpartnerRequest.getName(),
                ansprechpartnerRequest.getTelefon(),
                ansprechpartnerRequest.getEmail(),
                AdresseMapper.toDomain(ansprechpartnerRequest.getAdresse()));
    }

    public static AnsprechpartnerResponse toResponse(Ansprechpartner ansprechpartner) {
        return new AnsprechpartnerResponse(
                ansprechpartner.getAnsprechpartnerId().getId(),
                ansprechpartner.getEigentuemerId().getId(),
                ansprechpartner.getName(),
                ansprechpartner.getTelefon(),
                ansprechpartner.getEmail(),
                AdresseMapper.toDTO(ansprechpartner.getAdresse()));
    }
}
