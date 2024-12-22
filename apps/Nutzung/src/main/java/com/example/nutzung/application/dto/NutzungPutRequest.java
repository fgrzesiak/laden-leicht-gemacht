package com.example.nutzung.application.dto;

/**
 * Repräsentiert ein Put Request Data Transfer Object (DTO) für eine Nutzung.
 */
public class NutzungPutRequest {
    private int ladepunktId;
    /** Das Datum der Nutzung im Format "YYYY-MM-DD" */
    private String datum;
    private int ladezeitMin;
    private int halterId;
    private double ladeleistungKWH;

    public NutzungPutRequest() {
    }

    public NutzungPutRequest(int ladepunktId, String datum, int ladezeitMin, int halterId, double ladeleistungKWH) {
        this.ladepunktId = ladepunktId;
        this.datum = datum;
        this.ladezeitMin = ladezeitMin;
        this.halterId = halterId;
        this.ladeleistungKWH = ladeleistungKWH;
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

    public int getHalterId() {
        return halterId;
    }

    public double getLadeleistungKWH() {
        return ladeleistungKWH;
    }
}
