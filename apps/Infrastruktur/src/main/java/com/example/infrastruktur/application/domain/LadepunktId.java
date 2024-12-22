package com.example.infrastruktur.application.domain;

/**
 * Value Object für die eindeutige ID eines Ladepunkts
 */
public class LadepunktId {

    private int id;

    public LadepunktId() {
    }

    public LadepunktId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
