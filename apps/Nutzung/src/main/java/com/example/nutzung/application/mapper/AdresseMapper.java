package com.example.nutzung.application.mapper;

import com.example.nutzung.adapter.secondary.persistence.AdresseEntity;
import com.example.nutzung.application.domain.Adresse;
import com.example.nutzung.application.dto.AdresseDTO;

public class AdresseMapper {

    public static AdresseEntity toEntity(Adresse adresse) {
        return new AdresseEntity(
                adresse.getStrasse(),
                adresse.getHausnummer(),
                adresse.getPlz(),
                adresse.getOrt());
    }

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
