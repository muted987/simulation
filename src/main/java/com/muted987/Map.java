package main.java.com.muted987;

import main.java.com.muted987.Entities.Entity;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> entities = new HashMap<>();
    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entities.put(coordinates, entity);
    }
    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }
    public void moveEntity(Coordinates from, Coordinates to) {
        Entity entity = getEntity(from);
        removeEntity(from);
        setEntity(to, entity);
    }
    private Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

}
