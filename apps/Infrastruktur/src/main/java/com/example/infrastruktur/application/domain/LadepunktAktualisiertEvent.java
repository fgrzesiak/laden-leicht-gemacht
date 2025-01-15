package com.example.infrastruktur.application.domain;

/**
 * DomainEvent, das signalisiert, dass ein Ladepunkt aktualisiert oder erstellt
 * wurde.
 */
public class LadepunktAktualisiertEvent {

    Ladepunkt ladepunkt;

    public LadepunktAktualisiertEvent(Ladepunkt ladepunkt) {
        this.ladepunkt = ladepunkt;
    }

    public Ladepunkt getLadepunkt() {
        return ladepunkt;
    }
}
