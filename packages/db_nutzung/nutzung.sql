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

#--------------------------------------------------------
# Dummy-Daten einfügen
#--------------------------------------------------------

# 1) Einträge in fahrzeughalter_entity
INSERT INTO fahrzeughalter_entity (name, bankverbindung, strasse, hausnummer, plz, ort)
VALUES
('Max Mustermann', 'DE1234567890', 'Musterstrasse', '1', '12345', 'Musterstadt'),
('Lisa Schmid', 'DE0987654321', 'Schmidstrasse', '10', '54321', 'Berlingersdorf'),
('Thomas Müller', 'DE1111222233', 'Bergstrasse', '7', '11111', 'Bergstadt');

# 2) Einträge in ladepunkt_entity
INSERT INTO ladepunkt_entity (ladepunkt_id, ladeleistung_kw, verfuegbarkeit)
VALUES
(1, 22.00, 'VERFUEGBAR'),
(2, 150.00, 'IN_WARTUNG'),
(3, 11.00, 'VERFUEGBAR'),
(4, 50.00, 'VERFUEGBAR');

# 3) Einträge in nutzung_entity
INSERT INTO nutzung_entity (ladepunkt_id, datum, ladezeit_min, ladeleistung_kwh, halter_id)
VALUES
(1, '2024-01-01', 60,  22.00, 1),   -- 22 * (60/60)
(1, '2024-01-02', 30,  11.00, 1),   -- 22 * (30/60)
(2, '2024-02-10', 120, 300.00, 2),  -- 150 * (120/60)
(3, '2024-02-15', 45,   8.25, 3);   -- 11  * (45/60)