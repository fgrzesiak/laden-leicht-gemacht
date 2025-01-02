package com.example.nutzung.adapter.secondary.persistence;

import com.example.nutzung.application.domain.Fahrzeughalter;
import com.example.nutzung.application.domain.FahrzeughalterId;
import com.example.nutzung.application.port.secondary.FahrzeughalterRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FahrzeughalterRepositoryImplDb implements FahrzeughalterRepository {

    private final JdbcFahrzeughalterEntityRepository jdbcRepo;

    public FahrzeughalterRepositoryImplDb(JdbcFahrzeughalterEntityRepository jdbcRepo) {
        this.jdbcRepo = jdbcRepo;
    }

    @Override
    public Fahrzeughalter findById(FahrzeughalterId id) {
        Optional<FahrzeughalterEntity> entity = jdbcRepo.findById(id.getId());
        return entity.map(e -> e.toDomain()).orElse(null);
    }

    @Override
    public void save(Fahrzeughalter halter) {
        FahrzeughalterEntity fahrzeughalterEntity = new FahrzeughalterEntity(halter);
        jdbcRepo.save(fahrzeughalterEntity);
        halter.setHalterId(new FahrzeughalterId(fahrzeughalterEntity.getHalterId()));
    }

    @Override
    public void delete(FahrzeughalterId id) {
        jdbcRepo.deleteById(id.getId());
    }

    @Override
    public List<Fahrzeughalter> findAll() {
        List<FahrzeughalterEntity> entities = (List<FahrzeughalterEntity>) jdbcRepo.findAll();
        return entities.stream().map(e -> e.toDomain()).collect(Collectors.toList());
    }
}
