package com.example.infrastruktur.application.domain;

/**
 * Value Object für die eindeutige ID eines Eigentuemers
 */
public class EigentuemerId {

    private int id;

    public EigentuemerId() {
    }

    public EigentuemerId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
