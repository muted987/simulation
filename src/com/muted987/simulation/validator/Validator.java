package com.muted987.simulation.validator;

import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Validator {

    public static boolean validateIntForMainMenu(int option) {
        return !(option < 0 || option > 3);
    }

    public static boolean validateInputForMainMenu(String input) {
        return input.length() == 1 && Character.isDigit(input.charAt(0));
    }

    public static boolean validateIntInputForEntitySymbolAmount(int input, SimulationMap simulationMap) {
        int amountOfCells = simulationMap.getMAX_X() * simulationMap.getMAX_Y();
        int sumOfAmountOfEntities = 0;
        for (Map.Entry<EntitySymbol, Integer> entry : simulationMap.getMapAmountOfEntities().entrySet()) {
            sumOfAmountOfEntities += entry.getValue();
        }
        return (sumOfAmountOfEntities + input) < amountOfCells;
    }

    public static boolean validateForEntitySymbolInput(String input) {
        List<String> entitySymbolList = new ArrayList<>();
        for (EntitySymbol symbol : EntitySymbol.values()) {
            entitySymbolList.add(symbol.toString());
        }
        return entitySymbolList.contains(input);
    }


    public static boolean isInteger(String input) {
        return input.matches("^-?\\d+$");
    }
}
