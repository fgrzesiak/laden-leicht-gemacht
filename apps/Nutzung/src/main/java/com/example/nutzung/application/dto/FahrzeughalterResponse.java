package com.example.nutzung.application.dto;

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

    public void setHalterId(int halterId) {
        this.halterId = halterId;
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
