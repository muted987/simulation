package com.muted987.simulation.entity.creature;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.EntitySymbol;

public class Predator extends Creature{


    public Predator(Coordinates coordinates, EntitySymbol entitySymbol, int moveSpeed, int healthPoint) {
        super(coordinates, entitySymbol, moveSpeed, healthPoint);
    }

    @Override
    public void makeMove() {

    }

    public void consumeGrass() {

    }
}
