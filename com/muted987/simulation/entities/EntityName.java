package com.muted987.simulation.entities;

public enum EntityName {
    GRASS("G"),
    TREE("T"),
    ROCK("R"),
    HERBIVORE("H"),
    PREDATOR("P");
    private final String entityName;

    EntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityUnicodeSymbol() {
        return entityName;
    }
}
