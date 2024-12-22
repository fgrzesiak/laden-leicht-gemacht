package com.example.infrastruktur.application.dto;

/**
 * Repräsentiert das Response Data Transfer Object (DTO) für einen
 * Ansprechpartner.
 */
public class AnsprechpartnerResponse {
    private int ansprechpartnerId;
    private int eigentuemerId;
    private String name;
    private String telefon;
    private String email;
    private AdresseDTO adresse;

    public AnsprechpartnerResponse() {
    }

    public AnsprechpartnerResponse(int ansprechpartnerId, int eigentuemerId, String name, String telefon,
            String email,
            AdresseDTO adresse) {
        this.ansprechpartnerId = ansprechpartnerId;
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.telefon = telefon;
        this.email = email;
        this.adresse = adresse;
    }

    public int getAnsprechpartnerId() {
        return ansprechpartnerId;
    }

    public int getEigentuemerId() {
        return eigentuemerId;
    }

    public String getName() {
        return name;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public AdresseDTO getAdresse() {
        return adresse;
    }
}
