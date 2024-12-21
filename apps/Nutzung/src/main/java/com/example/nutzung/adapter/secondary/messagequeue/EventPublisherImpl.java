package com.example.nutzung.adapter.secondary.messagequeue;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.example.nutzung.application.domain.DomainEvent;
import com.example.nutzung.application.port.secondary.EventPublisher;

public class EventPublisherImpl implements EventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public EventPublisherImpl(RabbitTemplate rabbitTemplate, AmqpAdmin amqpAdmin) {
        this.rabbitTemplate = rabbitTemplate;

        TopicExchange exchange = new TopicExchange("nutzung.events");
        amqpAdmin.declareExchange(exchange);

        Queue queue = new Queue("nutzungQueue", true);
        amqpAdmin.declareQueue(queue);

        amqpAdmin.declareBinding(
                BindingBuilder.bind(queue)
                        .to(exchange)
                        .with("nutzung.registriert"));
    }

    @Override
    public String publishDomainEvent(DomainEvent event) {
        String routingKey = "nutzung.registriert";
        Object response = rabbitTemplate.convertSendAndReceive(
                "nutzung.events",
                routingKey,
                event.getPayload());

        System.out.println("!!!MESSAGE SENT!!!! " + event.getPayload());
        if (response != null) {
            return (String) response;
        }
        return "Response could not be received.";
    }
}
