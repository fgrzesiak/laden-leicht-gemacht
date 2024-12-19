package com.example.nutzung.application.port.secondary;

import com.example.nutzung.application.domain.Ladepunkt;
import com.example.nutzung.application.domain.LadepunktId;

public interface LadepunktRepository {
    public Ladepunkt findById(LadepunktId ladepunktId);

    public void save(Ladepunkt ladepunkt, boolean isNew);
}
