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
    private static final String HERBIVORE_WIN_MESSAGE = "Травоядным понадобилось %d итерации, чтобы съесть всю траву\n";
    private static final String PREDATOR_WIN_MESSAGE = "Хищникам понадобилось %d итерации, чтобы съесть всех травоядных\n";
    private static final String ITERATION_COUNT_MESSAGE = "Номер итерации %d\n";
    private static SimulationMap simulationMap = new SimulationMap();
    private static final List<Action> initActions = new ArrayList<>();
    private static final List<Action> turnActions = new ArrayList<>();
    private static boolean isPaused = false;
    private static boolean isOver = false;
    private static int turnCount = 0;
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
            ConsoleRender.render(simulationMap);
        }
        setTurnActions();
        do {
            MenuRender.inGameMenuRender();
            input = Input.integer(true);
            MenuRender.renderInGameMenuByOption(input);
            inGameOptionChoose(input);
            iteration(turnCount);
            turnCount++;
        } while (!isOver);
    }

    private static void iteration(int turnCount) {
        if (!isPaused) {
            simulationMap = turnActions.get(0).execute(simulationMap);
            if (endOfSimulationCheck(simulationMap, turnCount)) {
                isOver = true;
                return;
            }
            if (turnCount % 4 == 0) {
                turnActions.get(1).execute(simulationMap);
            }
            System.out.printf(ITERATION_COUNT_MESSAGE, turnCount);
            ConsoleRender.render(simulationMap);
        }
    }

    private static void endSimulation() {
        System.exit(100);
    }

    private static void pauseSimulation() {
        isPaused = true;
        MenuRender.pauseMenuRender();
        while (true) {
            int input = Input.integer(true);
            if (input == MENU_FIRST_OPTION) {
                isPaused = false;
                break;
            } else if (input == MENU_SECOND_OPTION) {
                endSimulation();
            }
        }
    }

    private static void inGameOptionChoose(int option) {
        switch (option) {
            case MENU_SECOND_OPTION:
                pauseSimulation();
                break;
            case MENU_THIRD_OPTION:
                endSimulation();
        }
    }

    private static boolean endOfSimulationCheck(SimulationMap simulationMap, int turnCount) {
        if (simulationMap.entityMapByType(EntitySymbol.Grass).size() == 0) {
            System.out.printf(HERBIVORE_WIN_MESSAGE, turnCount);
            ConsoleRender.render(simulationMap);
            return true;
        } else if (simulationMap.entityMapByType(EntitySymbol.Herbivore).size() == 0) {
            System.out.printf(PREDATOR_WIN_MESSAGE, turnCount);
            ConsoleRender.render(simulationMap);
            return true;
        }
        return false;
    }

}
