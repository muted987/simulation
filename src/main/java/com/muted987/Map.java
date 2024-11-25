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
    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void setMapWithCustomHeightWidth(){
        String[] mapSize = (InputMapSize.input()).split("x");
        int width = Integer.parseInt(mapSize[0]);
        int height = Integer.parseInt(mapSize[1]);
        for (int widthIndex = 0; widthIndex < width; widthIndex++) {
            for (int heightIndex = 0; heightIndex < height; heightIndex++) {
                Coordinates coordinates = new Coordinates(widthIndex, heightIndex);
                setEntity(coordinates, new Entity(coordinates) {
                });
            }
        }
    }
}
