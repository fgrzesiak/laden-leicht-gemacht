package com.example.nutzung.application.domain;

import java.util.Objects;

/**
 * Value Object für Adress-Daten
 */
public class Adresse {

    private final String strasse;
    private final String hausnummer;
    private final String plz;
    private final String ort;

    // Konstruktor mit allen nötigen Feldern
    public Adresse(String strasse, String hausnummer, String plz, String ort) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
    }

    // Getter
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

    // equals/hashCode, um es als Value-Object nutzen zu können
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Adresse))
            return false;
        Adresse adresse = (Adresse) o;
        return Objects.equals(strasse, adresse.strasse)
                && Objects.equals(hausnummer, adresse.hausnummer)
                && Objects.equals(plz, adresse.plz)
                && Objects.equals(ort, adresse.ort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strasse, hausnummer, plz, ort);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s %s", strasse, hausnummer, plz, ort);
    }
}
