package com.example.nutzung.application.domain;

public class NutzungAktualisiertEvent {

	Nutzung nutzung;

	public NutzungAktualisiertEvent() {
	}

	public NutzungAktualisiertEvent(Nutzung nutzung) {
		this.nutzung = nutzung;
	}

	public Nutzung getNutzung() {
		return nutzung;
	}

}
