package com.muted987.simulation.entities;

import com.muted987.simulation.entities.creatures.Herbivore;
import com.muted987.simulation.entities.creatures.Predator;

public class EntityFactory {

    public Entity getEntityByEntityName(EntityName entityName) {
        return switch (entityName) {
            case HERBIVORE -> new Herbivore(EntityName.HERBIVORE);
            case TREE -> new Tree(EntityName.TREE);
            case ROCK -> new Rock(EntityName.ROCK);
            case PREDATOR -> new Predator(EntityName.PREDATOR);
            case GRASS -> new Grass(EntityName.GRASS);
        };
    }
}
