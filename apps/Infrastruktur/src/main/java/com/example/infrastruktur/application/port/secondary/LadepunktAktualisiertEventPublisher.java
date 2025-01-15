package com.example.infrastruktur.application.port.secondary;

import com.example.infrastruktur.application.domain.LadepunktAktualisiertEvent;

public interface LadepunktAktualisiertEventPublisher {

    public String publishDomainEvent(LadepunktAktualisiertEvent event);
}
