package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

import com.example.nutzung.application.domain.Ladepunkt;
import com.example.nutzung.application.domain.LadepunktId;

public class LadepunktEntity implements Persistable<Integer> {
    @Id
    private int ladepunktId;
    private double ladeleistungKW;
    private String verfuegbarkeit;

    @Transient
    private boolean isNew = true;

    public LadepunktEntity() {
    }

    public LadepunktEntity(int ladepunktId, double ladeleistungKW, String verfuegbarkeit) {
        this.ladepunktId = ladepunktId;
        this.ladeleistungKW = ladeleistungKW;
        this.verfuegbarkeit = verfuegbarkeit;
    }

    public LadepunktEntity(Ladepunkt ladepunkt) {
        this.ladepunktId = ladepunkt.getLadepunktId().getId();
        this.ladeleistungKW = ladepunkt.getLadeleistungKW();
        this.verfuegbarkeit = ladepunkt.getVerfuegbarkeit();
    }

    public Ladepunkt toDomain() {
        return new Ladepunkt(new LadepunktId(ladepunktId), ladeleistungKW, verfuegbarkeit);
    }

    public void setLadepunktId(int ladepunktId) {
        this.ladepunktId = ladepunktId;
    }

    public double getLadeleistungKW() {
        return ladeleistungKW;
    }

    public void setLadeleistungKW(double ladeleistungKW) {
        this.ladeleistungKW = ladeleistungKW;
    }

    public String getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public void setVerfuegbarkeit(String verfuegbarkeit) {
        this.verfuegbarkeit = verfuegbarkeit;
    }

    @Override
    public Integer getId() {
        return Integer.valueOf(ladepunktId);
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }
}
