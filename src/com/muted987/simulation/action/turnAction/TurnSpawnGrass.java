package com.muted987.simulation.action.turnAction;

import com.muted987.simulation.action.Action;
import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.RandomArrangement;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.HashMap;

public class TurnSpawnGrass extends Action {
    @Override
    public SimulationMap execute(SimulationMap simulationMap) {

        HashMap<Coordinates, Entity> grassMap = new HashMap<>(simulationMap.entityMapByType(EntitySymbol.Grass));
        int grassMapSize = grassMap.size();
        if (grassMap.size() == 0) {
            RandomArrangement.turnArrange(simulationMap, grassMapSize);
        }

        return simulationMap;
    }
}
