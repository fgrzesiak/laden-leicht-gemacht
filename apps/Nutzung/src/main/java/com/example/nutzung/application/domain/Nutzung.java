package com.example.nutzung.application.domain;

import java.time.LocalDate;

public class Nutzung {

    private NutzungId nutzungsId;
    private int ladepunktId; // Referenz auf Ladepunkt (aus anderem Bounded Context)
    private LocalDate datum;
    private int ladezeitMin;
    private double ladeleistungKWH;
    private FahrzeughalterId halterId;

    public Nutzung(NutzungId nutzungsId,
            int ladepunktId,
            LocalDate datum,
            int ladezeitMin,
            double ladeleistungKWH,
            FahrzeughalterId halterId) {
        this.nutzungsId = nutzungsId;
        this.ladepunktId = ladepunktId;
        this.datum = datum;
        this.ladezeitMin = ladezeitMin;
        this.ladeleistungKWH = ladeleistungKWH;
        this.halterId = halterId;
    }

    public NutzungId getNutzungsId() {
        return nutzungsId;
    }

    public int getLadepunktId() {
        return ladepunktId;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public int getLadezeitMin() {
        return ladezeitMin;
    }

    public double getladeleistungKWH() {
        return ladeleistungKWH;
    }

    public FahrzeughalterId getHalterId() {
        return halterId;
    }
}
