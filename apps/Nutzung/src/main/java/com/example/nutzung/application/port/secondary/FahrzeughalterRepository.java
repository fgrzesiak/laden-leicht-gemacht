package com.example.nutzung.application.port.secondary;

import com.example.nutzung.application.domain.Fahrzeughalter;
import com.example.nutzung.application.domain.FahrzeughalterId;

import java.util.List;

public interface FahrzeughalterRepository {
    Fahrzeughalter findById(FahrzeughalterId id);

    void save(Fahrzeughalter halter);

    void delete(FahrzeughalterId id);

    List<Fahrzeughalter> findAll();
}
