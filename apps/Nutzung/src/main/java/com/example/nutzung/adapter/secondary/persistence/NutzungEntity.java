package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;

import com.example.nutzung.application.domain.Nutzung;
import com.example.nutzung.application.domain.NutzungId;
import com.example.nutzung.application.domain.FahrzeughalterId;
import com.example.nutzung.application.domain.LadepunktId;

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

    public NutzungEntity(Nutzung domain) {
        this.ladepunktId = domain.getLadepunktId().getId();
        this.datum = domain.getDatum();
        this.ladezeitMin = domain.getLadezeitMin();
        this.ladeleistungKWH = domain.getladeleistungKWH();
        this.halterId = domain.getHalterId().getId();
    }

    public Nutzung toDomain() {
        NutzungId nid = new NutzungId(this.nutzungsId);
        FahrzeughalterId hid = new FahrzeughalterId(this.halterId);
        LadepunktId ladepunktId = new LadepunktId(this.ladepunktId);
        return new Nutzung(nid, ladepunktId, datum, ladezeitMin, ladeleistungKWH, hid);
    }

    public int getNutzungsId() {
        return nutzungsId;
    }

    public void setNutzungsId(int nutzungsId) {
        this.nutzungsId = nutzungsId;
    }

    public int getLadepunktId() {
        return ladepunktId;
    }

    public void setLadepunktId(int ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public int getLadezeitMin() {
        return ladezeitMin;
    }

    public void setLadezeitMin(int ladezeitMin) {
        this.ladezeitMin = ladezeitMin;
    }

    public double getladeleistungKWH() {
        return ladeleistungKWH;
    }

    public void setladeleistungKWH(double ladeleistungKWH) {
        this.ladeleistungKWH = ladeleistungKWH;
    }

    public int getHalterId() {
        return halterId;
    }

    public void setHalterId(int halterId) {
        this.halterId = halterId;
    }
}
