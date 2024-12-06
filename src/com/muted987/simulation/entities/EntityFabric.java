package src.com.muted987.simulation.entities;

public class EntityFabric {

    public Entity entityFabric(EntityName entityName) {
        switch (entityName) {
            case HERBIVORE:
                return new Herbivore(EntityName.HERBIVORE);
            case TREE:
                return new Tree(EntityName.TREE);
            case ROCK:
                return new Rock(EntityName.ROCK);
            case PREDATOR:
                return new Predator(EntityName.PREDATOR);
            case GRASS:
                return new Grass(EntityName.GRASS);
        }
        return null;
    }
}
