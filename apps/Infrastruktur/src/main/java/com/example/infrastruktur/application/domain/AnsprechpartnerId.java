package com.example.infrastruktur.application.domain;

/**
 * Value Object für die eindeutige ID eines Ansprechpartners
 */
public class AnsprechpartnerId {

    private int id;

    public AnsprechpartnerId() {
    }

    public AnsprechpartnerId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
