package com.example.infrastruktur.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import com.example.infrastruktur.application.domain.Adresse;
import com.example.infrastruktur.application.domain.Ladepunkt;

public class LadepunktEntity {

    @Id
    private int ladepunktId;
    private int eigentuemerId;
    private double ladeleistungKW;
    private String anschlussart;
    private String verfuegbarkeit;
    private double gesamtleistungKWH;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private AdresseEntity adresse;

    public LadepunktEntity() {
    }

    public LadepunktEntity(int ladepunktId, int eigentuemerId, Adresse adresse, double ladeleistungKW,
            String anschlussart, String verfuegbarkeit, double gesamtleistungKWH) {
        this.ladepunktId = ladepunktId;
        this.eigentuemerId = eigentuemerId;
        this.adresse = new AdresseEntity(adresse);
        this.ladeleistungKW = ladeleistungKW;
        this.anschlussart = anschlussart;
        this.verfuegbarkeit = verfuegbarkeit;
        this.gesamtleistungKWH = gesamtleistungKWH;
    }

    public LadepunktEntity(Ladepunkt domain) {
        this.ladepunktId = domain.getLadepunktId().getId();
        this.eigentuemerId = domain.getEigentuemerId().getId();
        this.adresse = new AdresseEntity(domain.getAdresse());
        this.ladeleistungKW = domain.getLadeleistungKW();
        this.anschlussart = domain.getAnschlussart();
        this.verfuegbarkeit = domain.getVerfuegbarkeit();
        this.gesamtleistungKWH = domain.getGesamtleistungKWH();
    }

    public int getLadepunktId() {
        return ladepunktId;
    }

    public int getEigentuemerId() {
        return eigentuemerId;
    }

    public AdresseEntity getAdresse() {
        return adresse;
    }

    public double getLadeleistungKW() {
        return ladeleistungKW;
    }

    public String getAnschlussart() {
        return anschlussart;
    }

    public String getVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public double getGesamtleistungKWH() {
        return gesamtleistungKWH;
    }
}
