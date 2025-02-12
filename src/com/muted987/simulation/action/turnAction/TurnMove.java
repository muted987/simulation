package com.muted987.simulation.action.turnAction;

import com.muted987.simulation.action.Action;
import com.muted987.simulation.action.aStarAlgorithm.AStar;
import com.muted987.simulation.action.aStarAlgorithm.Node;
import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.entity.Grass;
import com.muted987.simulation.entity.creature.Creature;
import com.muted987.simulation.entity.creature.Herbivore;
import com.muted987.simulation.entity.creature.Predator;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.*;

public class TurnMove extends Action {

    private static Map<Coordinates, Creature> herbivoreMap = new HashMap<>();
    private static Map<Coordinates, Entity> grassMap = new HashMap<>();

    private static Map<Coordinates, Creature> creatureMap = new HashMap<>();

    public TurnMove(SimulationMap simulationMap) {
        updateHashMap(simulationMap);
    }

    @Override
    public SimulationMap execute(SimulationMap simulationMap) {
        SimulationMap executableMap = simulationMap;
        updateCreatureMap(executableMap);
        for (Map.Entry<Coordinates, Creature> entry : creatureMap.entrySet()) {
            Creature entryCreature = entry.getValue();
            if (entryCreature instanceof Herbivore) {
                updateGrassMap(executableMap);
                Map<Coordinates, Entity> randomGrass = getRandomValueFromMap(grassMap);
                for (Map.Entry<Coordinates, Entity> entryGrass : randomGrass.entrySet()) {
                   entryCreature.setTargetEntity(entryGrass.getValue());
                   entryCreature.setTargetCoordinates(entryGrass.getKey());
                }
            } else {
                updateHerbivoreMap(executableMap);
                Map<Coordinates, Creature> randomHerbivore = getRandomValueFromMap(herbivoreMap);
                for (Map.Entry<Coordinates, Creature> entryHerbivore : randomHerbivore.entrySet()) {
                    entryCreature.setTargetEntity(entryHerbivore.getValue());
                    entryCreature.setTargetCoordinates(entryHerbivore.getKey());
                }
            }
            List<Node> pathToTarget = AStar.findPath(executableMap, entry);
            entryCreature.setPathToTarget(pathToTarget);
            entryCreature.makeMove(executableMap);

        }
        return executableMap;
    }

    private  <T extends Entity> Map<Coordinates,  T> getRandomValueFromMap(Map<Coordinates, T> map) {
        Random random = new Random();
        Map<Coordinates, T> result = new HashMap<>();
        int randomIndex = random.nextInt(map.size());
        List<Coordinates> listOfCoordinates = new ArrayList<>(map.keySet());
        Coordinates randomKey = listOfCoordinates.get(randomIndex);
        result.put(randomKey, map.get(randomKey));
        return result;
    }

    private void updateCreatureMap(SimulationMap simulationMap) {
        creatureMap.clear();
        creatureMap = simulationMap.creatureMap();
    }

    private void updateGrassMap(SimulationMap simulationMap) {
        grassMap.clear();
        grassMap = simulationMap.entityMapByType(EntitySymbol.Grass);
    }

    private void updateHerbivoreMap(SimulationMap simulationMap) {
        herbivoreMap.clear();
        herbivoreMap = simulationMap.creatureMapByType(EntitySymbol.Herbivore);
    }

    private void updateHashMap(SimulationMap simulationMap) {
        herbivoreMap = simulationMap.creatureMapByType(EntitySymbol.Herbivore);
        creatureMap = simulationMap.creatureMap();
        grassMap = simulationMap.entityMapByType(EntitySymbol.Grass);
    }


}
