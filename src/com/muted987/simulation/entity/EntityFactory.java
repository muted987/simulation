package com.muted987.simulation.entity;

import com.muted987.simulation.entity.creature.Herbivore;
import com.muted987.simulation.entity.creature.Predator;

public class EntityFactory {
    public static Entity createEntity(EntitySymbol type) {
        switch (type) {
            case Rock:
                return new Rock(EntitySymbol.Rock);
            case Grass:
                return new Grass(EntitySymbol.Grass);
            case Tree:
                return new Tree(EntitySymbol.Tree);
            case Herbivore:
                return new Herbivore(EntitySymbol.Herbivore, 1, 1);
            case Predator:
                return new Predator(EntitySymbol.Predator, 1, 1, 1);
            default: return null;
        }
    }
}
