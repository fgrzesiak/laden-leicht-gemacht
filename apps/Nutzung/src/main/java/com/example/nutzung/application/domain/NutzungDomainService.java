package com.example.nutzung.application.domain;

import com.example.nutzung.application.port.secondary.EventPublisher;

public class NutzungDomainService {

    private final EventPublisher eventPublisher;

    public NutzungDomainService(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void verarbeiteLadevorgang(Nutzung nutzung) {
        DomainEvent nutzungRegistriertEvent = new NutzungRegistriertEvent(nutzung);
        eventPublisher.publishDomainEvent(nutzungRegistriertEvent);
    }
}
