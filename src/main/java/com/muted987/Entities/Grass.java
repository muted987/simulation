package main.java.com.muted987.Entities;

import main.java.com.muted987.Coordinates;

public class Grass extends Entity {

    public final int saturation; //сколько ед. здоровья восстанавливает трава (т.е. насыщение)

    public Grass(Coordinates coordinates, int saturation) {
        super(coordinates);
        this.saturation = saturation;
    }
}
