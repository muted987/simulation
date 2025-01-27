package com.muted987.simulation.entity.creature;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.EntitySymbol;

public class Predator extends Creature{

    private int damage;

    public Predator(Coordinates coordinates, EntitySymbol entitySymbol, int moveSpeed, int healthPoint, int damage) {
        super(coordinates, entitySymbol, moveSpeed, healthPoint);
        this.damage = damage;
    }

    @Override
    public void makeMove() {

    }

    public void consumeGrass() {

    }
}
