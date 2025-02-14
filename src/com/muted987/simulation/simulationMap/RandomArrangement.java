package com.muted987.simulation.simulationMap;

import com.muted987.simulation.entity.EntityFactory;
import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.EntitySymbol;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomArrangement {
    private static final Map<EntitySymbol, Integer> amountOfEntities = (new AmountOfEntities()).getAmountOfEntities();

    public static SimulationMap initArrange() {
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

    public static SimulationMap turnArrange(SimulationMap simulationMap, int amountOfEntity) {
        Map<EntitySymbol, Integer> grassAmount = new HashMap<>();
        grassAmount.put(EntitySymbol.Grass, amountOfEntities.get(EntitySymbol.Grass));
        int amountOfArrangedEntity = grassAmount.get(EntitySymbol.Grass) - amountOfEntity;
        for (int i = 1; i < amountOfArrangedEntity; i++) {
            while (true) {
                Coordinates coordinates = getRandomCoordinates(simulationMap);
                if (simulationMap.isCellEmpty(coordinates)) {
                    simulationMap.setEntity(EntityFactory.createEntity(EntitySymbol.Grass), coordinates);
                    break;
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

