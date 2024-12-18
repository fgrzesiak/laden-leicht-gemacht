package com.example.infrastruktur.application.domain;

import java.util.Objects;

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

    // equals / hashCode (typisch für Value Objects)
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Ansprechpartner))
            return false;
        Ansprechpartner that = (Ansprechpartner) o;
        return Objects.equals(ansprechpartnerId, that.ansprechpartnerId) &&
                Objects.equals(eigentuemerId, that.eigentuemerId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(adresse, that.adresse) &&
                Objects.equals(telefon, that.telefon) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ansprechpartnerId, eigentuemerId, name, adresse, telefon, email);
    }
}
