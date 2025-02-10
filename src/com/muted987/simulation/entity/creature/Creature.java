package com.muted987.simulation.entity.creature;

import com.muted987.simulation.action.aStarAlgorithm.Node;
import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.Entity;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.List;

public abstract class Creature extends Entity {
    private final int moveSpeed;
    private int steps;

    public int steps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    private int healthPoint;
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
    private Entity targetEntity = null;
    private Coordinates targetCoordinates = null;

    public Coordinates getTargetCoordinates() {
        return targetCoordinates;
    }

    public Entity getTargetEntity() {
        return targetEntity;
    }

    public void setTargetCoordinates(Coordinates targetCoordinates) {
        this.targetCoordinates = targetCoordinates;
    }

    public void setTargetEntity(Entity target) {
        this.targetEntity = target;
    }

    protected void removeTargetCoordinates() {
        setTargetCoordinates(null);
    }

    protected void removePathToTarget() {
        setPathToTarget(null);
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
        if (getSteps() == pathToTarget.size()) {
            action(simulationMap);
        } else {
            simulationMap.moveEntity(pathToTarget.get(steps - 1).getCoordinates(), pathToTarget.get(steps).getCoordinates());
            setSteps(getSteps() + 1);
        }

    }
    protected abstract void action(SimulationMap simulationMap);
}
