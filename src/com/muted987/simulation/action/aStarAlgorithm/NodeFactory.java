package com.muted987.simulation.action.aStarAlgorithm;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.SimulationMap;

public class NodeFactory {
    public static Node createNode(Coordinates entityCoordinates) {
        return new Node(entityCoordinates);
    }

}
