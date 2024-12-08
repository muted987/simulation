package com.muted987.simulation.simulationmap;

import com.muted987.simulation.Coordinates;
import com.muted987.simulation.entities.Entity;
import com.muted987.simulation.entities.creatures.Creature;

import java.util.HashMap;

public class SimulationMap {

    private final int HEIGHT = 10;
    private final int WIDTH = 10;

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }
    HashMap<Coordinates, Entity> simulationMap = new HashMap<>();
    public void setEntityOnMap(Coordinates coordinates, Entity entity){
        simulationMap.put(coordinates, entity);
    }
    public void removeEntityFromMap(Coordinates coordinates) {
        simulationMap.remove(coordinates);
    }
    public Entity getEntity(Coordinates coordinates) {
        return simulationMap.get(coordinates);
    }
    public void simulationMapClear() {
        simulationMap.clear();
    }
    public boolean isFieldFree(Coordinates coordinates) {
        return !simulationMap.containsKey(coordinates);
    }
    public HashMap<Coordinates, Creature> getAllCreatures() {
        HashMap<Coordinates, Creature> creatures = new HashMap<>();
        for (Coordinates coordinates : simulationMap.keySet()) {
            if (isCreature(coordinates)) {
                creatures.put(coordinates, getCreature(coordinates));
            }
        }
        return creatures;
    }
    private Creature getCreature(Coordinates coordinates) {
        return (Creature) simulationMap.get(coordinates);
    }
    private boolean isCreature(Coordinates coordinates) {
        return getEntity(coordinates) instanceof Creature;
    }
}
