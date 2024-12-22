package com.example.infrastruktur.adapter.primary.messagequeue;

/**
 * Transfer Object für ein Nutzung-Event.
 */
public class NutzungTO {

    private int ladepunktId;
    private double ladeleistungKWH;

    public int getLadepunktId() {
        return ladepunktId;
    }

    public double getLadeleistungKWH() {
        return ladeleistungKWH;
    }

}
