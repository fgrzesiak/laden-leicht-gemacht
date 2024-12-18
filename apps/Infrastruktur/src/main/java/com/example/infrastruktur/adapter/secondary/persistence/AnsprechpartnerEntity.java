package com.example.infrastruktur.adapter.secondary.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import com.example.infrastruktur.application.domain.Ansprechpartner;
import com.example.infrastruktur.application.domain.AnsprechpartnerId;
import com.example.infrastruktur.application.domain.EigentuemerId;
import com.example.infrastruktur.application.domain.Adresse;

public class AnsprechpartnerEntity {

    @Id
    private Integer ansprechpartnerId;

    private Integer eigentuemerId;
    private String name;
    private String telefon;
    private String email;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    private AdresseEntity adresse;

    public AnsprechpartnerEntity() {
    }

    public AnsprechpartnerEntity(Integer ansprechpartnerId, Integer eigentuemerId, String name, String telefon,
            String email, Adresse adresse) {
        this.ansprechpartnerId = ansprechpartnerId;
        this.eigentuemerId = eigentuemerId;
        this.name = name;
        this.telefon = telefon;
        this.email = email;
        this.adresse = new AdresseEntity(adresse);
    }

    public AnsprechpartnerEntity(Ansprechpartner domain) {
        this.eigentuemerId = domain.getEigentuemerId().getId();
        this.name = domain.getName();
        this.telefon = domain.getTelefon();
        this.email = domain.getEmail();
        this.adresse = new AdresseEntity(domain.getAdresse());
    }

    public Ansprechpartner toDomain() {
        AnsprechpartnerId ansprechpartnerId = new AnsprechpartnerId(this.ansprechpartnerId);
        EigentuemerId eigentuemerId = new EigentuemerId(this.eigentuemerId);
        return new Ansprechpartner(ansprechpartnerId, eigentuemerId, this.name, this.telefon, this.email,
                this.adresse.toDomain());
    }

    // Getter/Setter
    public Integer getAnsprechpartnerId() {
        return ansprechpartnerId;
    }

    public void setAnsprechpartnerId(Integer ansprechpartnerId) {
        this.ansprechpartnerId = ansprechpartnerId;
    }

    public Integer getEigentuemerId() {
        return eigentuemerId;
    }

    public void setEigentuemerId(Integer eigentuemerId) {
        this.eigentuemerId = eigentuemerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AdresseEntity getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseEntity adresse) {
        this.adresse = adresse;
    }
}
