package com.example.infrastruktur.adapter.secondary.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JdbcAnsprechpartnerEntityRepository
		extends CrudRepository<AnsprechpartnerEntity, Integer> {

	List<AnsprechpartnerEntity> findByEigentuemerId(Integer eigentuemerId);
}
