package com.example.nutzung.application.domain;

public class Ladepunkt {
    private LadepunktId ladepunktId;
    private double ladeleistungKW;
    private String verfuegbarkeit;

    public Ladepunkt(LadepunktId ladepunktId, double ladeleistungKW, String verfuegbarkeit) {
        this.ladepunktId = ladepunktId;
        this.ladeleistungKW = ladeleistungKW;
        this.verfuegbarkeit = verfuegbarkeit;
    }

    public LadepunktId getLadepunktId() {
        return ladepunktId;
    }

    public void setLadepunktId(LadepunktId ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public double getLadeleistungKW() {
        return ladeleistungKW;
    }

    public void setLadeleistungKW(double ladeleistungKW) {
        this.ladeleistungKW = ladeleistungKW;
    }

    public String getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public void setVerfuegbarkeit(String verfuegbarkeit) {
        this.verfuegbarkeit = verfuegbarkeit;
    }
}
