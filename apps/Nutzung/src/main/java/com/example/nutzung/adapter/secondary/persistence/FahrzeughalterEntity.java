package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

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

    public FahrzeughalterEntity(int halterId, String name, String bankverbindung, AdresseEntity adresse) {
        this.halterId = halterId;
        this.name = name;
        this.bankverbindung = bankverbindung;
        this.adresse = adresse;
    }

    public FahrzeughalterEntity(Fahrzeughalter halter) {
        this.halterId = halter.getHalterId().getId();
        this.name = halter.getName();
        this.bankverbindung = halter.getBankverbindung();
        this.adresse = new AdresseEntity(halter.getAdresse());
    }

    public Fahrzeughalter toDomain() {
        return new Fahrzeughalter(new FahrzeughalterId(halterId), name, bankverbindung, adresse.toDomain());
    }

    public int getHalterId() {
        return halterId;
    }

    public String getName() {
        return name;
    }

    public AdresseEntity getAdresse() {
        return adresse;
    }

    public String getBankverbindung() {
        return bankverbindung;
    }

}
