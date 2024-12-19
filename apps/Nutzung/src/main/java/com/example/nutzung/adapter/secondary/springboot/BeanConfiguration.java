package com.example.nutzung.adapter.secondary.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.nutzung.adapter.primary.REST.FahrzeughalterController;
import com.example.nutzung.adapter.primary.REST.NutzungController;
import com.example.nutzung.adapter.primary.messagequeue.EventListener;
import com.example.nutzung.adapter.secondary.persistence.FahrzeughalterRepositoryImplDb;
import com.example.nutzung.adapter.secondary.persistence.JdbcFahrzeughalterEntityRepository;
import com.example.nutzung.adapter.secondary.persistence.JdbcLadepunktEntityRepository;
import com.example.nutzung.adapter.secondary.persistence.JdbcNutzungEntityRepository;
import com.example.nutzung.adapter.secondary.persistence.LadepunktRepositoryImplDb;
import com.example.nutzung.adapter.secondary.persistence.NutzungRepositoryImplDb;
import com.example.nutzung.application.NutzungAppServiceImpl;
import com.example.nutzung.application.port.primary.NutzungAppService;
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
			LadepunktRepository ladepunktRepository) {
		return new NutzungAppServiceImpl(halterRepository, nutzungRepository, ladepunktRepository);
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

}
