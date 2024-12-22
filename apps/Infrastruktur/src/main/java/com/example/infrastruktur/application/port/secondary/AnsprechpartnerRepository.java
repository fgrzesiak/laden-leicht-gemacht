package com.example.infrastruktur.application.port.secondary;

import java.util.List;

import com.example.infrastruktur.application.domain.Ansprechpartner;
import com.example.infrastruktur.application.domain.AnsprechpartnerId;
import com.example.infrastruktur.application.domain.EigentuemerId;

public interface AnsprechpartnerRepository {
    Ansprechpartner findById(AnsprechpartnerId id);

    void save(Ansprechpartner ansprechpartner);

    void delete(AnsprechpartnerId id);

    List<Ansprechpartner> findAll();

    List<Ansprechpartner> findByEigentuemerId(EigentuemerId eigentuemerId);
}
