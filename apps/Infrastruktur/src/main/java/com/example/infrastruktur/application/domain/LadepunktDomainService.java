package com.example.infrastruktur.application.domain;

import com.example.infrastruktur.application.port.secondary.EventPublisher;

public class LadepunktDomainService {

    private final EventPublisher eventPublisher;

    public LadepunktDomainService(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    /**
     * Ladepunkt erstellt oder aktualisiert
     */
    public void speichereLadepunkt(Ladepunkt ladepunkt) {
        DomainEvent ladepunktAktualisiertEvent = new LadepunktAktualisiertEvent(ladepunkt);
        eventPublisher.publishDomainEvent(ladepunktAktualisiertEvent);
    }
}
