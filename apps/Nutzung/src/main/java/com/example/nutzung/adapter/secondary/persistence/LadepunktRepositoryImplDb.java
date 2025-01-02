package com.example.nutzung.adapter.secondary.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.nutzung.application.domain.Ladepunkt;
import com.example.nutzung.application.domain.LadepunktId;
import com.example.nutzung.application.port.secondary.LadepunktRepository;

public class LadepunktRepositoryImplDb implements LadepunktRepository {

	private final JdbcLadepunktEntityRepository jdbcLadepunktEntityRepository;

	public LadepunktRepositoryImplDb(JdbcLadepunktEntityRepository jdbcLadepunktEntityRepository) {
		this.jdbcLadepunktEntityRepository = jdbcLadepunktEntityRepository;
	}

	@Override
	public Ladepunkt findById(LadepunktId ladepunktId) {
		Optional<LadepunktEntity> ladepunktEntity = jdbcLadepunktEntityRepository.findById(ladepunktId.getId());
		return ladepunktEntity.map(e -> e.toDomain()).orElse(null);
	}

	@Override
	public void save(Ladepunkt ladepunkt, boolean isNew) {
		LadepunktEntity ladepunktEntity = new LadepunktEntity(ladepunkt);
		ladepunktEntity.setIsNew(isNew);
		jdbcLadepunktEntityRepository.save(ladepunktEntity);
		ladepunkt.setLadepunktId(new LadepunktId(ladepunktEntity.getId()));
	}

	@Override
	public List<Ladepunkt> findAll() {
		List<LadepunktEntity> entities = (List<LadepunktEntity>) jdbcLadepunktEntityRepository.findAll();
		return entities.stream().map(e -> e.toDomain()).collect(Collectors.toList());
	}
}
