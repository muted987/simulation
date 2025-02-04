package com.muted987.simulation.simulationMap.arrangement;

import com.muted987.simulation.EntityFactory;
import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.Map;
import java.util.Random;

public class RandomArrangement {
    private final Map<EntitySymbol, Integer> amountOfEntities = (new AmountOfEntities()).getAmountOfEntities();

    public SimulationMap arrange() {
        SimulationMap simulationMap = new SimulationMap();
        for (Map.Entry<EntitySymbol, Integer> entry : amountOfEntities.entrySet()) {
            for (int i = 0; i < entry.getValue();i++) {
                while (true) {
                    Coordinates coordinates = getRandomCoordinates(simulationMap);
                    if (simulationMap.isCellEmpty(coordinates)) {
                        simulationMap.setEntity(EntityFactory.createEntity(entry.getKey()), coordinates);
                        break;
                    }
                }
            }
        }
        return simulationMap;
    }

    private Coordinates getRandomCoordinates(SimulationMap simulationMap) {
        int randomX = getRandomNumber(simulationMap.getMAX_X() - 1);
        int randomY = getRandomNumber(simulationMap.getMAX_Y() - 1);
        return new Coordinates(randomX, randomY);
    }

    private int getRandomNumber(int rangeOfRandom) {
        Random random = new Random();
        return random.nextInt(rangeOfRandom) + 1;
    }

}

