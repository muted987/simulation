package com.muted987.simulation.render;

import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.AmountOfEntities;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.Map;

public class AmountOfEntitiesRender {


    public static void render(SimulationMap simulationMap) {
        for (Map.Entry<EntitySymbol, Integer> entry : simulationMap.getMapAmountOfEntities().entrySet()) {
            System.out.println(entry.getKey().toString() + " - " + entry.getValue());
        }
        System.out.println("\n");
    }
}
