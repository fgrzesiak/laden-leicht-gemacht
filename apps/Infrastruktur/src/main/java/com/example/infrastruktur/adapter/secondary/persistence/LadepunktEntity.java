package com.example.infrastruktur.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import com.example.infrastruktur.application.domain.EigentuemerId;
import com.example.infrastruktur.application.domain.Ladepunkt;
import com.example.infrastruktur.application.domain.LadepunktId;

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

    public LadepunktEntity(int ladepunktId, int eigentuemerId, AdresseEntity adresse, double ladeleistungKW,
            String anschlussart, String verfuegbarkeit, double gesamtleistungKWH) {
        this.ladepunktId = ladepunktId;
        this.eigentuemerId = eigentuemerId;
        this.adresse = adresse;
        this.ladeleistungKW = ladeleistungKW;
        this.anschlussart = anschlussart;
        this.verfuegbarkeit = verfuegbarkeit;
        this.gesamtleistungKWH = gesamtleistungKWH;
    }

    public LadepunktEntity(Ladepunkt ladepunkt) {
        this.ladepunktId = ladepunkt.getLadepunktId().getId();
        this.eigentuemerId = ladepunkt.getEigentuemerId().getId();
        this.adresse = new AdresseEntity(ladepunkt.getAdresse());
        this.ladeleistungKW = ladepunkt.getLadeleistungKW();
        this.anschlussart = ladepunkt.getAnschlussart();
        this.verfuegbarkeit = ladepunkt.getVerfuegbarkeit();
        this.gesamtleistungKWH = ladepunkt.getGesamtleistungKWH();
    }

    public Ladepunkt toDomain() {
        return new Ladepunkt(
                new LadepunktId(ladepunktId),
                new EigentuemerId(eigentuemerId),
                adresse.toDomain(),
                ladeleistungKW,
                anschlussart,
                verfuegbarkeit,
                gesamtleistungKWH);
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
