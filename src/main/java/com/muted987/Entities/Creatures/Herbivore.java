package main.java.com.muted987.Entities.Creatures;

import main.java.com.muted987.Map.Coordinates;
import main.java.com.muted987.Map.Map;

public class Herbivore extends Creature {

    public final int health = 1;

    public Herbivore(Coordinates coordinates, String unicodeSymbol, int moveSpeed) {
        super(coordinates, unicodeSymbol, moveSpeed);
    }

    @Override
    public boolean isFieldAvailableForMove(Map map) {
        return super.isFieldAvailableForMove(map) || !map.getEntity(this.coordinates).getClass().getSimpleName().equals("Predator");
    }
}
