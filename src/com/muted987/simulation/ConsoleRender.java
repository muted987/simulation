package com.muted987.simulation;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.Map;

public class ConsoleRender {

    public void render(SimulationMap simulationMap) {
        int maxX = simulationMap.getMAX_X();
        int maxY = simulationMap.getMAX_Y();
        System.out.println("—————————————————————————————————————————");
        for (int y = maxY; y >= 1; y--) {
            StringBuilder line = new StringBuilder();
            for (int x = 1; x <= maxX; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                line.append(getSymbolForCell(coordinates, simulationMap)).append("|");
            }
            System.out.println("|" + line + " " + y);
            System.out.println("—————————————————————————————————————————");
        }
        System.out.print("  ");
        for (int x = 1; x <= maxX; x++) System.out.print(x + "   ");
    }

    private String getSymbolForCell(Coordinates coordinates, SimulationMap simulationMap) {
        return " " + fromEntityToString(coordinates, simulationMap) + " ";
    }

    private String fromEntityToString(Coordinates coordinates, SimulationMap simulationMap) {
        Entity entity = simulationMap.getEntity(coordinates);
        if (entity != null) {
            return entity.getEntitySymbol().getUnicodeSymbol();
        } else return " ";
    }

}
