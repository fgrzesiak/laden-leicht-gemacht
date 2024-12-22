package com.example.infrastruktur.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import com.example.infrastruktur.application.domain.Adresse;
import com.example.infrastruktur.application.domain.Eigentuemer;

public class EigentuemerEntity {

    @Id
    private int eigentuemerId;
    private String name;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private AdresseEntity adresse;

    public EigentuemerEntity() {
    }

    public EigentuemerEntity(int eigentuemerId, String name, Adresse adresse) {
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.adresse = new AdresseEntity(adresse);
    }

    public EigentuemerEntity(Eigentuemer domain) {
        this.eigentuemerId = domain.getEigentuemerId().getId();
        this.name = domain.getName();
        this.adresse = new AdresseEntity(domain.getAdresse());
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
