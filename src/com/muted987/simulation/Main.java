package com.muted987.simulation;

import com.muted987.simulation.simulationMap.SimulationMap;
import com.muted987.simulation.simulationMap.arrangement.DefaultArrangement;
import com.muted987.simulation.simulationMap.arrangement.RandomArrangement;

public class Main {
    public static void main(String[] args) {
        SimulationMap simulationMap = (new RandomArrangement()).arrange();
        ConsoleRender render = new ConsoleRender();
        render.render(simulationMap);

    }
}
