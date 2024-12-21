package com.example.nutzung.application.domain;

import com.example.nutzung.adapter.secondary.messagequeue.NutzungTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * DomainEvent, das signalisiert, dass eine Nutzung registriert wurde
 * (z.B. um andere Microservices zu informieren).
 */
public class NutzungRegistriertEvent extends DomainEvent {

    public NutzungRegistriertEvent(Nutzung nutzung) {
        NutzungTO nutzungTO = new NutzungTO(
                nutzung.getLadepunktId().getId(),
                nutzung.getladeleistungKWH());
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.payload = objectMapper.writeValueAsString(nutzungTO);
        } catch (JsonProcessingException e) {
            System.out.println("Message could not be serialized. Cause: " + e.getMessage());
        }
    }
}
