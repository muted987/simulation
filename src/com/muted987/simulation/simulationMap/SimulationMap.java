package com.muted987.simulation.simulationMap;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;

import java.util.HashMap;
import java.util.Map;

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

    public Map<Coordinates, Entity> getSimulationMap() {
        return simulationMap;
    }

    public void moveEntity(Coordinates from, Coordinates to) {
        Entity entityTo = getEntity(from);
        removeEntity(from);
        setEntity(entityTo, to);
    }


}
