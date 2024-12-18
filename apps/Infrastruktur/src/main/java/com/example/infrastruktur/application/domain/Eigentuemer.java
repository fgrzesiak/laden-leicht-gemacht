package com.example.infrastruktur.application.domain;

/**
 * Entität für Grundstückseigentümer
 */
public class Eigentuemer {

    private EigentuemerId eigentuemerId;
    private String name;
    private Adresse adresse;

    public Eigentuemer(EigentuemerId eigentuemerId,
            String name,
            Adresse adresse) {
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.adresse = adresse;
    }

    // Getter/Setter
    public EigentuemerId getEigentuemerId() {
        return eigentuemerId;
    }

    public void setEigentuemerId(EigentuemerId id) {
        this.eigentuemerId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

}
