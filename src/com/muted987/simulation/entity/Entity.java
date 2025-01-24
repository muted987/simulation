package com.muted987.simulation.entity;

public abstract class Entity {
    Coordinates coordinates;
    EntitySymbol entitySymbol;

    public Entity(Coordinates coordinates, EntitySymbol entitySymbol) {
        this.coordinates = coordinates;
        this.entitySymbol = entitySymbol;
    }

    public EntitySymbol getEntitySymbol() {
        return entitySymbol;
    }
}
