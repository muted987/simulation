package main.java.com.muted987.Map;

import java.util.Random;

public class ArrangementOfEntities {
    static public Coordinates randomArrangementOfEntities(int height, int width) {
        Random random = new Random();
        int randomHeight = random.nextInt(height);
        int randomWidth = random.nextInt(width);
        return new Coordinates(randomHeight, randomWidth);
    }
}
