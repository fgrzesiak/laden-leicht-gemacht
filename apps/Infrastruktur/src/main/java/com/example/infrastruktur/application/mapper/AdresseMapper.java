package com.example.infrastruktur.application.mapper;

import com.example.infrastruktur.adapter.secondary.persistence.AdresseEntity;
import com.example.infrastruktur.application.domain.Adresse;
import com.example.infrastruktur.application.dto.AdresseDTO;

public class AdresseMapper {

    public static Adresse toDomain(AdresseEntity entity) {
        return new Adresse(
                entity.getStrasse(),
                entity.getHausnummer(),
                entity.getPlz(),
                entity.getOrt());
    }

    public static Adresse toDomain(AdresseDTO adresseDto) {
        return new Adresse(
                adresseDto.getStrasse(),
                adresseDto.getHausnummer(),
                adresseDto.getPlz(),
                adresseDto.getOrt());
    }

    public static AdresseDTO toDTO(Adresse adresse) {
        return new AdresseDTO(
                adresse.getStrasse(),
                adresse.getHausnummer(),
                adresse.getPlz(),
                adresse.getOrt());
    }
}
