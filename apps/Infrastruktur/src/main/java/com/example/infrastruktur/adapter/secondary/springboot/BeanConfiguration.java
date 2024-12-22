package com.example.infrastruktur.adapter.secondary.springboot;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.infrastruktur.adapter.primary.REST.AnsprechpartnerController;
import com.example.infrastruktur.adapter.primary.REST.EigentuemerController;
import com.example.infrastruktur.adapter.primary.REST.LadepunktController;
import com.example.infrastruktur.adapter.primary.messagequeue.EventListener;
import com.example.infrastruktur.adapter.secondary.messagequeue.EventPublisherImpl;
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
import com.example.infrastruktur.application.port.secondary.EventPublisher;
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
    EventListener eventListener(InfrastrukturAppService infrastrukturAppService) {
        return new EventListener(infrastrukturAppService);
    }

    @Bean
    EventPublisher eventPublisher(RabbitTemplate rabbitTemplate, AmqpAdmin amqpAdmin) {
        return new EventPublisherImpl(rabbitTemplate, amqpAdmin);
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
    LadepunktDomainService ladepunktDomainService(EventPublisher eventPublisher) {
        return new LadepunktDomainService(eventPublisher);
    }

    @Bean
    LadepunktRepository ladepunktRepository(JdbcLadepunktEntityRepository jdbcLadepunktEntityRepository) {
        return new LadepunktRepositoryImplDb(jdbcLadepunktEntityRepository);
    }

}
