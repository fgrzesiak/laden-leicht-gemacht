package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JdbcFahrzeughalterEntityRepository extends CrudRepository<FahrzeughalterEntity, Integer> {
}
