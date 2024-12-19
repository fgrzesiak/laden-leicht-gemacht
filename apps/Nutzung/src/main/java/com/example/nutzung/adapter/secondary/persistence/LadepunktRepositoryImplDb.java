package com.example.nutzung.adapter.secondary.persistence;

import com.example.nutzung.application.domain.Ladepunkt;
import com.example.nutzung.application.port.secondary.LadepunktRepository;

public class LadepunktRepositoryImplDb implements LadepunktRepository {

	private final JdbcLadepunktEntityRepository jdbcLadepunktEntityRepository;

	public LadepunktRepositoryImplDb(JdbcLadepunktEntityRepository jdbcLadepunktEntityRepository) {
		this.jdbcLadepunktEntityRepository = jdbcLadepunktEntityRepository;
	}

	@Override
	public void save(Ladepunkt ladepunkt) {
		LadepunktEntity ladepunktEntity = new LadepunktEntity(ladepunkt);
		jdbcLadepunktEntityRepository.save(ladepunktEntity);
	}
}
