package com.example.nutzung.application.dto;

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

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getLadezeitMin() {
        return ladezeitMin;
    }

    public void setLadezeitMin(int ladezeitMin) {
        this.ladezeitMin = ladezeitMin;
    }

    public int getHalterId() {
        return halterId;
    }

    public void setHalterId(int halterId) {
        this.halterId = halterId;
    }

    public double getladeleistungKWH() {
        return ladeleistungKWH;
    }

    public void setladeleistungKWH(double ladeleistungKWH) {
        this.ladeleistungKWH = ladeleistungKWH;
    }
}
