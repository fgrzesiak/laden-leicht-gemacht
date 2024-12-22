package com.example.nutzung.application.dto;

/**
 * Repräsentiert ein Response Data Transfer Object (DTO) für einen Ladepunkt.
 */
public class LadepunktResponse {
    private int ladepunktId;
    private double ladeleistungKW;
    private String verfuegbarkeit;

    public LadepunktResponse() {
    }

    public LadepunktResponse(int ladepunktId, double ladeleistungKW, String verfuegbarkeit) {
        this.ladepunktId = ladepunktId;
        this.ladeleistungKW = ladeleistungKW;
        this.verfuegbarkeit = verfuegbarkeit;
    }

    public int getLadepunktId() {
        return ladepunktId;
    }

    public void setLadepunktId(int ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public double getLadeleistungKW() {
        return ladeleistungKW;
    }

    public void setLadeleistungKW(double ladeleistungKw) {
        this.ladeleistungKW = ladeleistungKw;
    }

    public String getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public void setVerfuegbarkeit(String verfuegbarkeit) {
        this.verfuegbarkeit = verfuegbarkeit;
    }
}
