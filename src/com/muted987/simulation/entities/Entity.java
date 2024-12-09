package com.muted987.simulation.entities;

import java.util.Objects;

public abstract class Entity {
    public Entity(EntityName entityName) {
        this.entityName = entityName;
    }

    private final EntityName entityName;

    public EntityName getEntityName() {
        return entityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        if (((Entity) o).getEntityName().equals(((Entity) o).getEntityName())) return true;
        return entityName == entity.entityName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entityName);
    }

    public String getEntityUnicodeSymbol() {
        return entityName.getEntityUnicodeSymbol();
    }
}
