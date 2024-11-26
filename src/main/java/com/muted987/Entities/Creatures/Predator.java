package main.java.com.muted987.Entities.Creatures;

import main.java.com.muted987.Coordinates;

public class Predator extends Creature {

    public final int damage = 1;//урон наносимый хищником

    public Predator(Coordinates coordinates, String unicodeSymbol) {
        super(coordinates, unicodeSymbol);
    }
}
