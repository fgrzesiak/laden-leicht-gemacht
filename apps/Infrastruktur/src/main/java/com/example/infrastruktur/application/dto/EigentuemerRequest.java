package com.example.infrastruktur.application.dto;

/**
 * DTO für REST-Kommunikation (Request) über Grundstückseigentümer
 */
public class EigentuemerRequest {

    private String name;
    private AdresseDto adresse;

    public EigentuemerRequest() {
    }

    public EigentuemerRequest(String name, AdresseDto adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }
}
