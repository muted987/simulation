package com.muted987.simulation.simulationMap;

import com.muted987.simulation.entity.EntityFactory;
import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.EntitySymbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomArrangement {

    public static SimulationMap initArrange(SimulationMap simulationMap) {
        Map<EntitySymbol, Integer> amountOfEntities = simulationMap.getMapAmountOfEntities();
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


    private static Coordinates getRandomCoordinates(SimulationMap simulationMap) {
        int randomX = getRandomNumber(simulationMap.getMAX_X() - 1);
        int randomY = getRandomNumber(simulationMap.getMAX_Y() - 1);
        return new Coordinates(randomX, randomY);
    }

    private static int getRandomNumber(int rangeOfRandom) {
        Random random = new Random();
        return random.nextInt(rangeOfRandom) + 1;
    }

}

