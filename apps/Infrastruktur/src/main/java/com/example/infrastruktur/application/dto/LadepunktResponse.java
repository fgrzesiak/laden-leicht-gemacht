package com.example.infrastruktur.application.dto;

/**
 * Repräsentiert das Response Data Transfer Object (DTO) für einen Ladepunkt.
 */
public class LadepunktResponse {
    private int ladepunktId;
    private int eigentuemerId;
    private double ladeleistungKW;
    private String anschlussart;
    private String verfuegbarkeit;
    private double gesamtleistungKWH;
    private AdresseDTO adresse;

    public LadepunktResponse() {
    }

    public LadepunktResponse(int ladepunktId, int eigentuemerId, AdresseDTO adresse, double ladeleistungKW,
            String anschlussart,
            String verfuegbarkeit, double gesamtleistungKWH) {
        this.ladepunktId = ladepunktId;
        this.eigentuemerId = eigentuemerId;
        this.adresse = adresse;
        this.ladeleistungKW = ladeleistungKW;
        this.anschlussart = anschlussart;
        this.verfuegbarkeit = verfuegbarkeit;
        this.gesamtleistungKWH = gesamtleistungKWH;
    }

    public int getLadepunktId() {
        return ladepunktId;
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

    public String getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public double getGesamtleistungKWH() {
        return gesamtleistungKWH;
    }
}
