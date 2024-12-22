package com.example.infrastruktur.adapter.secondary.persistence;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.infrastruktur.application.domain.Ladepunkt;
import com.example.infrastruktur.application.domain.LadepunktId;
import com.example.infrastruktur.application.mapper.LadepunktMapper;
import com.example.infrastruktur.application.port.secondary.LadepunktRepository;

public class LadepunktRepositoryImplDb implements LadepunktRepository {

    private final JdbcLadepunktEntityRepository jdbcLadepunktEntityRepository;

    public LadepunktRepositoryImplDb(JdbcLadepunktEntityRepository jdbcLadepunktEntityRepository) {
        this.jdbcLadepunktEntityRepository = jdbcLadepunktEntityRepository;
    }

    @Override
    public Ladepunkt findById(LadepunktId ladepunktId) {
        Optional<LadepunktEntity> ladepunktEntity = jdbcLadepunktEntityRepository.findById(ladepunktId.getId());
        return ladepunktEntity.map(LadepunktMapper::toDomain).orElse(null);
    }

    @Override
    public void save(Ladepunkt ladepunkt) {
        LadepunktEntity ladepunktEntity = LadepunktMapper.toEntity(ladepunkt);
        jdbcLadepunktEntityRepository.save(ladepunktEntity);
        ladepunkt.setLadepunktId(new LadepunktId(ladepunktEntity.getLadepunktId())); // set auto-generated ID
    }

    @Override
    public void delete(LadepunktId ladepunktId) {
        jdbcLadepunktEntityRepository.deleteById(ladepunktId.getId());
    }

    @Override
    public List<Ladepunkt> findAll() {
        List<LadepunktEntity> entities = (List<LadepunktEntity>) jdbcLadepunktEntityRepository.findAll();
        return entities.stream().map(LadepunktMapper::toDomain).collect(Collectors.toList());
    }
}
