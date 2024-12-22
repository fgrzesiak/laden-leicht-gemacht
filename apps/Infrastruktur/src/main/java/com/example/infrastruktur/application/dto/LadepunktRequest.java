package com.example.infrastruktur.application.dto;

/**
 * Repräsentiert das Request Data Transfer Object (DTO) für einen Ladepunkt.
 */
public class LadepunktRequest {

    private int eigentuemerId;
    private double ladeleistungKW;
    private String anschlussart;
    private VerfuegbarkeitEnum verfuegbarkeit;
    private double gesamtleistungKWH;
    private AdresseDTO adresse;

    public LadepunktRequest() {
    }

    public LadepunktRequest(int eigentuemerId, AdresseDTO adresse, double ladeleistungKW, String anschlussart,
            VerfuegbarkeitEnum verfuegbarkeit,
            double gesamtleistungKWH) {
        this.eigentuemerId = eigentuemerId;
        this.adresse = adresse;
        this.ladeleistungKW = ladeleistungKW;
        this.anschlussart = anschlussart;
        this.verfuegbarkeit = verfuegbarkeit;
        this.gesamtleistungKWH = gesamtleistungKWH;
    }

    public int getEigentuemerId() {
        return eigentuemerId;
    }

    public AdresseDTO getAdresse() {
        return adresse;
    }

    public double getLadeleistungKW() {
        return ladeleistungKW;
    }

    public String getAnschlussart() {
        return anschlussart;
    }

    public VerfuegbarkeitEnum getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public double getGesamtleistungKWH() {
        return gesamtleistungKWH;
    }

}
