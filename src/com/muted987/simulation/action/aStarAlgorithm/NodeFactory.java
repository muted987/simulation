package com.muted987.simulation.action.aStarAlgorithm;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.simulationMap.SimulationMap;

public class NodeFactory {
    public static Node createNode(Entity entity, SimulationMap simulationMap) {
        Coordinates entitiesCoordinates = simulationMap.getEntityCoordinates(entity);
        return new Node(entitiesCoordinates.getX(), entitiesCoordinates.getY(), entity.getEntitySymbol());
    }

}
