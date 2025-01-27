package com.muted987.simulation.entity;

import java.util.Objects;

public abstract class Entity {
    Coordinates coordinates;
    EntitySymbol entitySymbol;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return coordinates.equals(entity.coordinates) && entitySymbol == entity.entitySymbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, entitySymbol);
    }

    public Entity(Coordinates coordinates, EntitySymbol entitySymbol) {
        this.coordinates = coordinates;
        this.entitySymbol = entitySymbol;
    }

    public EntitySymbol getEntitySymbol() {
        return entitySymbol;
    }
}
