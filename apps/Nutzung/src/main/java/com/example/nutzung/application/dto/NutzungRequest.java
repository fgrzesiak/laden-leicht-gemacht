package com.example.nutzung.application.dto;

/**
 * Repräsentiert ein Request Data Transfer Object (DTO) für eine Nutzung.
 */
public class NutzungRequest {
    private String datum; // z. B. "2023-10-10"
    private int ladezeitMin;
    private int halterId;
    private double ladeleistungKWH; // muss berechnet werden

    public NutzungRequest() {
    }

    public NutzungRequest(String datum, int ladezeitMin, int halterId) {
        this.datum = datum;
        this.ladezeitMin = ladezeitMin;
        this.halterId = halterId;
    }

    public String getDatum() {
        return datum;
    }

    public int getLadezeitMin() {
        return ladezeitMin;
    }

    public int getHalterId() {
        return halterId;
    }

    public double getladeleistungKWH() {
        return ladeleistungKWH;
    }

    public void setladeleistungKWH(double ladeleistungKWH) {
        this.ladeleistungKWH = ladeleistungKWH;
    }
}
