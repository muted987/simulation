package com.muted987.simulation;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.entity.Grass;
import com.muted987.simulation.entity.creature.Herbivore;
import com.muted987.simulation.entity.creature.Predator;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.*;
import java.util.stream.Collectors;

public class EntityCollectionAggregator {

    public List<Entity> aggregate(SimulationMap simulationMap, EntitySymbol type) {
        List<Entity> entityCollection = new ArrayList<>();
        List<Entity> sortedEntities = new ArrayList<>();
        Map<Coordinates, Entity> entitiesCoordinatesMap = new HashMap<>();
        if (type == EntitySymbol.Herbivore) {
            Map<Coordinates, Entity> map = simulationMap.getSimulationMap();
            ArrayList<Entity> entityArrayList = new ArrayList<>(map.values());
            for (Entity entity : entityArrayList) {
                if (entity instanceof Herbivore || entity instanceof Grass) {
                    entityCollection.add(entity);
                }
            }
            sortedEntities = entityCollection.stream()
                    .sorted((e1, e2) -> {
                        if (e1 instanceof Herbivore && e2 instanceof Grass) {
                            return -1; // Herbivore перед Grass
                        } else if (e1 instanceof Grass && e2 instanceof Herbivore) {
                            return 1; // Grass после Herbivore
                        } else {
                            return 0; // Оба объекта одного типа
                        }
                    }).collect(Collectors.toList());
        } else if (type == EntitySymbol.Predator) {
            Map<Coordinates, Entity> map = simulationMap.getSimulationMap();
            ArrayList<Entity> entityArrayList = new ArrayList<>(map.values());
            for (Entity entity : entityArrayList) {
                if (entity instanceof Herbivore || entity instanceof Predator) {
                    entityCollection.add(entity);
                }
            }
            sortedEntities = entityCollection.stream()
                    .sorted((e1, e2) -> {
                        if (e1 instanceof Predator && e2 instanceof Herbivore) {
                            return -1; // Herbivore перед Grass
                        } else if (e1 instanceof Herbivore && e2 instanceof Predator) {
                            return 1; // Grass после Herbivore
                        } else {
                            return 0; // Оба объекта одного типа
                        }
                    }).collect(Collectors.toList());

        }
        return sortedEntities;
    }

}
