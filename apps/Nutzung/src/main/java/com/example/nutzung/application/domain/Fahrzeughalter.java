package com.example.nutzung.application.domain;

public class Fahrzeughalter {

    private FahrzeughalterId halterId;
    private String name;
    private String bankverbindung;
    private Adresse adresse;

    public Fahrzeughalter(FahrzeughalterId halterId, String name, String bankverbindung, Adresse adresse) {
        this.halterId = halterId;
        this.name = name;
        this.bankverbindung = bankverbindung;
        this.adresse = adresse;
    }

    public FahrzeughalterId getHalterId() {
        return halterId;
    }

    public void setHalterId(FahrzeughalterId halterId) {
        this.halterId = halterId;
    }

    public String getName() {
        return name;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getBankverbindung() {
        return bankverbindung;
    }

}
