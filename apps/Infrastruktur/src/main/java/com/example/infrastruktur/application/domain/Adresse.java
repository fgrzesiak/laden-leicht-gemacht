package com.example.infrastruktur.application.domain;

/**
 * Value Object für Adress-Daten
 */
public class Adresse {

    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;

    public Adresse(String strasse, String hausnummer, String plz, String ort) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public String getPlz() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s %s", strasse, hausnummer, plz, ort);
    }
}
