package com.muted987.simulation.entities;

public abstract class Entity {
    public Entity(EntityName entityName) {
        this.entityName = entityName;
    }

    private EntityName entityName;

    public EntityName getEntityName() {
        return entityName;
    }

    public String getEntityUnicodeSymbol() {
        return entityName.getEntityUnicodeSymbol();
    }
}
