package com.example.infrastruktur.adapter.secondary.persistence;

import org.springframework.data.repository.CrudRepository;

public interface JdbcEigentuemerEntityRepository
		extends CrudRepository<EigentuemerEntity, Integer> {
}
