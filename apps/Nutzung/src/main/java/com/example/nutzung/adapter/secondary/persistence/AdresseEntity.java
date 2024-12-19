package com.example.nutzung.adapter.secondary.persistence;

import com.example.nutzung.application.domain.Adresse;

public class AdresseEntity {

    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;

    public AdresseEntity() {
        // Leerer Konstruktor für Reflection (Spring Data)
    }

    public AdresseEntity(String strasse, String hausnummer, String plz, String ort) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }

    /**
     * Convenience-Konstruktor, um direkt aus der Domain-Entität eine Entity zu
     * erstellen.
     */
    public AdresseEntity(Adresse domain) {
        this.strasse = domain.getStrasse();
        this.hausnummer = domain.getHausnummer();
        this.plz = domain.getPlz();
        this.ort = domain.getOrt();
    }

    /**
     * Wandelt diese Persistence-Entity in die Domain-Entität `Adresse` um.
     */
    public Adresse toDomain() {
        return new Adresse(
                this.strasse,
                this.hausnummer,
                this.plz,
                this.ort);
    }

    // Getter / Setter
    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

}
