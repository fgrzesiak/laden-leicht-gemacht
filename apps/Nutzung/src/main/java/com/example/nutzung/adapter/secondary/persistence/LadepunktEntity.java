package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;

import com.example.nutzung.application.domain.Ladepunkt;

public class LadepunktEntity {
    @Id
    private int ladepunktId;
    private double ladeleistungKW;
    private String verfuegbarkeit;

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

    public int getLadepunktId() {
        return ladepunktId;
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
}
