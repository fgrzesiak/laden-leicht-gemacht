package com.example.infrastruktur.application.dto;

/**
 * Repräsentiert das Response Data Transfer Object (DTO) für einen Eigentümer.
 */
public class EigentuemerResponse {

    private int eigentuemerId;
    private String name;
    private AdresseDTO adresse;

    public EigentuemerResponse() {
    }

    public EigentuemerResponse(int eigentuemerId, String name, AdresseDTO adresse) {
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.adresse = adresse;
    }

    public int getEigentuemerId() {
        return eigentuemerId;
    }

    public String getName() {
        return name;
    }

    public AdresseDTO getAdresse() {
        return adresse;
    }

}
