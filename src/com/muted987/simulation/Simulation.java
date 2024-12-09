package com.muted987.simulation;

import com.muted987.simulation.action.Action;
import com.muted987.simulation.simulationmap.SimulationMap;
import com.muted987.simulation.simulationmap.entityarragement.EntityDefaultArrangement;

public class Simulation {
    public void startSimulation() {
        SimulationMap map;
        map = (new EntityDefaultArrangement()).arrange();
        Action action = new Action();
        action.startSimulation(map);
    }
}
