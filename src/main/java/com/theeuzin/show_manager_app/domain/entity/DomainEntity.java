package com.theeuzin.show_manager_app.domain.entity;

import java.util.Objects;
import java.util.UUID;

public abstract class DomainEntity {

    protected final UUID id;

    protected DomainEntity(UUID id){
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainEntity other = (DomainEntity) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
