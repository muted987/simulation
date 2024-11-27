package main.java.com.muted987.Map;

import java.util.HashMap;

public class AmountOfEntitiesOnMap {
    private final HashMap<String, Integer> amountOfEntities = new HashMap<String, Integer>(){{
        put("Rock", 3);
        put("Tree", 3);
        put("Grass", 3);
        put("Herbivore", 1);
        put("Predator", 1);
    }};


    public HashMap<String, Integer> getAmountOfEntities() {
        return amountOfEntities;
    }
}
