package com.example.infrastruktur.adapter.secondary.persistence;

import com.example.infrastruktur.application.domain.Eigentuemer;
import com.example.infrastruktur.application.domain.EigentuemerId;
import com.example.infrastruktur.application.mapper.EigentuemerMapper;
import com.example.infrastruktur.application.port.secondary.EigentuemerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EigentuemerRepositoryImplDb implements EigentuemerRepository {

    private final JdbcEigentuemerEntityRepository jdbcRepo;

    public EigentuemerRepositoryImplDb(JdbcEigentuemerEntityRepository jdbcRepo) {
        this.jdbcRepo = jdbcRepo;
    }

    @Override
    public Eigentuemer findById(EigentuemerId id) {
        Optional<EigentuemerEntity> entity = jdbcRepo.findById(id.getId());
        return entity.map(EigentuemerMapper::toDomain).orElse(null);
    }

    @Override
    public void save(Eigentuemer eigentuemer) {
        EigentuemerEntity entity = new EigentuemerEntity(eigentuemer);
        jdbcRepo.save(entity);
        eigentuemer.setEigentuemerId(new EigentuemerId(entity.getEigentuemerId())); // set auto-generated ID
    }

    @Override
    public void delete(EigentuemerId id) {
        jdbcRepo.deleteById(id.getId());
    }

    @Override
    public List<Eigentuemer> findAll() {
        return ((List<EigentuemerEntity>) jdbcRepo.findAll())
                .stream()
                .map(EigentuemerMapper::toDomain)
                .collect(Collectors.toList());
    }
}
