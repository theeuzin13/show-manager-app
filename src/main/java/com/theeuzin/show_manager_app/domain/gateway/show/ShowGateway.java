package com.theeuzin.show_manager_app.domain.gateway.show;

import com.theeuzin.show_manager_app.domain.entity.show.ShowEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShowGateway {
    ShowEntity save(ShowEntity show);
    ShowEntity update(ShowEntity show);
    Optional<ShowEntity> findById(UUID id);
    List<ShowEntity> findAll();
    void deleteById(UUID id);
}