package com.example.infrastruktur.application.dto;

/**
 * DTO für REST-Kommunikation (Request) über Grundstückseigentümer
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

    public void setName(String name) {
        this.name = name;
    }

    public AdresseDTO getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDTO adresse) {
        this.adresse = adresse;
    }
}
