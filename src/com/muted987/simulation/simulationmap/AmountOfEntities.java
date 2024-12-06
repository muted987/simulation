package src.com.muted987.simulation.simulationmap;

import com.muted987.simulation.entities.EntityName;

import java.util.HashMap;

public class AmountOfEntities {

    private final HashMap<EntityName, Integer> amountOfEntities = new HashMap<>();

    {
        clearAmountOfEntities();
    }

    private void clearAmountOfEntities() {
        amountOfEntities.clear();
    }
    private void addAmountOfEntity(EntityName entityName, int amount) {
        amountOfEntities.put(entityName, amount);
    }

    private void setDefaultAmountOfEntities() {
        addAmountOfEntity(EntityName.GRASS, 2);
        addAmountOfEntity(EntityName.ROCK, 4);
        addAmountOfEntity(EntityName.TREE, 3);
        addAmountOfEntity(EntityName.HERBIVORE, 1);
        addAmountOfEntity(EntityName.PREDATOR, 1);
    }


    public HashMap<EntityName, Integer> getDefaultAmountOfEntities() {
        setDefaultAmountOfEntities();
        return amountOfEntities;
    }

    public HashMap<EntityName, Integer> getAmountOfEntities() {
        return amountOfEntities;
    }
}
