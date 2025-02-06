package com.muted987.simulation.action.aStarAlgorithm;

import com.muted987.simulation.entity.EntitySymbol;

import java.util.Objects;

public class Node {

    private final int x;
    private final int y; // Координаты
    int g; // Стоимость пути
    int h; // Эвретическая оценка
    int f; //Общая оценка f = g + h
    Node parent;
    private EntitySymbol entityType;


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public EntitySymbol getEntityType() {
        return entityType;
    }

    public Node(int x, int y, EntitySymbol entityType) {
        this.x = x;
        this.y = y;
        this.entityType = entityType;
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
