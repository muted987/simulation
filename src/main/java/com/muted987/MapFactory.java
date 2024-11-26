package main.java.com.muted987;

import java.util.HashMap;

public class MapFactory {
    private EntityFactory entityFactory = new EntityFactory();
    public Map customMap() {
        Map map = new Map();

        HashMap<String, Integer> amountOfEntities = InputAmountOfEntities.inputAmountOfEntities();
        String[] parametersOfSimulation = InputMapSize.inputSizeOfMap().split("x");
        int width = Integer.parseInt(parametersOfSimulation[0]);
        int height = Integer.parseInt(parametersOfSimulation[1]);
        map.setParameters(width, height);
        for (String entityCaption : amountOfEntities.keySet()) {
            for (int i = 1; i <= amountOfEntities.get(entityCaption); i++) {
                while (true) {
                    Coordinates coordinates = ArrangementOfEntities.randomArrangementOfEntities(height, width);
                    if (map.isFieldEmpty(coordinates)) {
                        map.setEntity(coordinates, entityFactory.fromStringToUnicode(entityCaption, coordinates));
                        break;
                    }
                }

            }
        }

        return map;
    }

    public static void main(String[] args) {
        MapFactory mapFactory = new MapFactory();
       // Map map = mapFactory.customMap();
        int a = 123;
    }

}
