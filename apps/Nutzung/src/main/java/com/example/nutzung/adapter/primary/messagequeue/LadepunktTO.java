package com.example.nutzung.adapter.primary.messagequeue;

/**
 * Transfer Object für ein Ladepunkt-Event.
 * Hier z.B. ein fiktives "LadepunktAktualisiertEvent".
 */
public class LadepunktTO {

    private int ladepunktId;
    private double ladeleistungKW;
    private String verfuegbarkeit;

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
