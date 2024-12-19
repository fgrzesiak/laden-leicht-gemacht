package com.example.nutzung.adapter.secondary.persistence;

import org.springframework.data.repository.CrudRepository;

public interface JdbcFahrzeughalterEntityRepository extends CrudRepository<FahrzeughalterEntity, Integer> {
}
