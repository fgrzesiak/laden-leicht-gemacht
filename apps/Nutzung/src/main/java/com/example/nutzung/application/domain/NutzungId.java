package com.example.nutzung.application.domain;

import java.util.Objects;

public class NutzungId {
    private int id;

    public NutzungId() {
    }

    public NutzungId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof NutzungId))
            return false;
        NutzungId nutzungId = (NutzungId) o;
        return Objects.equals(id, nutzungId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
