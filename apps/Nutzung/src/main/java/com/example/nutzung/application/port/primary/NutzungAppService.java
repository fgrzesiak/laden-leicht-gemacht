package com.example.nutzung.application.port.primary;

import com.example.nutzung.application.dto.FahrzeughalterRequest;
import com.example.nutzung.application.dto.FahrzeughalterResponse;
import com.example.nutzung.application.dto.NutzungRequest;
import com.example.nutzung.application.dto.NutzungResponse;

import java.util.List;

public interface NutzungAppService {

    // Fahrzeughalter CRUD
    int halterAnlegen(FahrzeughalterRequest dto);

    FahrzeughalterResponse halterFinden(int halterId);

    boolean halterAktualisieren(int halterId, FahrzeughalterRequest dto);

    boolean halterLoeschen(int halterId);

    List<FahrzeughalterResponse> alleHalterAnzeigen();

    // Nutzung erfassen und anzeigen
    int nutzungAnlegen(NutzungRequest dto);

    NutzungResponse nutzungFinden(int nutzungsId);

    boolean nutzungLoeschen(int nutzungsId);

    List<NutzungResponse> nutzungsHistorieFuerHalter(int halterId);

    // Ladepunkt aktualisieren

    void ladepunktAktualisieren(int ladepunktId, double ladeleistungKW, String verfuegbarkeit);
}
