package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;

import com.example.nutzung.application.domain.FahrzeughalterId;
import com.example.nutzung.application.domain.LadepunktId;
import com.example.nutzung.application.domain.Nutzung;
import com.example.nutzung.application.domain.NutzungId;

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

    public NutzungEntity(Nutzung nutzung) {
        this.nutzungsId = nutzung.getNutzungsId().getId();
        this.ladepunktId = nutzung.getLadepunktId().getId();
        this.datum = nutzung.getDatum();
        this.ladezeitMin = nutzung.getLadezeitMin();
        this.ladeleistungKWH = nutzung.getLadeleistungKWH();
        this.halterId = nutzung.getHalterId().getId();
    }

    public Nutzung toDomain() {
        return new Nutzung(
                new NutzungId(nutzungsId),
                new LadepunktId(halterId),
                datum,
                ladezeitMin,
                ladeleistungKWH,
                new FahrzeughalterId(halterId));
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
