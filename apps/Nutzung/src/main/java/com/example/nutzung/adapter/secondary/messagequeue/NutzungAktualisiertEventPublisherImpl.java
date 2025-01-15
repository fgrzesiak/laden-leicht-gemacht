package com.example.nutzung.adapter.secondary.messagequeue;

import com.example.nutzung.application.domain.NutzungAktualisiertEvent;
import com.example.nutzung.application.port.secondary.NutzungAktualisiertEventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NutzungAktualisiertEventPublisherImpl implements NutzungAktualisiertEventPublisher {

    private EventPublisher eventPublisher;

    public NutzungAktualisiertEventPublisherImpl(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public String publishDomainEvent(NutzungAktualisiertEvent event) {
        NutzungTO nutzungTO = new NutzungTO(
                event.getNutzung().getLadepunktId().getId(),
                event.getNutzung().getLadeleistungKWH());

        String payload = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            payload = objectMapper.writeValueAsString(nutzungTO);

        } catch (JsonProcessingException e) {
            System.out.println("Message could not be created. Cause: " + e.getMessage());
        }

        eventPublisher.publishEvent("nutzung.events", "nutzung.aktualisiert", payload);
        return payload;
    }
}
