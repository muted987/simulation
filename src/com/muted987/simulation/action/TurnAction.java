package com.muted987.simulation.action;

import com.muted987.simulation.action.aStarAlgorithm.AStar;
import com.muted987.simulation.action.aStarAlgorithm.Node;
import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.entity.Grass;
import com.muted987.simulation.entity.creature.Creature;
import com.muted987.simulation.entity.creature.Herbivore;
import com.muted987.simulation.entity.creature.Predator;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.*;

public class TurnAction extends Action {

    private static Map<Coordinates, Creature> herbivoreMap = new HashMap<>();
    private static Map<Coordinates, Creature> predatorMap = new HashMap<>();
    private static Map<Coordinates, Entity> grassMap = new HashMap<>();

    public TurnAction(SimulationMap simulationMap) {
        for (Map.Entry<Coordinates, Entity> entry : simulationMap.getSimulationMap().entrySet()) {
            if (entry.getValue() instanceof Grass) {
                grassMap.put(entry.getKey(), entry.getValue());
            } else if (entry.getValue() instanceof Herbivore) {
                herbivoreMap.put(entry.getKey(), (Creature) entry.getValue());
            } else if (entry.getValue() instanceof Predator) {
                predatorMap.put(entry.getKey(), (Creature) entry.getValue());
            }
        }
    }

    @Override
    public SimulationMap execute(SimulationMap simulationMap) {
        for (Map.Entry<Coordinates, Creature> entry : herbivoreMap.entrySet()) {
            Creature entryCreature = entry.getValue();
            Random random = new Random();
            if (entryCreature.getTargetEntity() == null) {
                int steps = 1;
                int randomGrassIndex = random.nextInt(grassMap.size());
                List<Coordinates> grassCoordinates = new ArrayList<>(grassMap.keySet());
                Entity randomGrass = grassMap.get(grassCoordinates.get(randomGrassIndex));
                entryCreature.setTargetCoordinates(grassCoordinates.get(randomGrassIndex));
                entryCreature.setTargetEntity(randomGrass);
                List<Node> node = AStar.findPath(simulationMap, entryCreature, entryCreature.getTargetEntity());
                entryCreature.setPathToTarget(node);
            }
            entryCreature.makeMove(simulationMap);
        }
        for (Map.Entry<Coordinates>)
        return  simulationMap;
    }


}
