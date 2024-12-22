package com.example.nutzung.application.dto;

/**
 * Repräsentiert ein Response Data Transfer Object (DTO) für eine Nutzung.
 */
public class NutzungResponse {
    private int nutzungsId;
    private int ladepunktId;
    private String datum; // z. B. "2023-10-10"
    private int ladezeitMin;
    private double ladeleistungKWH;
    private int halterId;

    public NutzungResponse() {
    }

    public NutzungResponse(int nutzungsId, int ladepunktId, String datum, int ladezeitMin, double ladeleistungKWH,
            int halterId) {
        this.nutzungsId = nutzungsId;
        this.ladepunktId = ladepunktId;
        this.datum = datum;
        this.ladezeitMin = ladezeitMin;
        this.ladeleistungKWH = ladeleistungKWH;
        this.halterId = halterId;
    }

    public int getNutzungsId() {
        return nutzungsId;
    }

    public void setNutzungsId(int nutzungsId) {
        this.nutzungsId = nutzungsId;
    }

    public int getLadepunktId() {
        return ladepunktId;
    }

    public void setLadepunktId(int ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getLadezeitMin() {
        return ladezeitMin;
    }

    public void setLadezeitMin(int ladezeitMin) {
        this.ladezeitMin = ladezeitMin;
    }

    public double getladeleistungKWH() {
        return ladeleistungKWH;
    }

    public void setladeleistungKWH(double ladeleistungKWH) {
        this.ladeleistungKWH = ladeleistungKWH;
    }

    public int getHalterId() {
        return halterId;
    }

    public void setHalterId(int halterId) {
        this.halterId = halterId;
    }
}
