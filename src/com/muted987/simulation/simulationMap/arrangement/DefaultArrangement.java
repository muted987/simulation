package com.muted987.simulation.simulationMap.arrangement;

import com.muted987.simulation.EntityFactory;
import com.muted987.simulation.entity.*;
import com.muted987.simulation.simulationMap.SimulationMap;

public class DefaultArrangement extends Arrangement {
    public SimulationMap arrange() {
        Coordinates herbivoreCoordinates = new Coordinates(1, 3);
        Coordinates predatorCoordinates = new Coordinates(10, 8);
        Coordinates firstGrassCoordinates = new Coordinates(7, 6);
        Coordinates secondGrassCoordinates = new Coordinates(6, 8);
        Coordinates firstRockCoordinates = new Coordinates(3, 9);
        Coordinates secondRockCoordinates = new Coordinates(5, 7);
        Coordinates firstTreeCoordinates = new Coordinates(9, 6);
        Coordinates secondTreeCoordinates = new Coordinates(4, 3);
        SimulationMap simulationMap = new SimulationMap();
        simulationMap.setEntity(EntityFactory.createEntity(EntitySymbol.Herbivore, herbivoreCoordinates), herbivoreCoordinates);
        simulationMap.setEntity(EntityFactory.createEntity(EntitySymbol.Predator, predatorCoordinates), predatorCoordinates);
        simulationMap.setEntity(EntityFactory.createEntity(EntitySymbol.Grass, firstGrassCoordinates), firstGrassCoordinates);
        simulationMap.setEntity(EntityFactory.createEntity(EntitySymbol.Grass, secondGrassCoordinates), secondGrassCoordinates);
        simulationMap.setEntity(EntityFactory.createEntity(EntitySymbol.Rock, firstRockCoordinates), firstRockCoordinates);
        simulationMap.setEntity(EntityFactory.createEntity(EntitySymbol.Rock, secondRockCoordinates), secondRockCoordinates);
        simulationMap.setEntity(EntityFactory.createEntity(EntitySymbol.Tree, firstTreeCoordinates), firstTreeCoordinates);
        simulationMap.setEntity(EntityFactory.createEntity(EntitySymbol.Tree, secondTreeCoordinates), secondTreeCoordinates);
        return simulationMap;
    }
}
