#-------------------------
#-- Tabelle: FAHRZEUGHALTER
#-------------------------
CREATE TABLE fahrzeughalter_entity (
    halter_id        INT AUTO_INCREMENT PRIMARY KEY,
    name             VARCHAR(255) NOT NULL,
    bankverbindung   VARCHAR(255) NOT NULL,
    strasse          VARCHAR(255) NOT NULL,
    hausnummer       VARCHAR(10) NOT NULL,
    plz              VARCHAR(10) NOT NULL,
    ort              VARCHAR(255) NOT NULL
);

#-------------------------
#-- Tabelle: LADEPUNKT
#-------------------------
CREATE TABLE ladepunkt_entity (
    ladepunkt_id          INT PRIMARY KEY, #-- Referenz auf Ladepunkt-ID aus anderem System
    ladeleistung_kw       DECIMAL(5,2) NOT NULL, 
    verfuegbarkeit        VARCHAR(50) NOT NULL
);

#-------------------------
#-- Tabelle: NUTZUNG
#-------------------------
CREATE TABLE nutzung_entity (
    nutzungs_id      INT AUTO_INCREMENT PRIMARY KEY,
    ladepunkt_id     INT NOT NULL,
    datum            DATE NOT NULL,
    ladezeit_min     INT NOT NULL,
    ladeleistung_kwh DECIMAL(10,2) NOT NULL,
    halter_id        INT NOT NULL,
    FOREIGN KEY (halter_id) REFERENCES fahrzeughalter_entity(halter_id)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
    FOREIGN KEY (ladepunkt_id) REFERENCES ladepunkt_entity(ladepunkt_id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);