package com.example.infrastruktur.application.port.secondary;

import com.example.infrastruktur.application.domain.Eigentuemer;
import com.example.infrastruktur.application.domain.EigentuemerId;
import java.util.List;

public interface EigentuemerRepository {
    Eigentuemer findById(EigentuemerId id);

    void save(Eigentuemer eigentuemer);

    void delete(EigentuemerId id);

    List<Eigentuemer> findAll();
}
