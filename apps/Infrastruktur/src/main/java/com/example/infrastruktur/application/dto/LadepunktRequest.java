package com.example.infrastruktur.application.dto;

public class LadepunktRequest {

    private Integer eigentuemerId;
    private Double ladeleistungKW;
    private String anschlussart;
    private String verfuegbarkeit;
    private Double gesamtleistungKWH;
    private AdresseDTO adresse;

    public LadepunktRequest() {
    }

    public LadepunktRequest(Integer eigentuemerId, AdresseDTO adresse, Double ladeleistungKW, String anschlussart,
            String verfuegbarkeit,
            Double gesamtleistungKWH) {
        this.eigentuemerId = eigentuemerId;
        this.adresse = adresse;
        this.ladeleistungKW = ladeleistungKW;
        this.anschlussart = anschlussart;
        this.verfuegbarkeit = verfuegbarkeit;
        this.gesamtleistungKWH = gesamtleistungKWH;
    }

    public Integer getEigentuemerId() {
        return eigentuemerId;
    }

    public void setEigentuemerId(Integer eigentuemerId) {
        this.eigentuemerId = eigentuemerId;
    }

    public AdresseDTO getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDTO adresse) {
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
}
