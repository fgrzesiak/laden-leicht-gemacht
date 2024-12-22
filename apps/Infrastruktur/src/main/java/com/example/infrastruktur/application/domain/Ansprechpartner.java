package com.example.infrastruktur.application.domain;

/**
 * Repräsentiert einen Ansprechpartner (Value Object) mit Kontaktdaten.
 */
public class Ansprechpartner {

    private AnsprechpartnerId ansprechpartnerId;
    private EigentuemerId eigentuemerId;
    private String name;
    private String telefon;
    private String email;
    private Adresse adresse;

    public Ansprechpartner(AnsprechpartnerId ansprechpartnerId,
            EigentuemerId eigentuemerId,
            String name,
            String telefon,
            String email,
            Adresse adresse) {
        this.ansprechpartnerId = ansprechpartnerId;
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.telefon = telefon;
        this.email = email;
        this.adresse = adresse;
    }

    public AnsprechpartnerId getAnsprechpartnerId() {
        return ansprechpartnerId;
    }

    public void setAnsprechpartnerId(AnsprechpartnerId ansprechpartnerId) {
        this.ansprechpartnerId = ansprechpartnerId;
    }

    public EigentuemerId getEigentuemerId() {
        return eigentuemerId;
    }

    public void setEigentuemerId(EigentuemerId eigentuemerId) {
        this.eigentuemerId = eigentuemerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
