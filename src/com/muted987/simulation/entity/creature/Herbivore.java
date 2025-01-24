package com.muted987.simulation.entity.creature;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.EntitySymbol;

public class Herbivore extends Creature{

    public Herbivore(Coordinates coordinates, EntitySymbol entitySymbol, int moveSpeed, int healthPoint) {
        super(coordinates, entitySymbol, moveSpeed, healthPoint);
    }

    @Override
    public void makeMove() {

    }

    public void attackHerbivore() {

    }
}
