package main.java.com.muted987.Entities.Creatures;

import main.java.com.muted987.Coordinates;
import main.java.com.muted987.Entities.Entity;

public class Creature extends Entity {

    public final int moveSpeed = 1;//скорость передвижения существа

    public Creature(Coordinates coordinates, String unicodeSymbol) {
        super(coordinates, unicodeSymbol);
    }
}

