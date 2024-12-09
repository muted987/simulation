package com.muted987.simulation.entities.creatures;

import com.muted987.simulation.Coordinates;
import com.muted987.simulation.entities.Entity;
import com.muted987.simulation.entities.EntityName;
import com.muted987.simulation.simulationmap.SimulationMap;

import java.util.ArrayList;

public abstract class Creature extends com.muted987.simulation.entities.Entity {

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
    public ArrayList<CoordinatesShift> availableMoves() {
        ArrayList<CoordinatesShift> result = new ArrayList<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) continue;
                result.add(new CoordinatesShift(x, y));
            }
        }
        return result;
    }
}
