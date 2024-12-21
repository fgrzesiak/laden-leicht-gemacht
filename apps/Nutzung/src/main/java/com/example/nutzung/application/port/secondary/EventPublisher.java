package com.example.nutzung.application.port.secondary;

import com.example.nutzung.application.domain.DomainEvent;

public interface EventPublisher {

	public String publishDomainEvent(DomainEvent event);

}
