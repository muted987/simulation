package main.java.com.muted987.Entities.Creatures;

import main.java.com.muted987.Coordinates;

public class Predator extends Creature {

    public final int damage;//урон наносимый хищником

    public Predator(Coordinates coordinates, int health, int moveSpeed, int damage) {
        super(coordinates, health, moveSpeed);
        this.damage = damage;
    }
}
