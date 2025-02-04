package com.muted987.simulation;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.entity.creature.Herbivore;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClosestEntity {

    private final MinimumDistance minimumDistanceCalculator = new MinimumDistance();

    public List<Entity> getClosestEntity(List<Entity> arrayOfEntities, SimulationMap simulationMap) {
        Entity firstEntity = arrayOfEntities.get(0);
        int maximumDistance = 20;
        Coordinates firstEntityCoordinates = simulationMap.getEntityCoordinates(firstEntity);
        int index = 1;
        while (arrayOfEntities.size() != 2) {
            Entity secondEntity = arrayOfEntities.get(index);
            Coordinates secondEntityCoordinates = simulationMap.getEntityCoordinates(secondEntity);
            int minimumDistance = minimumDistanceCalculator.getDistance(firstEntityCoordinates, secondEntityCoordinates);
            if (minimumDistance >= maximumDistance) {
                arrayOfEntities.remove(index);
                index = 1;
            } else {
                index++;
                maximumDistance = minimumDistance;
            }
        }
        return arrayOfEntities;
    }


}
