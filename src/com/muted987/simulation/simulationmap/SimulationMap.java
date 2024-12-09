package com.muted987.simulation.simulationmap;

import com.muted987.simulation.Coordinates;
import com.muted987.simulation.entities.Entity;
import com.muted987.simulation.entities.EntityName;

import java.util.HashMap;
import java.util.Map;

public class SimulationMap {

    private final int HEIGHT = 10;
    private final int WIDTH = 10;

    public int getHEIGHT() {
        return HEIGHT;
    }

    public HashMap<Coordinates, Entity> getSimulationMap() {
        return simulationMap;
    }

    public int getWIDTH() {
        return WIDTH;
    }
    private final HashMap<Coordinates, Entity> simulationMap = new HashMap<>();
    public void setEntityOnMap(Coordinates coordinates, Entity entity){
        simulationMap.put(coordinates, entity);
    }
    public void removeEntityFromMap(Coordinates coordinates) {
        simulationMap.remove(coordinates);
    }
    public com.muted987.simulation.entities.Entity getEntity(Coordinates coordinates) { return simulationMap.get(coordinates);}
    public void simulationMapClear() { simulationMap.clear();}
    public boolean isFieldFree(Coordinates coordinates) {
        return !simulationMap.containsKey(coordinates);
    }
    public HashMap<Coordinates, Entity> getAllCreatures() {
        HashMap<Coordinates, Entity> creatures = new HashMap<>();
        for (Map.Entry<Coordinates, Entity> entry : simulationMap.entrySet()) {
            Coordinates coordinates = entry.getKey();
            Entity entity = entry.getValue();
            if (isCreature(entity)) {
                creatures.put(coordinates, entity);
            }
        }
        return creatures;
    }
    private boolean isCreature(Entity entity) {
        return entity.getEntityName().equals(EntityName.HERBIVORE) || entity.getEntityName().equals(EntityName.PREDATOR);
    }
    public boolean isGrass(Coordinates coordinates) {
        return getEntity(coordinates).getEntityName().equals(EntityName.GRASS);
    }
}
