package main.java.com.muted987.Entities;

import main.java.com.muted987.Coordinates;

public abstract class Entity {
    public Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

}
