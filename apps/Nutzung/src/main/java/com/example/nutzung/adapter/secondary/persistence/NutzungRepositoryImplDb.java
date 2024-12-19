package com.example.nutzung.adapter.secondary.persistence;

import com.example.nutzung.application.domain.Nutzung;
import com.example.nutzung.application.domain.NutzungId;
import com.example.nutzung.application.domain.FahrzeughalterId;
import com.example.nutzung.application.port.secondary.NutzungRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NutzungRepositoryImplDb implements NutzungRepository {

    private final JdbcNutzungEntityRepository jdbcRepo;

    public NutzungRepositoryImplDb(JdbcNutzungEntityRepository jdbcRepo) {
        this.jdbcRepo = jdbcRepo;
    }

    @Override
    public Nutzung findById(NutzungId id) {
        Optional<NutzungEntity> e = jdbcRepo.findById(Integer.valueOf(id.getId()));
        return e.map(NutzungEntity::toDomain).orElse(null);
    }

    @Override
    public void save(Nutzung nutzung) {
        NutzungEntity entity = new NutzungEntity(nutzung);
        jdbcRepo.save(entity);
    }

    @Override
    public void delete(NutzungId id) {
        jdbcRepo.deleteById(Integer.valueOf(id.getId()));
    }

    @Override
    public List<Nutzung> findAllByHalterId(FahrzeughalterId halterId) {
        List<NutzungEntity> entities = jdbcRepo.findByHalterId(Integer.valueOf(halterId.getId()));
        return entities.stream().map(NutzungEntity::toDomain).collect(Collectors.toList());
    }
}
