package com.muted987.simulation.entity.creature;

import com.muted987.simulation.action.aStarAlgorithm.Node;
import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.List;
import java.util.Map;

public abstract class Creature extends Entity {
    private final int moveSpeed;
    private final int steps = 1;

    private int healthPoint;
    private Entity targetEntity = null;
    private Coordinates targetCoordinates = null;
    private List<Node> pathToTarget;

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public List<Node> getPathToTarget() {
        return pathToTarget;
    }

    public void setPathToTarget(List<Node> pathToTarget) {
        this.pathToTarget = pathToTarget;
    }
    public int getHealthPoint() {
        return healthPoint;
    }

    public Coordinates getTargetCoordinates() {
        return targetCoordinates;
    }

    public void setTargetCoordinates(Coordinates targetCoordinates) {
        this.targetCoordinates = targetCoordinates;
    }

    public Entity getTargetEntity() {
        return targetEntity;
    }

    public void setTargetEntity(Entity targetEntity) {
        this.targetEntity = targetEntity;
    }

    public void removeTargetEntity() {
        setTargetEntity(null);
    }

    public Creature(EntitySymbol entitySymbol, int moveSpeed, int healthPoint) {
        super(entitySymbol);
        this.moveSpeed = moveSpeed;
        this.healthPoint = healthPoint;
    }

    public int getSteps() {
        return steps;
    }

    public void makeMove(SimulationMap simulationMap) {


    }
    protected abstract void action(SimulationMap simulationMap);

    
}
