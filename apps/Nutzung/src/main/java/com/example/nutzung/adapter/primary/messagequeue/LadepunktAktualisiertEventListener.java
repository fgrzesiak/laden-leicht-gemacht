package com.example.nutzung.adapter.primary.messagequeue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.nutzung.application.port.primary.NutzungAppService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LadepunktAktualisiertEventListener {

	NutzungAppService nutzungAppService;

	public LadepunktAktualisiertEventListener(NutzungAppService nutzungAppService) {
		this.nutzungAppService = nutzungAppService;
	}

	@RabbitListener(queues = "ladepunkt_aktualisierung")
	public void receiveMessage(String message) {
		// Process the received message
		System.out.println("#################Received message:################# " + message);

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			LadepunktTO ladepunktTO = objectMapper.readValue(message, LadepunktTO.class);
			nutzungAppService.ladepunktAktualisieren(ladepunktTO.getLadepunktId(), ladepunktTO.getLadeleistungKW(),
					ladepunktTO.getVerfuegbarkeit());
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
