package com.example.infrastruktur.application.port.secondary;

/**
 * Transfer Object für ein Ladepunkt-Event.
 */
public class LadepunktTO {

    private int ladepunktId;
    private double ladeleistungKW;
    private String verfuegbarkeit;

    public LadepunktTO(int ladepunktId, double ladeleistungKW, String verfuegbarkeit) {
        this.ladepunktId = ladepunktId;
        this.ladeleistungKW = ladeleistungKW;
        this.verfuegbarkeit = verfuegbarkeit;

    }

    public int getLadepunktId() {
        return ladepunktId;
    }

    public double getLadeleistungKW() {
        return ladeleistungKW;
    }

    public String getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public void setLadepunktId(int ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public void setLadeleistungKW(double ladeleistungKW) {
        this.ladeleistungKW = ladeleistungKW;
    }

    public void setVerfuegbarkeit(String verfuegbarkeit) {
        this.verfuegbarkeit = verfuegbarkeit;
    }
}
