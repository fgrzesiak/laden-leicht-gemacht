package com.example.infrastruktur.application.domain;

import com.example.infrastruktur.adapter.secondary.messagequeue.LadepunktTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * DomainEvent, das signalisiert, dass ein Ladepunkt aktualisiert wurde
 * (z.B. Gesamtleistung erhöht, Standort geändert, etc.).
 */
public class LadepunktAktualisiertEvent extends DomainEvent {

    public LadepunktAktualisiertEvent(Ladepunkt ladepunkt) {
        // Erstelle ein Transferobjekt (TO), das die relevanten Felder für die Message
        // Queue enthält.
        LadepunktTO ladepunktTO = new LadepunktTO(
                ladepunkt.getLadepunktId().getId(),
                ladepunkt.getLadeleistungKW(),
                ladepunkt.getVerfuegbarkeit());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.payload = objectMapper.writeValueAsString(ladepunktTO);
        } catch (JsonProcessingException e) {
            System.out.println("Message could not be serialized. Cause: " + e.getMessage());
        }
    }
}
