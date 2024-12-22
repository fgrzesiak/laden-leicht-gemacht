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

    public int getLadepunktId() {
        return ladepunktId;
    }

    public String getDatum() {
        return datum;
    }

    public int getLadezeitMin() {
        return ladezeitMin;
    }

    public double getLadeleistungKWH() {
        return ladeleistungKWH;
    }

    public int getHalterId() {
        return halterId;
    }

}
