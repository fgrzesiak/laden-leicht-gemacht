package com.example.nutzung.application.dto;

/**
 * Repräsentiert ein Request Data Transfer Object (DTO) für einen
 * Fahrzeughalter.
 */
public class FahrzeughalterRequest {
    private String name;
    private String bankverbindung;
    private AdresseDTO adresse;

    public FahrzeughalterRequest() {
    }

    public FahrzeughalterRequest(String name, String bankverbindung, AdresseDTO adresse) {
        this.name = name;
        this.bankverbindung = bankverbindung;
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }

    public AdresseDTO getAdresse() {
        return adresse;
    }

    public String getBankverbindung() {
        return bankverbindung;
    }

}
