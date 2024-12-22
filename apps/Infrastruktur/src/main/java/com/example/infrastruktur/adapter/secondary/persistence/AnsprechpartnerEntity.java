package com.example.infrastruktur.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

public class AnsprechpartnerEntity {

    @Id
    private int ansprechpartnerId;

    private int eigentuemerId;
    private String name;
    private String telefon;
    private String email;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private AdresseEntity adresse;

    public AnsprechpartnerEntity() {
    }

    public AnsprechpartnerEntity(int ansprechpartnerId, int eigentuemerId, String name, String telefon,
            String email, AdresseEntity adresse) {
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

    public AdresseEntity getAdresse() {
        return adresse;
    }
}
