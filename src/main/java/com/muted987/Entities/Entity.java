package main.java.com.muted987.Entities;

import main.java.com.muted987.Coordinates;

import java.util.Objects;

public abstract class Entity {
    public Coordinates coordinates;
    public final String unicodeSymbol;

    public Entity(Coordinates coordinates, String unicodeSymbol) {
        this.coordinates = coordinates;
        this.unicodeSymbol = unicodeSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(coordinates, entity.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordinates);
    }
}
