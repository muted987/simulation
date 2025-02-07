package com.muted987.simulation.simulationMap;

import com.muted987.simulation.entity.EntitySymbol;

import java.util.HashMap;
import java.util.Map;

public class AmountOfEntities {
    private final Map<EntitySymbol, Integer> amountOfEntities = new HashMap<>();

    {
        amountOfEntities.put(EntitySymbol.Grass, 3);
        amountOfEntities.put(EntitySymbol.Rock, 6);
        amountOfEntities.put(EntitySymbol.Tree, 8);
        amountOfEntities.put(EntitySymbol.Herbivore, 5);
        amountOfEntities.put(EntitySymbol.Predator, 1);
    }

    public Map<EntitySymbol, Integer> getAmountOfEntities() {
        return amountOfEntities;
    }
}
