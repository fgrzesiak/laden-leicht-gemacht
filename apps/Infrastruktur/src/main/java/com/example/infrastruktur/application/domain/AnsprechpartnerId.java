package com.example.infrastruktur.application.domain;

import java.util.Objects;

/**
 * Value Object für die eindeutige ID eines Ansprechpartners
 */
public class AnsprechpartnerId {

    private Integer id;

    public AnsprechpartnerId() {
        this.id = null;
    }

    public AnsprechpartnerId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AnsprechpartnerId))
            return false;
        AnsprechpartnerId ansprechpartnerId = (AnsprechpartnerId) o;
        return Objects.equals(id, ansprechpartnerId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
