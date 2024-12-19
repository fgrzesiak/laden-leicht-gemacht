package com.example.nutzung.application.port.secondary;

import com.example.nutzung.application.domain.Nutzung;
import com.example.nutzung.application.domain.NutzungId;
import com.example.nutzung.application.domain.FahrzeughalterId;

import java.util.List;

public interface NutzungRepository {
    Nutzung findById(NutzungId id);

    void save(Nutzung nutzung);

    void delete(NutzungId id);

    List<Nutzung> findAllByHalterId(FahrzeughalterId halterId);
}
