package com.example.nutzung.adapter.secondary.persistence;

public class AdresseEntity {

    private String strasse;
    private String hausnummer;
    private String plz;
    private String ort;

    public AdresseEntity() {
    }

    public AdresseEntity(String strasse, String hausnummer, String plz, String ort) {
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

}
