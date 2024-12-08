package com.muted987.simulation.action;

import com.muted987.simulation.Coordinates;
import com.muted987.simulation.entities.creatures.Creature;
import com.muted987.simulation.simulationmap.SimulationMap;
import com.muted987.simulation.simulationmap.SimulationMapRender;

import java.util.ArrayList;
import java.util.HashMap;
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
                System.out.println("DO SOMETHING");
            } else if (option == 2) {break;}
            render.render(map);
        }
    }

    private void makeMove(SimulationMap map) {
        HashMap<Coordinates, Creature> creatureArrayList = map.getAllCreatures();
        for (Creature creature : creatureArrayList.values()) {

        }
    }
}
