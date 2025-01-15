package com.example.nutzung.application.domain;

import com.example.nutzung.application.port.secondary.NutzungAktualisiertEventPublisher;

public class NutzungDomainService {

    private final NutzungAktualisiertEventPublisher eventPublisher;

    public NutzungDomainService(NutzungAktualisiertEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void verarbeiteLadevorgang(Nutzung nutzung) {
        NutzungAktualisiertEvent nutzungRegistriertEvent = new NutzungAktualisiertEvent(nutzung);
        eventPublisher.publishDomainEvent(nutzungRegistriertEvent);
    }

    /**
     * Verarbeitet die Aktualisierung eines Ladevorgangs.
     *
     * @param nutzungAlt Die alte Nutzung mit den vorherigen Ladeinformationen.
     * @param nutzungNeu Die neue Nutzung mit den aktualisierten Ladeinformationen.
     *
     *                   Diese Methode überprüft, ob sich die Ladepunkt-ID und die
     *                   Ladeleistung (in kWh) zwischen der alten und der neuen
     *                   Nutzung geändert haben.
     *                   Wenn die Ladepunkt-ID gleich bleibt, aber die Ladeleistung
     *                   sich ändert, muss die Differenz der Ladeleistung berechnet,
     *                   um die Gesamtladeleistung korrekt zu berechnen.
     *                   Wenn sich die Ladepunkt-ID ändert, wird die alte
     *                   Ladeleistung negiert, sodass diese für den alten Ladepunkt
     *                   von der Gesamtladeleistung abgezogen und für den neuen
     *                   Ladepunkt addiert wird.
     */
    public void verarbeiteLadevorgangAktualisiert(Nutzung nutzungAlt, Nutzung nutzungNeu) {
        int ladepunktIdAlt = nutzungAlt.getLadepunktId().getId();
        int ladepunktIdNeu = nutzungNeu.getLadepunktId().getId();
        double kwhAlt = nutzungAlt.getLadeleistungKWH();
        double kwhNeu = nutzungNeu.getLadeleistungKWH();

        System.out.println("Ladepunkt-ID alt: " + ladepunktIdAlt);
        System.out.println("Ladepunkt-ID neu: " + ladepunktIdNeu);
        System.out.println("kWh alt: " + kwhAlt);
        System.out.println("kWh neu: " + kwhNeu);

        if (ladepunktIdAlt == ladepunktIdNeu && kwhAlt != kwhNeu) {
            nutzungNeu.setLadeleistungKWH(kwhNeu - kwhAlt);
            eventPublisher.publishDomainEvent(new NutzungAktualisiertEvent(nutzungNeu));
        } else if (ladepunktIdAlt != ladepunktIdNeu) {
            nutzungAlt.setLadeleistungKWH(kwhAlt * -1);
            eventPublisher.publishDomainEvent(new NutzungAktualisiertEvent(nutzungAlt));
            eventPublisher.publishDomainEvent(new NutzungAktualisiertEvent(nutzungNeu));
        }
        // sonst: keine Änderung, keine Aktion erforderlich
    }

    public void verarbeiteLadevorgangGeloescht(Nutzung nutzungAlt) {
        nutzungAlt.setLadeleistungKWH(nutzungAlt.getLadeleistungKWH() * -1);
        eventPublisher.publishDomainEvent(new NutzungAktualisiertEvent(nutzungAlt));
    }
}
