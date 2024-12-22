package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import java.time.LocalDate;

public class NutzungEntity {

    @Id
    private int nutzungsId;
    private int ladepunktId;
    private LocalDate datum;
    private int ladezeitMin;
    private double ladeleistungKWH;
    private int halterId;

    public NutzungEntity() {
    }

    public NutzungEntity(int nutzungsId, int ladepunktId, LocalDate datum, int ladezeitMin, double ladeleistungKWH,
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

    public LocalDate getDatum() {
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
