package com.muted987.simulation.action;

import com.muted987.simulation.Coordinates;
import com.muted987.simulation.entities.Entity;
import com.muted987.simulation.entities.creatures.Creature;
import com.muted987.simulation.simulationmap.SimulationMap;
import com.muted987.simulation.simulationmap.SimulationMapRender;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Action {
    public void startSimulation(SimulationMap map) {
        SimulationMapRender render = new SimulationMapRender();
        Scanner scanner = new Scanner(System.in);
        int option;
        render.render(map);
        while (true) {
            System.out.println("Typo 1 to move");
            option = scanner.nextInt();
            if (option == 1) {
                makeMove(map);
            } else if (option == 2) {break;}
            render.render(map);
        }
    }

    private void makeMove(SimulationMap map) {
        System.out.println("DO SOMETHING");
        HashMap<Coordinates, Entity> creatureArrayList = map.getAllCreatures();
        for (Map.Entry<Coordinates, Entity> entrySimulationMap : map.getSimulationMap().entrySet()) {
            for (Map.Entry<Coordinates, Entity> entryCreatureArrayList : creatureArrayList.entrySet()) {
                
            }
        }
    }

    private boolean isMoveAvailable(SimulationMap map, Coordinates coordinates) {
        return map.isGrass(coordinates);
    }
}
