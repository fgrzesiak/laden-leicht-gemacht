package com.example.infrastruktur.adapter.secondary.springboot;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.infrastruktur.adapter.primary.REST.AnsprechpartnerController;
import com.example.infrastruktur.adapter.primary.REST.EigentuemerController;
import com.example.infrastruktur.adapter.primary.REST.LadepunktController;
import com.example.infrastruktur.adapter.primary.messagequeue.NutzungAktualisiertEventListener;
import com.example.infrastruktur.adapter.secondary.messagequeue.EventPublisher;
import com.example.infrastruktur.adapter.secondary.messagequeue.LadepunktAktualisiertEventPublisherImpl;
import com.example.infrastruktur.adapter.secondary.persistence.AnsprechpartnerRepositoryImplDb;
import com.example.infrastruktur.adapter.secondary.persistence.EigentuemerRepositoryImplDb;
import com.example.infrastruktur.adapter.secondary.persistence.JdbcAnsprechpartnerEntityRepository;
import com.example.infrastruktur.adapter.secondary.persistence.JdbcEigentuemerEntityRepository;
import com.example.infrastruktur.adapter.secondary.persistence.JdbcLadepunktEntityRepository;
import com.example.infrastruktur.adapter.secondary.persistence.LadepunktRepositoryImplDb;
import com.example.infrastruktur.application.InfrastrukturAppServiceImpl;
import com.example.infrastruktur.application.domain.LadepunktDomainService;
import com.example.infrastruktur.application.port.primary.InfrastrukturAppService;
import com.example.infrastruktur.application.port.secondary.AnsprechpartnerRepository;
import com.example.infrastruktur.application.port.secondary.EigentuemerRepository;
import com.example.infrastruktur.application.port.secondary.LadepunktAktualisiertEventPublisher;
import com.example.infrastruktur.application.port.secondary.LadepunktRepository;

@Configuration
public class BeanConfiguration {

    @Bean
    AnsprechpartnerController ansprechpartnerController(InfrastrukturAppService ladeinfraService) {
        return new AnsprechpartnerController(ladeinfraService);
    }

    @Bean
    AnsprechpartnerRepository ansprechpartnerRepository(
            JdbcAnsprechpartnerEntityRepository jdbcAnsprechpartnerEntityRepository) {
        return new AnsprechpartnerRepositoryImplDb(jdbcAnsprechpartnerEntityRepository);
    }

    @Bean
    EigentuemerController eigentuemerController(InfrastrukturAppService ladeinfraService) {
        return new EigentuemerController(ladeinfraService);
    }

    @Bean
    EigentuemerRepository eigentuemerRepository(JdbcEigentuemerEntityRepository jdbcEigentuemerEntityRepository) {
        return new EigentuemerRepositoryImplDb(jdbcEigentuemerEntityRepository);
    }

    @Bean
    NutzungAktualisiertEventListener eventListener(InfrastrukturAppService infrastrukturAppService) {
        return new NutzungAktualisiertEventListener(infrastrukturAppService);
    }

    @Bean
    LadepunktAktualisiertEventPublisher ladepunktAktualisiertEventPublisher(EventPublisher eventPublisher) {
        return new LadepunktAktualisiertEventPublisherImpl(eventPublisher);
    }

    @Bean
    InfrastrukturAppService infrastrukturAppService(
            LadepunktRepository ladepunktRepository,
            EigentuemerRepository eigentuemerRepository,
            AnsprechpartnerRepository ansprechpartnerRepository,
            LadepunktDomainService ladepunktDomainService) {
        return new InfrastrukturAppServiceImpl(ladepunktRepository, eigentuemerRepository, ansprechpartnerRepository,
                ladepunktDomainService);
    }

    @Bean
    LadepunktController ladepunktController(InfrastrukturAppService ladeinfraService) {
        return new LadepunktController(ladeinfraService);
    }

    @Bean
    LadepunktDomainService ladepunktDomainService(LadepunktAktualisiertEventPublisher eventPublisher) {
        return new LadepunktDomainService(eventPublisher);
    }

    @Bean
    LadepunktRepository ladepunktRepository(JdbcLadepunktEntityRepository jdbcLadepunktEntityRepository) {
        return new LadepunktRepositoryImplDb(jdbcLadepunktEntityRepository);
    }

    @Bean
    EventPublisher eventPublisher(RabbitTemplate rabbitTemplate) {
        return new EventPublisher(rabbitTemplate);
    }
}
