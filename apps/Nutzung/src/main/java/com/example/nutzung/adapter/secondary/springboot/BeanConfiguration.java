package com.example.nutzung.adapter.secondary.springboot;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.nutzung.adapter.primary.REST.FahrzeughalterController;
import com.example.nutzung.adapter.primary.REST.NutzungController;
import com.example.nutzung.adapter.primary.messagequeue.EventListener;
import com.example.nutzung.adapter.secondary.messagequeue.EventPublisherImpl;
import com.example.nutzung.adapter.secondary.persistence.FahrzeughalterRepositoryImplDb;
import com.example.nutzung.adapter.secondary.persistence.JdbcFahrzeughalterEntityRepository;
import com.example.nutzung.adapter.secondary.persistence.JdbcLadepunktEntityRepository;
import com.example.nutzung.adapter.secondary.persistence.JdbcNutzungEntityRepository;
import com.example.nutzung.adapter.secondary.persistence.LadepunktRepositoryImplDb;
import com.example.nutzung.adapter.secondary.persistence.NutzungRepositoryImplDb;
import com.example.nutzung.application.NutzungAppServiceImpl;
import com.example.nutzung.application.domain.NutzungDomainService;
import com.example.nutzung.application.port.primary.NutzungAppService;
import com.example.nutzung.application.port.secondary.EventPublisher;
import com.example.nutzung.application.port.secondary.FahrzeughalterRepository;
import com.example.nutzung.application.port.secondary.LadepunktRepository;
import com.example.nutzung.application.port.secondary.NutzungRepository;

@Configuration
public class BeanConfiguration {

	@Bean
	FahrzeughalterRepository fahrzeughalterRepository(
			JdbcFahrzeughalterEntityRepository jdbcFahrzeughalterEntityRepository) {
		return new FahrzeughalterRepositoryImplDb(jdbcFahrzeughalterEntityRepository);
	}

	@Bean
	NutzungRepository nutzungRepository(JdbcNutzungEntityRepository jdbcNutzungEntityRepository) {
		return new NutzungRepositoryImplDb(jdbcNutzungEntityRepository);
	}

	@Bean
	LadepunktRepository ladepunktRepository(JdbcLadepunktEntityRepository jdbcLadepunktEntityRepository) {
		return new LadepunktRepositoryImplDb(jdbcLadepunktEntityRepository);
	}

	@Bean
	NutzungAppService nutzungAppService(FahrzeughalterRepository halterRepository, NutzungRepository nutzungRepository,
			LadepunktRepository ladepunktRepository, NutzungDomainService nutzungDomainService) {
		return new NutzungAppServiceImpl(halterRepository, nutzungRepository, ladepunktRepository,
				nutzungDomainService);
	}

	@Bean
	FahrzeughalterController fahrzeughalterController(NutzungAppService nutzungAppService) {
		return new FahrzeughalterController(nutzungAppService);
	}

	@Bean
	NutzungController nutzungController(NutzungAppService nutzungAppService) {
		return new NutzungController(nutzungAppService);
	}

	@Bean
	EventListener eventListener(NutzungAppService nutzungAppService) {
		return new EventListener(nutzungAppService);
	}

	@Bean
	EventPublisher eventPublisher(RabbitTemplate rabbitTemplate, AmqpAdmin amqpAdmin) {
		return new EventPublisherImpl(rabbitTemplate, amqpAdmin);
	}

	@Bean
	NutzungDomainService nutzungDomainService(EventPublisher eventPublisher) {
		return new NutzungDomainService(eventPublisher);
	}

}
