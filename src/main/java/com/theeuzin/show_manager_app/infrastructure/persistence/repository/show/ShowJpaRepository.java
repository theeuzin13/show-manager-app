package com.theeuzin.show_manager_app.infrastructure.persistence.repository.show;

import com.theeuzin.show_manager_app.infrastructure.persistence.entity.show.ShowJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShowJpaRepository extends JpaRepository<ShowJpaEntity, UUID> {
}
