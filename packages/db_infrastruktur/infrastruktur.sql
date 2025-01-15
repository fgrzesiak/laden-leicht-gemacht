#-------------------------
#-- Tabelle: GRUNDSTUECKSEIGENTUEMER
#-------------------------
CREATE TABLE eigentuemer_entity (
    eigentuemer_id        INT AUTO_INCREMENT PRIMARY KEY,
    name                  VARCHAR(255) NOT NULL,
    strasse               VARCHAR(255) NOT NULL,
    hausnummer            VARCHAR(10) NOT NULL,
    plz                   VARCHAR(10) NOT NULL,
    ort                   VARCHAR(255) NOT NULL
);

#-------------------------
#-- Tabelle: ANSPRECHPARTNER
#-------------------------
#-- Um mehrere Ansprechpartner pro Eigentümer zu verwalten, 
#-- legen wir eine eigene Tabelle an und verknüpfen sie über eigentuemer_id.
#-------------------------
CREATE TABLE ansprechpartner_entity (
    ansprechpartner_id    INT AUTO_INCREMENT PRIMARY KEY,
    eigentuemer_id        INT NOT NULL,
    name                  VARCHAR(255) NOT NULL,
    telefon               VARCHAR(50),
    email                 VARCHAR(255),
    strasse               VARCHAR(255) NOT NULL,
    hausnummer            VARCHAR(10) NOT NULL,
    plz                   VARCHAR(10) NOT NULL,
    ort                   VARCHAR(255) NOT NULL,
    FOREIGN KEY (eigentuemer_id) REFERENCES eigentuemer_entity(eigentuemer_id)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);

#-------------------------
#-- Tabelle: LADEPUNKT
#-------------------------
CREATE TABLE ladepunkt_entity (
    ladepunkt_id          INT AUTO_INCREMENT PRIMARY KEY,
    eigentuemer_id        INT,  #-- optionaler FK, falls Ladepunkt einem Eigentümer zugeordnet ist
    ladeleistung_kw       DECIMAL(5,2) NOT NULL,       #-- z.B. 22.00
    anschlussart          VARCHAR(50) NOT NULL,         #-- z.B. "Typ 2", "CCS", ...
    verfuegbarkeit        ENUM('VERFUEGBAR', 'IN_WARTUNG') NOT NULL DEFAULT 'VERFUEGBAR',
    gesamtleistung_kwh    DECIMAL(10,2) NOT NULL DEFAULT 0.0,
    strasse               VARCHAR(255) NOT NULL,
    hausnummer            VARCHAR(10) NOT NULL,
    plz                   VARCHAR(10) NOT NULL,
    ort                   VARCHAR(255) NOT NULL,
    FOREIGN KEY (eigentuemer_id) REFERENCES eigentuemer_entity(eigentuemer_id)
      ON DELETE SET NULL
      ON UPDATE CASCADE
);

#-------------------------
#-- Dummy-Daten einfügen
#-------------------------

# -- Einträge in eigentuemer_entity 
INSERT INTO eigentuemer_entity (name, strasse, hausnummer, plz, ort)
VALUES
('Max Mustermann GmbH', 'Musterstrasse', '10', '12345', 'Musterstadt'),
('E-Mobility AG', 'Energiestrasse', '5a', '54321', 'Energiestadt'),
('Green Solutions GmbH', 'Solarweg', '25', '67890', 'Solartown');

# -- Einträge in ansprechpartner_entity
INSERT INTO ansprechpartner_entity (eigentuemer_id, name, telefon, email, strasse, hausnummer, plz, ort)
VALUES
(1, 'Max Mustermann', '0123/456789', 'max.mustermann@muster.de', 'Musterstrasse', '10', '12345', 'Musterstadt'),
(1, 'Julia Mustermann', '0123/456780', 'julia.mustermann@muster.de', 'Musterstrasse', '10', '12345', 'Musterstadt'),
(2, 'Thomas Mueller', '0987/654321', 'thomas.mueller@emobility.com', 'Energiestrasse', '5a', '54321', 'Energiestadt'),
(2, 'Lisa Bauer', '0987/654322', 'lisa.bauer@emobility.com', 'Energiestrasse', '5a', '54321', 'Energiestadt'),
(3, 'Sarah Green', '0111/222333', 'sarah.green@greensolutions.com', 'Solarweg', '25', '67890', 'Solartown'),
(3, 'Michael Smith', '0111/222334', 'michael.smith@greensolutions.com', 'Solarweg', '25', '67890', 'Solartown');

# -- Einträge in ladepunkt_entity
INSERT INTO ladepunkt_entity (
    eigentuemer_id, ladeleistung_kw, anschlussart, verfuegbarkeit, 
    gesamtleistung_kwh, strasse, hausnummer, plz, ort
)
VALUES
(1, 22.00, 'Typ 2', 'VERFUEGBAR', 33.00, 'Musterstrasse', '11', '12345', 'Musterstadt'),
(2, 150.00, 'CCS', 'IN_WARTUNG', 300.00, 'Energiestrasse', '5b', '54321', 'Energiestadt'),
(3, 11.00, 'Typ 2', 'VERFUEGBAR', 8.25, 'Solarweg', '26', '67890', 'Solartown'),
(NULL, 50.00, 'CCS', 'VERFUEGBAR', 0.00, 'Freiheitsstrasse', '1', '11111', 'Unbekannt');