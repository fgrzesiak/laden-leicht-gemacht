package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import com.example.nutzung.application.domain.Adresse;
import com.example.nutzung.application.domain.Fahrzeughalter;
import com.example.nutzung.application.domain.FahrzeughalterId;

public class FahrzeughalterEntity {
    @Id
    private int halterId;
    private String name;
    private String bankverbindung;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private AdresseEntity adresse;

    public FahrzeughalterEntity() {
    }

    public FahrzeughalterEntity(int halterId, String name, String bankverbindung, Adresse adresse) {
        this.halterId = halterId;
        this.name = name;
        this.bankverbindung = bankverbindung;
        this.adresse = new AdresseEntity(adresse);
    }

    public FahrzeughalterEntity(Fahrzeughalter domain) {
        this.halterId = domain.getHalterId().getId();
        this.name = domain.getName();
        this.bankverbindung = domain.getBankverbindung();
        this.adresse = new AdresseEntity(domain.getAdresse());
    }

    public Fahrzeughalter toDomain() {
        return new Fahrzeughalter(
                new FahrzeughalterId(this.halterId),
                this.name,
                this.bankverbindung,
                this.adresse.toDomain());
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

    public AdresseEntity getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseEntity adresse) {
        this.adresse = adresse;
    }

    public String getBankverbindung() {
        return bankverbindung;
    }

    public void setBankverbindung(String bankverbindung) {
        this.bankverbindung = bankverbindung;
    }

}
