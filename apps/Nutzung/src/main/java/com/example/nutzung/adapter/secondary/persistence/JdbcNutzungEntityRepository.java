package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JdbcNutzungEntityRepository extends CrudRepository<NutzungEntity, Integer> {
    List<NutzungEntity> findByHalterId(int halterId);
}
