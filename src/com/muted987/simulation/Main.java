package com.muted987.simulation;

import com.muted987.simulation.simulationMap.SimulationMap;

public class Main {
    public static void main(String[] args) {
        SimulationMap simulationMap = (new EntityArrangement()).defaultArrangement();
        ConsoleRender render = new ConsoleRender();
        render.render(simulationMap);

    }
}
