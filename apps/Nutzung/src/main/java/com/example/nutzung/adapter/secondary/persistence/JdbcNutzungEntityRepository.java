package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JdbcNutzungEntityRepository extends CrudRepository<NutzungEntity, Integer> {
    List<NutzungEntity> findByHalterId(int halterId);
}
