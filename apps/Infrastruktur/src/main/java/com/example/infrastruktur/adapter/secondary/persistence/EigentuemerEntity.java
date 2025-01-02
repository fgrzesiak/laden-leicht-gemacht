package com.example.infrastruktur.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import com.example.infrastruktur.application.domain.Eigentuemer;
import com.example.infrastruktur.application.domain.EigentuemerId;

public class EigentuemerEntity {

    @Id
    private int eigentuemerId;
    private String name;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private AdresseEntity adresse;

    public EigentuemerEntity() {
    }

    public EigentuemerEntity(int eigentuemerId, String name, AdresseEntity adresse) {
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.adresse = adresse;
    }

    public EigentuemerEntity(Eigentuemer eigentuemer) {
        this.eigentuemerId = eigentuemer.getEigentuemerId().getId();
        this.name = eigentuemer.getName();
        this.adresse = new AdresseEntity(eigentuemer.getAdresse());
    }

    public Eigentuemer toDomain() {
        return new Eigentuemer(
                new EigentuemerId(eigentuemerId),
                name,
                adresse.toDomain());
    }

    public int getEigentuemerId() {
        return eigentuemerId;
    }

    public String getName() {
        return name;
    }

    public AdresseEntity getAdresse() {
        return adresse;
    }
}
