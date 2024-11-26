package main.java.com.muted987;

import main.java.com.muted987.Entities.*;

import java.util.HashMap;

public class Map {

    private int height = 0;
    private int width = 0;
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
    public void setMapWithCustomHeightWidth(){
        String[] mapSize = (InputMapSize.inputSizeOfMap()).split("x");
        int width = Integer.parseInt(mapSize[0]);
        int height = Integer.parseInt(mapSize[1]);
        for (int widthIndex = 0; widthIndex < width; widthIndex++) {
            for (int heightIndex = 0; heightIndex < height; heightIndex++) {
                Coordinates coordinates = new Coordinates(widthIndex, heightIndex);
                setEntity(coordinates, new Entity(coordinates, null) {
                });
            }
        }
    }
}
