package com.muted987.simulation;

import com.muted987.simulation.entity.*;
import com.muted987.simulation.entity.creature.Herbivore;
import com.muted987.simulation.entity.creature.Predator;

public class EntityFactory {
    public static Entity createEntity(EntitySymbol type, Coordinates coordinates) {
        switch (type) {
            case Rock:
                return new Rock(coordinates, EntitySymbol.Rock);
            case Grass:
                return new Grass(coordinates, EntitySymbol.Grass);
            case Tree:
                return new Tree(coordinates, EntitySymbol.Tree);
            case Herbivore:
                return new Herbivore(coordinates, EntitySymbol.Herbivore, 1, 1);
            case Predator:
                return new Predator(coordinates, EntitySymbol.Predator, 1, 1, 1);
            default: return null;
        }
    }
}
