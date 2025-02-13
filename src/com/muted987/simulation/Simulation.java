package com.muted987.simulation;

import com.muted987.simulation.action.initAction.InitArrangement;
import com.muted987.simulation.action.Action;
import com.muted987.simulation.action.turnAction.TurnMove;
import com.muted987.simulation.action.turnAction.TurnSpawnGrass;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.ConsoleRender;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private static final int MENU_FIRST_OPTION = 1;
    private static final int MENU_SECOND_OPTION = 2;
    private static final int MENU_THIRD_OPTION = 3;
    private static final String HERBIVORE_WIN_MESSAGE = "Травоядным понадобилось %d итераций, чтобы съесть всю траву\n";
    private static final String PREDATOR_WIN_MESSAGE = "Хищникам понадобилось %d итераций, чтобы съесть всех травоядных\n";
    private static final String ITERATION_COUNT_MESSAGE = "Номер итерации %d\n";
    private static SimulationMap simulationMap = new SimulationMap();
    private static ConsoleRender render = new ConsoleRender();
    private static final List<Action> initActions = new ArrayList<>();
    private static final List<Action> turnActions = new ArrayList<>();

    private static void setInitActions() {
        initActions.add(new InitArrangement());
    }
    private static void setTurnActions() {
        turnActions.add(new TurnMove(simulationMap));
        turnActions.add(new TurnSpawnGrass());
    }

    public void simulation() {
        startSimulation();
    }

    private static void startSimulation() {
        setInitActions();
        MenuRender.menuRender();
        int input = Input.integer(true);
        MenuRender.renderMenuByOption(input);
        if (input == MENU_SECOND_OPTION) System.exit(100);
        for (Action action : initActions) {
            simulationMap = action.execute(simulationMap);
            render.render(simulationMap);
            System.out.println("\n");
        }
        input = Input.integer(true);
        if (input == MENU_SECOND_OPTION) System.exit(100);
        else if (input == MENU_FIRST_OPTION) {
            setTurnActions();
            int turnCount = 0;
            while (true) {
                turnCount++;
                for (Action action : turnActions) {
                    simulationMap = action.execute(simulationMap);
                }
                if (turnCount == 5) {
                    turnActions.get(1).execute(simulationMap);
                }
                if (simulationMap.entityMapByType(EntitySymbol.Grass).size() == 0) {
                    System.out.printf(HERBIVORE_WIN_MESSAGE, turnCount);
                    break;
                } else if (simulationMap.entityMapByType(EntitySymbol.Herbivore).size() == 0) {
                    System.out.printf(PREDATOR_WIN_MESSAGE, turnCount);
                    break;
                }
                System.out.printf(ITERATION_COUNT_MESSAGE, turnCount);
                render.render(simulationMap);
                System.out.println("\n");
                MenuRender.inGameMenuRender();
                input = Input.integer(true);
                MenuRender.renderInGameMenuByOption(input);
                switch (input) {
                    case MENU_FIRST_OPTION:
                        continue;
                    case MENU_SECOND_OPTION:
                        pauseSimulation();
                        continue;
                    case MENU_THIRD_OPTION:
                        System.exit(100);
                }
            }
        }

    }

    private static void pauseSimulation() {
        MenuRender.pauseMenuRender();
        while (true) {
            int input = Input.integer(true);
            if (input == MENU_FIRST_OPTION) {
                break;
            } else if (input == MENU_SECOND_OPTION) {
                System.exit(100);
            }
        }
    }

}
