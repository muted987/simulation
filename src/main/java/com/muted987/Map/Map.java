package main.java.com.muted987.Map;

import main.java.com.muted987.Entities.*;

import java.util.HashMap;

public class Map {

    private int height = 0;
    private int width = 0;
    private final HashMap<Coordinates, Entity> entities = new HashMap<>();
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

    public void setParameters(int height, int width){
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public boolean isFieldEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public boolean isAnyHerbivoreAlive() {
        for (Entity entities : entities.values()) {
            if (entities.getClass().getSimpleName().equals("Herbivore")) {
                return true;
            }
        }
        return false;
    }
    public boolean isAnyGrassOnMap() {
        for (Entity entities : entities.values()) {
            if (entities.getClass().getSimpleName().equals("Grass")) {
                return true;
            }
        }
        return false;
    }
}
