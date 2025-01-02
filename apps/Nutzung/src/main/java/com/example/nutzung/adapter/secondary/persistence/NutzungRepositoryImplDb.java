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
        Optional<NutzungEntity> entity = jdbcRepo.findById(id.getId());
        return entity.map(e -> e.toDomain()).orElse(null);
    }

    @Override
    public void save(Nutzung nutzung) {
        NutzungEntity entity = new NutzungEntity(nutzung);
        jdbcRepo.save(entity);
        nutzung.setNutzungsId(new NutzungId(entity.getNutzungsId()));
    }

    @Override
    public void delete(NutzungId id) {
        jdbcRepo.deleteById(id.getId());
    }

    @Override
    public List<Nutzung> findAll() {
        List<NutzungEntity> entities = (List<NutzungEntity>) jdbcRepo.findAll();
        return entities.stream().map(e -> e.toDomain()).collect(Collectors.toList());
    }

    @Override
    public List<Nutzung> findAllByHalterId(FahrzeughalterId halterId) {
        List<NutzungEntity> entities = jdbcRepo.findByHalterId(halterId.getId());
        return entities.stream().map(e -> e.toDomain()).collect(Collectors.toList());
    }
}
