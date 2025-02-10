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
    private static Map<Coordinates, Creature> predatorMap = new HashMap<>();
    private static Map<Coordinates, Entity> grassMap = new HashMap<>();


    public TurnMove(SimulationMap simulationMap) {
        updateHashMap(simulationMap);
    }

    @Override
    public SimulationMap execute(SimulationMap simulationMap) {
        for (Map.Entry<Coordinates, Creature> entry : herbivoreMap.entrySet()) {
            Creature entryCreature = entry.getValue();
            Random random = new Random();
            if (entryCreature.getTargetEntity() == null) {
                updateHashMap(simulationMap);
                int steps = 1;
                int randomGrassIndex = random.nextInt(grassMap.size());
                List<Coordinates> grassCoordinates = new ArrayList<>(grassMap.keySet());
                Entity randomGrass = grassMap.get(grassCoordinates.get(randomGrassIndex));
                entryCreature.setTargetCoordinates(grassCoordinates.get(randomGrassIndex));
                entryCreature.setTargetEntity(randomGrass);
                List<Node> node = AStar.findPath(simulationMap, entryCreature, entryCreature.getTargetEntity());
                entryCreature.setPathToTarget(node);
                entryCreature.setSteps(steps);
            }
            entryCreature.makeMove(simulationMap);
        }
        return simulationMap;
    }

    private void updateHashMap(SimulationMap simulationMap) {
        herbivoreMap = simulationMap.creatureMapByType(EntitySymbol.Herbivore);
        predatorMap = simulationMap.creatureMapByType(EntitySymbol.Predator);
        grassMap = simulationMap.entityMapByType(EntitySymbol.Grass);
    }


}
