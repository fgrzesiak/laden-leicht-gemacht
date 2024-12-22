package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

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

    public double getLadeleistungKW() {
        return ladeleistungKW;
    }

    public String getVerfuegbarkeit() {
        return verfuegbarkeit;
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
