package com.muted987.simulation.entity.creature;

import com.muted987.simulation.action.aStarAlgorithm.AStar;
import com.muted987.simulation.action.aStarAlgorithm.Node;
import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.List;

public class Predator extends Creature{

    private int damage;

    public int getDamage() {
        return damage;
    }

    public Predator(EntitySymbol entitySymbol, int moveSpeed, int healthPoint, int damage) {
        super(entitySymbol, moveSpeed, healthPoint);
        this.damage = damage;
    }


    @Override
    protected void action(SimulationMap simulationMap) {
        Creature herbivore = (Creature) getTargetEntity();
        Coordinates herbivoreCoordinates = getTargetCoordinates();
        int herbivoreHealth = herbivore.getHealthPoint();
        int predatorAttack = getDamage();
            if (herbivoreHealth - predatorAttack == 0) {
                simulationMap.removeEntity(herbivoreCoordinates);
                simulationMap.moveEntity(getPathToTarget().get(getSteps() - 1).getCoordinates(), getPathToTarget().get(getSteps()).getCoordinates());
                removeTargetEntity();
            } else {
                herbivore.setHealthPoint(herbivoreHealth - predatorAttack);
            }
        }
}

