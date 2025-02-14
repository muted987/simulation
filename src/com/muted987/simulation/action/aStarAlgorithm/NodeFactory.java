package com.muted987.simulation.action.aStarAlgorithm;

import com.muted987.simulation.entity.Coordinates;

public class NodeFactory {
    public static Node createNode(Coordinates entityCoordinates) {
        return new Node(entityCoordinates);
    }

}
