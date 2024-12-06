package src.com.muted987.simulation.entities;

public enum EntityName {
    GRASS("Grass"),
    TREE("Tree"),
    ROCK("Rock"),
    HERBIVORE("Herbivore"),
    PREDATOR("Predator");
    private String entityName;

    EntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityUnicodeSymbol() {
        return entityName;
    }
}
