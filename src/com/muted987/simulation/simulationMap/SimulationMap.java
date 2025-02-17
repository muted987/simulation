package com.muted987.simulation.simulationMap;

import com.muted987.simulation.entity.*;
import com.muted987.simulation.entity.creature.Creature;
import com.muted987.simulation.entity.creature.Herbivore;
import com.muted987.simulation.entity.creature.Predator;

import java.util.*;

public class SimulationMap {

    private final Map<Coordinates, Entity> simulationMap = new HashMap<>();
    private final AmountOfEntities amountOfEntities = new AmountOfEntities();

    private final static int MAX_X = 10;

    private final static int MAX_Y = 10;
    public int getMAX_X() {
        return MAX_X;
    }

    public int getMAX_Y() {
        return MAX_Y;
    }

    public void setEntity(Entity entity, Coordinates coordinates) {
        simulationMap.put(coordinates, entity);
    }

    public AmountOfEntities getAmountOfEntities() {
        return amountOfEntities;
    }
    public void removeEntity(Coordinates coordinates) {
        simulationMap.remove(coordinates);
    }
    public Entity getEntity(Coordinates from) {
        return simulationMap.get(from);
    }
    public Map<Coordinates, Entity> getSimulationMap() {
        return simulationMap;
    }

    public void moveEntity(Coordinates from, Coordinates to) {
        Entity entityTo = getEntity(from);
        removeEntity(from);
        setEntity(entityTo, to);
    }

    public Map<Coordinates, Creature> creatureMap() {
        Map<Coordinates, Creature> result = new HashMap<>();
        for (Map.Entry<Coordinates, Entity> entry : simulationMap.entrySet()) {
            if (entry.getValue() instanceof Creature) {
                result.put(entry.getKey(), (Creature) entry.getValue());
            }
        }
        return result;
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return !simulationMap.containsKey(coordinates);
    }
    public Map<Coordinates, Creature> creatureMapByType(EntitySymbol type) {
        Map<Coordinates, Creature> result = new HashMap<>();
        for (Map.Entry<Coordinates, Entity> entry : simulationMap.entrySet()) {
            if (entry.getValue().getEntitySymbol() == type) {
                result.put(entry.getKey(), (Creature) entry.getValue());
            }
        }
        return result;
    }

    public Map<Coordinates, Entity> entityMapByType(EntitySymbol type) {
        Map<Coordinates, Entity> result = new HashMap<>();
        for (Map.Entry<Coordinates, Entity> entry : simulationMap.entrySet()) {
            EntitySymbol entryType = null;
            try {
                entryType = entry.getValue().getEntitySymbol();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (entryType == type) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    public boolean isType(Coordinates coordinates, EntitySymbol entityType) {
        Entity entity = getEntity(coordinates);
        switch (entityType) {
            case Herbivore:
                return entity instanceof Herbivore;
            case Predator:
                return entity instanceof Predator;
            case Grass:
                return entity instanceof Grass;
            case Tree:
                return entity instanceof Tree;
            case Rock:
                return entity instanceof Rock;
        }
        return false;
    }

    public Map<EntitySymbol, Integer> getMapAmountOfEntities() {
        return getAmountOfEntities().getAmountOfEntities();
    }
}
