package com.example.infrastruktur.application.domain;

public class Ladepunkt {

    private LadepunktId ladepunktId;
    private EigentuemerId eigentuemerId;
    private Adresse adresse;
    private double ladeleistungKW;
    private String anschlussart;
    private String verfuegbarkeit;
    private double gesamtleistungKWH;

    public Ladepunkt(
            LadepunktId ladepunktId,
            EigentuemerId eigentuemerId,
            Adresse adresse,
            double ladeleistungKW,
            String anschlussart,
            String verfuegbarkeit,
            double gesamtleistungKWH) {
        this.ladepunktId = ladepunktId;
        this.eigentuemerId = eigentuemerId;
        this.adresse = adresse;
        this.ladeleistungKW = ladeleistungKW;
        this.anschlussart = anschlussart;
        this.verfuegbarkeit = verfuegbarkeit;
        this.gesamtleistungKWH = gesamtleistungKWH;
    }

    public LadepunktId getLadepunktId() {
        return ladepunktId;
    }

    public void setLadepunktId(LadepunktId ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public EigentuemerId getEigentuemerId() {
        return eigentuemerId;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public double getLadeleistungKW() {
        return ladeleistungKW;
    }

    public String getAnschlussart() {
        return anschlussart;
    }

    public String getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public double getGesamtleistungKWH() {
        return gesamtleistungKWH;
    }

    public void verarbeiteLadevorgang(double kwh) {
        this.gesamtleistungKWH += kwh;
    }
}
