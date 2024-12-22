package com.example.nutzung.application.dto;

/**
 * Repräsentiert ein Request Data Transfer Object (DTO) für eine Nutzung.
 */
public class NutzungRequest {
    /** Das Datum der Nutzung im Format "YYYY-MM-DD" */
    private String datum;
    private int ladezeitMin;
    private int halterId;

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
}
