package com.muted987.simulation;

import com.muted987.simulation.action.initAction.InitArrangement;
import com.muted987.simulation.action.Action;
import com.muted987.simulation.action.turnAction.TurnMove;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.ConsoleRender;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {

    private static SimulationMap simulationMap = new SimulationMap();
    private static ConsoleRender render = new ConsoleRender();
    private static final List<Action> initActions = new ArrayList<>();
    private static final List<Action> turnActions = new ArrayList<>();

    private static void setInitActions() {
        initActions.add(new InitArrangement());
    }
    private static void setTurnActions() {
        turnActions.add(new TurnMove(simulationMap));
    }

    public static void main(String[] args) {
        setInitActions();;
        Scanner scanner = new Scanner(System.in);
        render.render(simulationMap);
        for (Action action : initActions) {
            simulationMap = action.execute(simulationMap);
            System.out.println("\n");
            render.render(simulationMap);
        }
        boolean flag = true;
        setTurnActions();
        while (flag) {
            if (simulationMap.entityMapByType(EntitySymbol.Grass).size() == 0) {
                System.out.println("Травы 0");
                flag = false;
            }
            for (Action action : turnActions) {
                simulationMap = action.execute(simulationMap);
                System.out.println("\n");
                render.render(simulationMap);
            }
//            String input = scanner.nextLine();
//            if (!input.equals("1")) {
//                flag = false;
//            }
        }
    }

}
