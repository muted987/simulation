package com.muted987.simulation.entity;

import java.util.Objects;

public abstract class Entity {
    private EntitySymbol entitySymbol;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return entitySymbol == entity.entitySymbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entitySymbol);
    }

    public Entity(EntitySymbol entitySymbol) {
        this.entitySymbol = entitySymbol;
    }

    public EntitySymbol getEntitySymbol() {
        return entitySymbol;
    }
}
