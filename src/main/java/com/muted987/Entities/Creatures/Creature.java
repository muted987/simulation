package main.java.com.muted987.Entities.Creatures;

import main.java.com.muted987.Coordinates;
import main.java.com.muted987.Entities.Entity;

public class Creature extends Entity {

    public final int health;
    public final int moveSpeed;//скорость передвижения существа

    public Creature(Coordinates coordinates, int health, int moveSpeed) {
        super(coordinates);
        this.health = health;
        this.moveSpeed = moveSpeed;
    }
}
