package com.muted987.simulation;

import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.SimulationMap;
import com.muted987.simulation.simulationMap.arrangement.RandomArrangement;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimulationMap simulationMap = (new RandomArrangement()).arrange();
        ConsoleRender render = new ConsoleRender();
        render.render(simulationMap);
        EntityCollectionAggregator entityCollection = new EntityCollectionAggregator();
        ClosestEntity closest = new ClosestEntity();
        List<Entity> entities = entityCollection.aggregate(simulationMap, EntitySymbol.Herbivore);
        List<Entity> closestEntities = closest.getClosestEntity(entities, simulationMap);
        System.out.println("\n");
        for (Entity entity : closestEntities) {
            System.out.println("entity = " + entity.getEntitySymbol());
            System.out.println("simulationMapX = " + simulationMap.getEntityCoordinates(entity).getX());
            System.out.println("simulationMapY = " + simulationMap.getEntityCoordinates(entity).getY());
        }
        int a = 123;
    }
}
