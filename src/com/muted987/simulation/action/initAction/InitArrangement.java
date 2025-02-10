package com.muted987.simulation.action.initAction;

import com.muted987.simulation.action.Action;
import com.muted987.simulation.simulationMap.RandomArrangement;
import com.muted987.simulation.simulationMap.SimulationMap;

public class InitArrangement extends Action {


    @Override
    public SimulationMap execute(SimulationMap simulationMap) {
        return RandomArrangement.arrange();
    }
}
