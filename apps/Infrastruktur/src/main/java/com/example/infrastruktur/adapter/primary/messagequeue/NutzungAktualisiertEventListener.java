package com.example.infrastruktur.adapter.primary.messagequeue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.infrastruktur.application.port.primary.InfrastrukturAppService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class NutzungAktualisiertEventListener {

	InfrastrukturAppService infrastrukturAppService;

	public NutzungAktualisiertEventListener(InfrastrukturAppService infrastrukturAppService) {
		this.infrastrukturAppService = infrastrukturAppService;
	}

	@RabbitListener(queues = "nutzung_aktualisierung")
	public void receiveMessage(String message) {
		System.out.println("#################Received message:################# " + message);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			NutzungTO nutzungTO = objectMapper.readValue(message, NutzungTO.class);
			infrastrukturAppService.verarbeiteLadevorgang(nutzungTO.getLadepunktId(), nutzungTO.getLadeleistungKWH());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
