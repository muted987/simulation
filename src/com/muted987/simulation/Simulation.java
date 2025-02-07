package com.muted987.simulation;

import com.muted987.simulation.action.Action;
import com.muted987.simulation.action.TurnAction;
import com.muted987.simulation.simulationMap.ConsoleRender;
import com.muted987.simulation.simulationMap.RandomArrangement;
import com.muted987.simulation.simulationMap.SimulationMap;

public class Simulation {

    private static SimulationMap simulationMap = RandomArrangement.arrange();
    private static Action turnAction = new TurnAction(simulationMap);
    private int simulationCount = 0;
    private static ConsoleRender render = new ConsoleRender();
    Action action;

    public static void main(String[] args) {
        render.render(simulationMap);
        simulationMap = turnAction.execute(simulationMap);

    }

}
