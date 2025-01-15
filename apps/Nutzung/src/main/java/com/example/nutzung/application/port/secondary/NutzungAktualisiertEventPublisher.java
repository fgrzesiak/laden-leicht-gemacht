package com.example.nutzung.application.port.secondary;

import com.example.nutzung.application.domain.NutzungAktualisiertEvent;

public interface NutzungAktualisiertEventPublisher {

	public String publishDomainEvent(NutzungAktualisiertEvent event);

}
