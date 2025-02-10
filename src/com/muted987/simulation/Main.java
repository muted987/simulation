package com.muted987.simulation;

import com.muted987.simulation.action.aStarAlgorithm.AStar;
import com.muted987.simulation.action.aStarAlgorithm.Node;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.ConsoleRender;
import com.muted987.simulation.simulationMap.SimulationMap;
import com.muted987.simulation.simulationMap.RandomArrangement;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimulationMap simulationMap = RandomArrangement.arrange();
        ConsoleRender render = new ConsoleRender();
        render.render(simulationMap);
        List<Entity> entityList = EntityCollectionAggregator.aggregate(simulationMap, EntitySymbol.Predator);
        List<Node> nodeList = AStar.findPath(simulationMap, entityList.get(0), entityList.get(1));
        for (Node node : nodeList) {
            System.out.println(node);
        }
        System.out.println(nodeList);
        int a = 123;

    }
}
