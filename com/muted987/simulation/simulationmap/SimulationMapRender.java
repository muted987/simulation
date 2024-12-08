package com.muted987.simulation.simulationmap;

import com.muted987.simulation.Coordinates;

public class SimulationMapRender {

    public void render(SimulationMap map) {
        for (int x = 1; x <= map.getHEIGHT(); x++) {
            StringBuilder line = new StringBuilder();
            for (int y = 1; y <= map.getWIDTH(); y++) {
                Coordinates coordinates = new Coordinates(x, y);
                line.append(getStringByFieldContainment(coordinates, map)).append(" | ");
            }
            System.out.println(line);
        }

    }

    private String getStringByFieldContainment(Coordinates coordinates, SimulationMap map) {
        if (map.isFieldFree(coordinates)) {
            return getEmptyFieldRender();
        } return getEntityRender(map, coordinates);
    }

    private String getEntityRender(SimulationMap map, Coordinates coordinates) {
        return " " + map.getEntity(coordinates).getEntityUnicodeSymbol() + " ";
    }

    private String getEmptyFieldRender() {
        return " X ";
    }
}

