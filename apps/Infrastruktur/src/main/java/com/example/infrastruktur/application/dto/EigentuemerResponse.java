package com.example.infrastruktur.application.dto;

/**
 * DTO für REST-Kommunikation (Request) über Grundstückseigentümer
 */
public class EigentuemerResponse {

    private Integer eigentuemerId;
    private String name;
    private AdresseDto adresse;

    public EigentuemerResponse() {
    }

    public EigentuemerResponse(Integer eigentuemerId, String name, AdresseDto adresse) {
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.adresse = adresse;
    }

    public Integer getEigentuemerId() {
        return eigentuemerId;
    }

    public void setEigentuemerId(Integer eigentuemerId) {
        this.eigentuemerId = eigentuemerId;
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
