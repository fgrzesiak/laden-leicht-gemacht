# Fallbeispiel: "Managementsystem für Ladeinfrastruktur" (Gruppe 1)

Das Unternehmen „LadenLeichtGemacht“ betreibt verschiedene Ladepunkte. Das Unternehmen braucht eine Anwendung für die Verwaltung der Ladepunkte und die Abwicklung der Ladevorgänge.

## Anforderungen

### Verwaltung der Ladepunkte

- **Als Betreiber von Ladeinfrastruktur** möchte ich Ladepunkte verwalten, um sicherzustellen, dass die Ladeeinrichtungen immer verfügbar und funktionstüchtig sind.
  - Das System soll folgende Informationen zu einem Ladepunkt verwalten:
    - Ladepunkt-ID
    - Standort (Adresse)
    - Grundstückeigentümer
    - Ladeleistung (z.B. 22 kW, 50 kW)
    - Anschlussart (Typ 2, CCS)
    - Verfügbarkeit (verfügbar, in Wartung)
    - Gesamtladeleistung seit Installation

### Verwaltung der Grundstückeigentümer

- **Als Anlagenbetreiber** möchte ich die Daten zu Grundstückeigentümern verwalten, um zu wissen, wen ich ggf. ansprechen kann.
  - Das System soll folgende Informationen zu einem Grundstückeigentümer verwalten:
    - Eigentümer-ID
    - Name
    - Firmenadresse
    - Liste von Ansprechpartnern (mit Name, Adresse, üblichen Kontaktdaten)

### Verwaltung der Nutzung der Ladepunkte

- **Als Betreiber von Ladeinfrastruktur** möchte ich die Nutzung der Ladepunkte verwalten, um eine Grundlage für die Abrechnung von Nutzungen der Ladepunkte zu haben und die Nutzung zu bewerten.
  - Das System soll folgende Informationen zu einer Nutzung eines Ladepunkts verwalten:
    - Ladepunkt-ID
    - Datum
    - Ladezeit (in Minuten)
    - Ladeleistung (kWh)
    - Fahrzeughalter

### Verwaltung der Fahrzeughalter

- **Als Anlagenbetreiber** möchte ich die Daten zu Fahrzeughaltern verwalten, um Nutzung der Ladepunkte mit den Kunden abrechnen zu können.
  - Das System soll folgende Informationen zu einem Fahrzeughalter verwalten:
    - Name
    - Adresse
    - Bankverbindung

### Einsicht in die Ladehistorie

- **Als Anlagenbetreiber** möchte ich die Ladehistorie eines Kunden einsehen, um eine Grundlage für mein Kundenmanagement zu haben.

# Befehle zum Ausführen der Anwendung

1. Einfacher Start:

```
docker compose -f compose.dev.yaml up -d
```

2. Datenbankschema initialisieren:

```
docker compose down -v
docker compose -f compose.dev.yaml up -d
```

3. Docker neuer Build:

```
docker compose -f compose.dev.yaml build --no-cache
```

4. Docker Recreate:

```
docker compose -f compose.dev.yaml up -d --force-recreate
```

# Befehle zur Ausführung der DockerHub-Images (bei Nicht-Entwicklung und für die Abgabe der Anwendung)

Es reicht, die `compose.yaml` Datei herunterzuladen und dann den folgenden Befehl auszuführen:

```
docker compose up -d
```

Dadurch wird die Anwendung nicht selbst auf dem lokalen Rechner gebaut, sondern die Images von DockerHub heruntergeladen und ausgeführt.

Alternativ oder für den Fall, dass die Images auf DockerHub aktualisiert werden, kann der folgende Befehl ausgeführt werden:

```
docker compose up -d --pull always
```

## Testen der Anwendung

Die Anwendung besteht aus zwei Microservices: `Infrastruktur-Service` und `Nutzungs-Service`. Die Anwendung kann über die folgenden Links getestet werden:

- [Infrastruktur-Service](http://localhost:8081/api.html) (http://localhost:8081/api.html)
- [Nutzungs-Service](http://localhost:8082/api.html) (http://localhost:8082/api.html)

Dafür ist es notwendig, dass die Anwendung lokal ausgeführt wird, unabhängig davon, ob die Anwendung lokal gebaut oder die Images von DockerHub heruntergeladen werden.
