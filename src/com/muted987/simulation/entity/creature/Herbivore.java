package com.muted987.simulation.entity.creature;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.SimulationMap;

public class Herbivore extends Creature{
    public Herbivore(EntitySymbol entitySymbol, int moveSpeed, int healthPoint) {
        super(entitySymbol, moveSpeed, healthPoint);
    }
    @Override
    public void action(SimulationMap simulationMap) {
        simulationMap.removeEntity(this.getTargetCoordinates());
    }
}
