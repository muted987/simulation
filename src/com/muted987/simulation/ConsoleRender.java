package com.muted987.simulation;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.Map;

public class ConsoleRender {
    SimulationMap simulationMap = new SimulationMap();
    int maxX = simulationMap.getMAX_X();
    int maxY = simulationMap.getMAX_Y();

    public void render() {
        for (int x = 0; x < maxX; x++) {
            StringBuilder line = new StringBuilder();
            for (int y = 0; y < maxY; y++) {
                Coordinates coordinates = new Coordinates(x, y);
                line.append(getSymbolForCell(coordinates)).append("|");
            }
            System.out.println("|" + line);
            System.out.println("—————————————————————————————");
        }
    }

    private String getSymbolForCell(Coordinates coordinates) {
        return " " + fromEntityToString(coordinates) + " ";
    }

    private String fromEntityToString(Coordinates coordinates) {
        Entity entity = simulationMap.getEntity(coordinates);
        if (entity != null) {
            return entity.getEntitySymbol().getUnicodeSymbol();
        } else return "   ";
    }

}
