package com.example.infrastruktur.application.dto;

/**
 * Repräsentiert das Request Data Transfer Object (DTO) für einen Eigentümer.
 */
public class EigentuemerRequest {

    private String name;
    private AdresseDTO adresse;

    public EigentuemerRequest() {
    }

    public EigentuemerRequest(String name, AdresseDTO adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public AdresseDTO getAdresse() {
        return adresse;
    }

}
