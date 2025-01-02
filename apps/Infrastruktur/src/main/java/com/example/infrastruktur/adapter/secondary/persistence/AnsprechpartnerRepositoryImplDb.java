package com.example.infrastruktur.adapter.secondary.persistence;

import com.example.infrastruktur.application.domain.Ansprechpartner;
import com.example.infrastruktur.application.domain.AnsprechpartnerId;
import com.example.infrastruktur.application.domain.EigentuemerId;
import com.example.infrastruktur.application.port.secondary.AnsprechpartnerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnsprechpartnerRepositoryImplDb implements AnsprechpartnerRepository {

    private final JdbcAnsprechpartnerEntityRepository jdbcRepo;

    public AnsprechpartnerRepositoryImplDb(JdbcAnsprechpartnerEntityRepository jdbcRepo) {
        this.jdbcRepo = jdbcRepo;
    }

    @Override
    public Ansprechpartner findById(AnsprechpartnerId id) {
        Optional<AnsprechpartnerEntity> entity = jdbcRepo.findById(id.getId());
        return entity.map(e -> e.toDomain()).orElse(null);
    }

    @Override
    public void save(Ansprechpartner ansprechpartner) {
        AnsprechpartnerEntity entity = new AnsprechpartnerEntity(ansprechpartner);
        jdbcRepo.save(entity);
        ansprechpartner.setAnsprechpartnerId(new AnsprechpartnerId(entity.getAnsprechpartnerId()));
    }

    @Override
    public void delete(AnsprechpartnerId id) {
        jdbcRepo.deleteById(id.getId());
    }

    @Override
    public List<Ansprechpartner> findAll() {
        List<AnsprechpartnerEntity> entities = (List<AnsprechpartnerEntity>) jdbcRepo.findAll();
        return entities.stream().map(e -> e.toDomain()).collect(Collectors.toList());
    }

    @Override
    public List<Ansprechpartner> findByEigentuemerId(EigentuemerId eigentuemerId) {
        List<AnsprechpartnerEntity> entities = jdbcRepo.findByEigentuemerId(eigentuemerId.getId());
        return entities.stream().map(e -> e.toDomain()).collect(Collectors.toList());
    }
}
