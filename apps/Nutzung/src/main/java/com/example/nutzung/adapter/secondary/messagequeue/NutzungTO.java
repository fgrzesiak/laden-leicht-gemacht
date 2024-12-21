package com.example.nutzung.adapter.secondary.messagequeue;

/**
 * Transfer Object für ein Nutzung-Event.
 */
public class NutzungTO {

    private int ladepunktId;
    private double ladeleistungKWH;

    public NutzungTO(int ladepunktId, double ladeleistungKWH) {
        this.ladepunktId = ladepunktId;
        this.ladeleistungKWH = ladeleistungKWH;
    }

    public int getLadepunktId() {
        return ladepunktId;
    }

    public double getLadeleistungKWH() {
        return ladeleistungKWH;
    }

    public void setLadepunktId(int ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public void setLadeleistungKWH(double ladeleistungKWH) {
        this.ladeleistungKWH = ladeleistungKWH;
    }

}
