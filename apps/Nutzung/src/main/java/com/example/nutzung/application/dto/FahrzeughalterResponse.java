package com.example.nutzung.application.dto;

/**
 * Repräsentiert ein Response Data Transfer Object (DTO) für einen
 * Fahrzeughalter.
 */
public class FahrzeughalterResponse {
    private int halterId;
    private String name;
    private String bankverbindung;
    private AdresseDTO adresse;

    public FahrzeughalterResponse() {
    }

    public FahrzeughalterResponse(int halterId, String name, String bankverbindung, AdresseDTO adresse) {
        this.halterId = halterId;
        this.name = name;
        this.bankverbindung = bankverbindung;
        this.adresse = adresse;
    }

    public int getHalterId() {
        return halterId;
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
