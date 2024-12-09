package com.muted987.simulation.entities;

import com.muted987.simulation.entities.creatures.Herbivore;
import com.muted987.simulation.entities.creatures.Predator;

public class EntityFactory {

    public Entity getEntityByEntityName(EntityName entityName) {
        switch (entityName) {
            case HERBIVORE : return new Herbivore(EntityName.HERBIVORE);
            case TREE : return new Tree(EntityName.TREE);
            case ROCK : return new Rock(EntityName.ROCK);
            case PREDATOR : return new Predator(EntityName.PREDATOR);
            case GRASS : return new Grass(EntityName.GRASS);
        };
        return null;
    }
}
