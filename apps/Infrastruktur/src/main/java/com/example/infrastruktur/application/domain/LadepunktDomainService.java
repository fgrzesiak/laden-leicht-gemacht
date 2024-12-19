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

    /**
     * Beispielmethode, die einen Ladevorgang bearbeitet:
     * - Gesamtleistung des Ladepunkts erhöhen
     * - Event veröffentlichen
     */
    public boolean verarbeiteLadevorgang(Ladepunkt ladepunkt, double geladeneKWh) {

        // Hier könnte man noch prüfen, ob der Ladevorgang valide ist
        ladepunkt.setGesamtleistungKWH(ladepunkt.getGesamtleistungKWH() + geladeneKWh);

        // DomainEvent anlegen (z. B. LadepunktAktualisiertEvent)
        DomainEvent ladepunktAktualisiertEvent = new LadepunktAktualisiertEvent(ladepunkt);

        // Event publizieren
        eventPublisher.publishDomainEvent(ladepunktAktualisiertEvent);

        return true;
    }
}
