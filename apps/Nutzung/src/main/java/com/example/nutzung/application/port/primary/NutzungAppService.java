package com.example.nutzung.application.port.primary;

import com.example.nutzung.application.dto.FahrzeughalterRequest;
import com.example.nutzung.application.dto.FahrzeughalterResponse;
import com.example.nutzung.application.dto.NutzungRequest;
import com.example.nutzung.application.dto.NutzungResponse;
import com.example.nutzung.application.exception.NutzungAppException;

import java.util.List;

public interface NutzungAppService {

    // Fahrzeughalter CRUD
    int halterAnlegen(FahrzeughalterRequest dto);

    FahrzeughalterResponse halterFinden(int halterId) throws NutzungAppException;

    void halterAktualisieren(int halterId, FahrzeughalterRequest dto) throws NutzungAppException;

    void halterLoeschen(int halterId) throws NutzungAppException;

    List<FahrzeughalterResponse> alleHalterAnzeigen();

    // Nutzung erfassen und anzeigen
    int nutzungAnlegen(int ladepunktId, NutzungRequest dto) throws NutzungAppException;

    NutzungResponse nutzungFinden(int nutzungsId) throws NutzungAppException;

    void nutzungLoeschen(int nutzungsId) throws NutzungAppException;

    List<NutzungResponse> nutzungsHistorieFuerHalter(int halterId) throws NutzungAppException;

    // Ladepunkt aktualisieren

    void ladepunktAktualisieren(int ladepunktId, double ladeleistungKW, String verfuegbarkeit);
}
