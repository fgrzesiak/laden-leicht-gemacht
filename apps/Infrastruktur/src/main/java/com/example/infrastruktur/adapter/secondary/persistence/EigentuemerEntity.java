package com.example.infrastruktur.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

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
