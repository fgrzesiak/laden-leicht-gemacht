package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;

import com.example.nutzung.application.domain.Nutzung;
import com.example.nutzung.application.domain.NutzungId;
import com.example.nutzung.application.domain.FahrzeughalterId;
import com.example.nutzung.application.domain.LadepunktId;

import java.time.LocalDate;

public class NutzungEntity {

    @Id
    private Integer nutzungsId;
    private Integer ladepunktId;
    private LocalDate datum;
    private int ladezeitMin;
    private double ladeleistungKWH;
    private Integer halterId;

    public NutzungEntity() {
    }

    public NutzungEntity(Nutzung domain) {
        this.ladepunktId = domain.getLadepunktId().getId();
        this.datum = domain.getDatum();
        this.ladezeitMin = domain.getLadezeitMin();
        this.ladeleistungKWH = domain.getladeleistungKWH();
        this.halterId = Integer.valueOf(domain.getHalterId().getId());
    }

    public Nutzung toDomain() {
        NutzungId nid = new NutzungId(this.nutzungsId);
        FahrzeughalterId hid = new FahrzeughalterId(this.halterId);
        LadepunktId ladepunktId = new LadepunktId(this.ladepunktId);
        return new Nutzung(nid, ladepunktId, datum, ladezeitMin, ladeleistungKWH, hid);
    }

    public Integer getNutzungsId() {
        return nutzungsId;
    }

    public void setNutzungsId(Integer nutzungsId) {
        this.nutzungsId = nutzungsId;
    }

    public Integer getLadepunktId() {
        return ladepunktId;
    }

    public void setLadepunktId(Integer ladepunktId) {
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

    public Integer getHalterId() {
        return halterId;
    }

    public void setHalterId(Integer halterId) {
        this.halterId = halterId;
    }
}
