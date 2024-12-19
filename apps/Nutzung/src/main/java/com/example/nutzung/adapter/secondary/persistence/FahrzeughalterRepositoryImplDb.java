package com.example.nutzung.adapter.secondary.persistence;

import com.example.nutzung.application.domain.Fahrzeughalter;
import com.example.nutzung.application.domain.FahrzeughalterId;
import com.example.nutzung.application.port.secondary.FahrzeughalterRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class FahrzeughalterRepositoryImplDb implements FahrzeughalterRepository {

    private final JdbcFahrzeughalterEntityRepository jdbcRepo;

    public FahrzeughalterRepositoryImplDb(JdbcFahrzeughalterEntityRepository jdbcRepo) {
        this.jdbcRepo = jdbcRepo;
    }

    @Override
    public Fahrzeughalter findById(FahrzeughalterId id) {
        Optional<FahrzeughalterEntity> e = jdbcRepo.findById(Integer.valueOf(id.getId()));
        return e.map(FahrzeughalterEntity::toDomain).orElse(null);
    }

    @Override
    public void save(Fahrzeughalter halter) {
        FahrzeughalterEntity entity = new FahrzeughalterEntity(halter);
        jdbcRepo.save(entity);
        halter.setHalterId(new FahrzeughalterId(entity.getHalterId()));
    }

    @Override
    public void delete(FahrzeughalterId id) {
        jdbcRepo.deleteById(Integer.valueOf(id.getId()));
    }

    @Override
    public List<Fahrzeughalter> findAll() {
        return StreamSupport.stream(jdbcRepo.findAll().spliterator(), false)
                .map(FahrzeughalterEntity::toDomain)
                .collect(Collectors.toList());
    }
}
