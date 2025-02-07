package com.muted987.simulation.simulationMap;

import com.muted987.simulation.entity.*;
import com.muted987.simulation.entity.creature.Creature;

import java.util.*;

public class SimulationMap {

    private final Map<Coordinates, Entity> simulationMap = new HashMap<>();
    private final int MAX_X = 10;
    private final int MAX_Y = 10;

    public int getMAX_X() {
        return MAX_X;
    }

    public int getMAX_Y() {
        return MAX_Y;
    }

    public void setEntity(Entity entity, Coordinates coordinates) {
        simulationMap.put(coordinates, entity);
    }
    public void removeEntity(Coordinates coordinates) {
        simulationMap.remove(coordinates);
    }
    public Entity getEntity(Coordinates from) {
        return simulationMap.get(from);
    }
    public Coordinates getEntityCoordinates (Entity entity) {
        for (Map.Entry<Coordinates, Entity> entry : simulationMap.entrySet()){
                if (entry.getValue().equals(entity)) {
                    return entry.getKey();
                }
            }
        return null;
    }
    public Map<Coordinates, Entity> getSimulationMap() {
        return simulationMap;
    }

    public void moveEntity(Coordinates from, Coordinates to) {
        Entity entityTo = getEntity(from);
        removeEntity(from);
        setEntity(entityTo, to);
    }


    public boolean isCellEmpty(Coordinates coordinates) {
        return !simulationMap.containsKey(coordinates);
    }

    public boolean isNotImmovableEntity(int newX, int newY) {
        Coordinates coordinates = new Coordinates(newX, newY);
        Entity entity = getEntity(coordinates);
        return entity instanceof Tree || entity instanceof Rock;
    }

    public ArrayList<Creature> creatureListByType(EntitySymbol type) {
        ArrayList<Creature> result = new ArrayList<>();
        for (Entity entity : simulationMap.values()) {
            if (entity.getEntitySymbol().equals(type)) {
                result.add((Creature)entity);
            }
        }
        return result;
    }

    public List<Entity> entityListByType(EntitySymbol type) {
        ArrayList<Entity> result = new ArrayList<>();
        for (Entity entity : simulationMap.values()) {
            if (entity.getEntitySymbol().equals(type)) {
                result.add(entity);
            }
        }
        return result;
    }
}
