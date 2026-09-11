package com.theeuzin.show_manager_app.infrastructure.persistence.mapper.show;

import com.theeuzin.show_manager_app.domain.entity.show.ShowEntity;
import com.theeuzin.show_manager_app.infrastructure.persistence.entity.show.ShowJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class ShowEntityMapper {

    public ShowJpaEntity toJpa(ShowEntity show) {
        ShowJpaEntity entity = new ShowJpaEntity(
                show.getName(),
                show.getVenue(),
                show.getPrice(),
                show.getDate(),
                show.getStatus()
        );
        entity.setId(show.getId());
        return entity;
    }

    public ShowEntity toDomain(ShowJpaEntity entity) {
        return new ShowEntity(
                entity.getId(),
                entity.getName(),
                entity.getVenue(),
                entity.getPrice(),
                entity.getDate(),
                entity.getStatus()
        );
    }
}