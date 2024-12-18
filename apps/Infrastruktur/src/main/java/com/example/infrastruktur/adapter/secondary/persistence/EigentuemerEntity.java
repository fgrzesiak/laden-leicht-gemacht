package com.example.infrastruktur.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import com.example.infrastruktur.application.domain.Adresse;
import com.example.infrastruktur.application.domain.Eigentuemer;
import com.example.infrastruktur.application.domain.EigentuemerId;

public class EigentuemerEntity {

    @Id
    private Integer eigentuemerId;
    private String name;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private AdresseEntity adresse;

    // Bei Spring Data JDBC kann man ggf. eine separate Tabelle für Ansprechpartner
    // abbilden.
    // Hier vereinfachen wir, indem wir sie NICHT normalisiert in eine separate
    // Tabelle schieben
    // (Alternativ: One-to-Many Mapping in JDBC / JPA)

    // KEIN direkter Umgang mit Liste von Ansprechpartner im Entity, falls du es
    // nicht mit Join-Tabelle abbilden willst.
    // Evtl. brauchst du eine separate Tabelle + Mapping.

    public EigentuemerEntity() {
    }

    public EigentuemerEntity(Integer eigentuemerId, String name, Adresse adresse) {
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.adresse = new AdresseEntity(adresse);
    }

    /**
     * Convenience-Konstruktor zum Konvertieren aus Domain-Entität
     */
    public EigentuemerEntity(Eigentuemer domain) {
        this.eigentuemerId = domain.getEigentuemerId().getId();
        this.name = domain.getName();
        this.adresse = new AdresseEntity(domain.getAdresse());
        // Ansprechpartner-Liste müsste ggf. auch noch persistiert werden (eigenes
        // Mapping).
    }

    /**
     * Konvertierung ins Domain-Objekt
     */
    public Eigentuemer toDomain() {
        Eigentuemer domainObj = new Eigentuemer(
                new EigentuemerId(this.eigentuemerId),
                this.name,
                this.adresse.toDomain());
        // Falls Ansprechpartner existieren (hier nicht abgebildet), müssten wir
        // domainObj.addAnsprechpartner(...) aufrufen.
        return domainObj;
    }

    // Getter / Setter
    public Integer getEigentuemerId() {
        return eigentuemerId;
    }

    public void setEigentuemerId(Integer eigentuemerId) {
        this.eigentuemerId = eigentuemerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdresseEntity getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseEntity adresse) {
        this.adresse = adresse;
    }
}
