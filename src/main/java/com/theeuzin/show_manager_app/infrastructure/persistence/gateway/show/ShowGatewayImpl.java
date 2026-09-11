package com.theeuzin.show_manager_app.infrastructure.persistence.gateway.show;

import com.theeuzin.show_manager_app.domain.entity.show.ShowEntity;
import com.theeuzin.show_manager_app.domain.exception.show.ShowNotFoundException;
import com.theeuzin.show_manager_app.domain.gateway.show.ShowGateway;
import com.theeuzin.show_manager_app.infrastructure.persistence.entity.show.ShowJpaEntity;
import com.theeuzin.show_manager_app.infrastructure.persistence.mapper.show.ShowEntityMapper;
import com.theeuzin.show_manager_app.infrastructure.persistence.repository.show.ShowJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ShowGatewayImpl implements ShowGateway {

    private final ShowJpaRepository repository;
    private final ShowEntityMapper mapper;

    public ShowGatewayImpl(ShowJpaRepository repository, ShowEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ShowEntity save(ShowEntity show) {
        ShowJpaEntity saved = repository.save(mapper.toJpa(show));
        return mapper.toDomain(saved);
    }

    @Override
    @Transactional
    public ShowEntity update(ShowEntity show) {
        ShowJpaEntity entity = repository.findById(show.getId())
                .orElseThrow(() -> new ShowNotFoundException(show.getId()));

        entity.setName(show.getName());
        entity.setVenue(show.getVenue());
        entity.setPrice(show.getPrice());
        entity.setDate(show.getDate());
        entity.setStatus(show.getStatus());

        return mapper.toDomain(entity);
    }

    @Override
    public Optional<ShowEntity> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<ShowEntity> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}