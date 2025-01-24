package com.muted987.simulation.entity.creature;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.entity.EntitySymbol;

public abstract class Creature extends Entity {
    int moveSpeed;
    int healthPoint;

    public Creature(Coordinates coordinates, EntitySymbol entitySymbol, int moveSpeed, int healthPoint) {
        super(coordinates, entitySymbol);
        this.moveSpeed = moveSpeed;
        this.healthPoint = healthPoint;
    }

    public abstract void makeMove();

}
