package com.example.nutzung.application.dto;

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

    public void setName(String name) {
        this.name = name;
    }

    public AdresseDTO getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDTO adresse) {
        this.adresse = adresse;
    }

    public String getBankverbindung() {
        return bankverbindung;
    }

    public void setBankverbindung(String bankverbindung) {
        this.bankverbindung = bankverbindung;
    }

}
