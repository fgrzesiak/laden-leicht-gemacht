# LadenLeichtGemacht - Readme für unseren Professor

Diese Readme enthält wichtige Informationen zur Erleichterung des Start- und Testvorgangs unserer Anwendung.
Bei Fragen oder Problemen wenden Sie sich gerne direkt an uns unter folgenden Möglichkeiten:

1. UNI-Email
2. Privat-Email: fj.grzesiak@gmail.com
3. Telefon: 0176 34576061

## Start der Anwendung

Es reicht, die `compose.prod.yaml` Datei herunterzuladen und dann den folgenden Befehl auszuführen:

```
docker compose -f compose.prod.yaml up -d
```

Dadurch wird die Anwendung nicht selbst auf dem lokalen Rechner gebaut, sondern die Images von DockerHub heruntergeladen und ausgeführt.

Alternativ oder für den Fall, dass die Images auf DockerHub aktualisiert werden, kann der folgende Befehl ausgeführt werden:

```
docker compose -f compose.prod.yaml  up -d --pull always
```

## Testen der Anwendung

Die Anwendung besteht aus zwei Microservices: `Infrastruktur-Service` und `Nutzungs-Service`. Die Anwendung kann über die folgenden Links getestet werden:

- [Infrastruktur-Service](http://localhost:8081/api.html) (http://localhost:8081/api.html)
- [Nutzungs-Service](http://localhost:8082/api.html) (http://localhost:8082/api.html)

Zum Testen ist es notwendig, dass die Anwendung lokal ausgeführt wird.

Die Datenbanken werden automatisch beim ersten Start der Anwendung mit Beispieldaten gefüllt und können für Testzwecke verwendet werden.
