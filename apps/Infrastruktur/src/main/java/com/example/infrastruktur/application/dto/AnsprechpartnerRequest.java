package com.example.infrastruktur.application.dto;

/**
 * Repräsentiert das Request Data Transfer Object (DTO) für einen
 * Ansprechpartner.
 */
public class AnsprechpartnerRequest {
    private int eigentuemerId;
    private String name;
    private String telefon;
    private String email;
    private AdresseDTO adresse;

    public AnsprechpartnerRequest() {
    }

    public AnsprechpartnerRequest(int eigentuemerId, String name, String telefon, String email,
            AdresseDTO adresse) {
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.telefon = telefon;
        this.email = email;
        this.adresse = adresse;
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
