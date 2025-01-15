package com.example.infrastruktur.application.domain;

import com.example.infrastruktur.application.port.secondary.LadepunktAktualisiertEventPublisher;

public class LadepunktDomainService {

    private final LadepunktAktualisiertEventPublisher ladepunktAktualisiertEventPublisher;

    public LadepunktDomainService(LadepunktAktualisiertEventPublisher ladepunktAktualisiertEventPublisher) {
        this.ladepunktAktualisiertEventPublisher = ladepunktAktualisiertEventPublisher;
    }

    /**
     * Ladepunkt erstellt oder aktualisiert
     */
    public void speichereLadepunkt(Ladepunkt ladepunkt) {
        LadepunktAktualisiertEvent ladepunktAktualisiertEvent = new LadepunktAktualisiertEvent(ladepunkt);
        ladepunktAktualisiertEventPublisher.publishDomainEvent(ladepunktAktualisiertEvent);
    }
}
