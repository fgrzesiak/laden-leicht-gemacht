package com.example.infrastruktur.adapter.secondary.messagequeue;

import com.example.infrastruktur.application.domain.LadepunktAktualisiertEvent;
import com.example.infrastruktur.application.port.secondary.LadepunktAktualisiertEventPublisher;
import com.example.infrastruktur.application.port.secondary.LadepunktTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LadepunktAktualisiertEventPublisherImpl implements LadepunktAktualisiertEventPublisher {

    private EventPublisher eventPublisher;

    public LadepunktAktualisiertEventPublisherImpl(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public String publishDomainEvent(LadepunktAktualisiertEvent event) {
        LadepunktTO ladepunktTO = new LadepunktTO(
                event.getLadepunkt().getLadepunktId().getId(),
                event.getLadepunkt().getLadeleistungKW(),
                event.getLadepunkt().getVerfuegbarkeit());

        String payload = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            payload = objectMapper.writeValueAsString(ladepunktTO);

        } catch (JsonProcessingException e) {
            System.out.println("Message could not be created. Cause: " + e.getMessage());
        }

        eventPublisher.publishEvent("infrastruktur.events", "ladepunkt.aktualisiert", payload);
        return payload;
    }

}
