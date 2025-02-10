package com.muted987.simulation.action.aStarAlgorithm;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.EntitySymbol;

import java.util.Objects;

public class Node {

    private Coordinates coordinates;
    int g; // Стоимость пути
    int h; // Эвретическая оценка
    int f; //Общая оценка f = g + h
    Node parent;
    private EntitySymbol entityType;

    public Node(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public int getX() {
        return coordinates.getX();
    }

    public int getY() {
        return coordinates.getY();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public EntitySymbol getEntityType() {
        return entityType;
    }

    public Node(Coordinates coordinates, EntitySymbol entityType) {
        this.coordinates = coordinates;
        this.entityType = entityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(coordinates, node.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
