package main.java.com.muted987.Entities;

import main.java.com.muted987.Map.Coordinates;

public class Grass extends Entity {

    public final int saturation = 1; //сколько ед. здоровья восстанавливает трава (т.е. насыщение)

    public Grass(Coordinates coordinates, String unicodeSymbol) {
        super(coordinates, unicodeSymbol);
    }
}
