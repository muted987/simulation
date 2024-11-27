package main.java.com.muted987.Map;

import java.util.HashMap;

public class MapFactory {
    private final EntityFactory entityFactory = new EntityFactory();
    public Map customMap(HashMap<String, Integer> amountOfEntities, HashMap<String, Integer> moveSpeedSettings) {
        Map map = new Map();
        String[] parametersOfSimulation = InputMapSize.inputSizeOfMap().split("x");
        int width = Integer.parseInt(parametersOfSimulation[0]);
        int height = Integer.parseInt(parametersOfSimulation[1]);
        map.setParameters(height, width);
        for (String entityCaption : amountOfEntities.keySet()) {
            for (int i = 1; i <= amountOfEntities.get(entityCaption); i++) {
                while (true) {
                    Coordinates coordinates = ArrangementOfEntities.randomArrangementOfEntities(height, width);
                    if (map.isFieldEmpty(coordinates)) {
                        map.setEntity(coordinates, entityFactory.fromStringToUnicode(entityCaption, coordinates, moveSpeedSettings));
                        break;
                    }
                }

            }
        }
        return map;
    }
}
