package com.muted987.simulation.entities.creatures;

import com.muted987.simulation.Coordinates;
import com.muted987.simulation.entities.Entity;
import com.muted987.simulation.entities.EntityName;
import com.muted987.simulation.simulationmap.SimulationMap;

public abstract class Creature extends Entity {

    private final Coordinates coordinates;

    public Creature(EntityName entityName, Coordinates coordinates) {
        super(entityName);
        this.coordinates = coordinates;
    }

    public void makeMove(SimulationMap map, Coordinates from, Coordinates to) {
        Entity entity = map.getEntity(coordinates);
        map.removeEntityFromMap(from);
        map.setEntityOnMap(to, entity);
    }
}
