package com.example.infrastruktur.application.domain;

/**
 * Entität (Aggregate Root), die einen Ladepunkt repräsentiert
 */
public class Ladepunkt {

    private LadepunktId ladepunktId;
    private EigentuemerId eigentuemerId;
    private Adresse adresse; // z. B. "Musterstraße 1, 12345 Stadt"
    private Double ladeleistungKW; // z. B. 22.0
    private String anschlussart; // z. B. "Typ 2", "CCS"
    private String verfuegbarkeit; // z. B. "verfügbar", "in Wartung"
    private Double gesamtleistungKWH; // Summe aller geladenen kWh

    public Ladepunkt(
            LadepunktId ladepunktId,
            EigentuemerId eigentuemerId,
            Adresse adresse,
            Double ladeleistungKW,
            String anschlussart,
            String verfuegbarkeit,
            Double gesamtleistungKWH) {
        this.ladepunktId = ladepunktId;
        this.eigentuemerId = eigentuemerId;
        this.adresse = adresse;
        this.ladeleistungKW = ladeleistungKW;
        this.anschlussart = anschlussart;
        this.verfuegbarkeit = verfuegbarkeit;
        this.gesamtleistungKWH = gesamtleistungKWH != null ? gesamtleistungKWH : 0.0;
    }

    // Fachlogik, z. B. Wartung starten
    public void setzeInWartung() {
        this.verfuegbarkeit = "in Wartung";
    }

    // Getter/Setter
    public LadepunktId getLadepunktId() {
        return ladepunktId;
    }

    public void setLadepunktId(LadepunktId ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public EigentuemerId getEigentuemerId() {
        return eigentuemerId;
    }

    public void setEigentuemerId(EigentuemerId eigentuemerId) {
        this.eigentuemerId = eigentuemerId;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Double getLadeleistungKW() {
        return ladeleistungKW;
    }

    public void setLadeleistungKW(Double ladeleistungKW) {
        this.ladeleistungKW = ladeleistungKW;
    }

    public String getAnschlussart() {
        return anschlussart;
    }

    public void setAnschlussart(String anschlussart) {
        this.anschlussart = anschlussart;
    }

    public String getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public void setVerfuegbarkeit(String verfuegbarkeit) {
        this.verfuegbarkeit = verfuegbarkeit;
    }

    public Double getGesamtleistungKWH() {
        return gesamtleistungKWH;
    }

    public void setGesamtleistungKWH(Double gesamtleistungKWH) {
        this.gesamtleistungKWH = gesamtleistungKWH;
    }

    public void verarbeiteLadevorgang(double kwh) {
        this.gesamtleistungKWH += kwh;
    }
}
