package main.java.com.muted987.Entities.Creatures;

import main.java.com.muted987.Map.Coordinates;
import main.java.com.muted987.Entities.Entity;
import main.java.com.muted987.Map.Map;

import java.util.HashSet;
import java.util.Set;

public class Creature extends Entity {
    private int moveSpeed; //количество ходов за 1 итерацию симуляции
    public Creature(Coordinates coordinates, String unicodeSymbol, int moveSpeed) {
        super(coordinates, unicodeSymbol);
        this.moveSpeed = moveSpeed;
    }
    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public Set<Coordinates> getMoves() {
        Set<Coordinates> result = new HashSet<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                result.add(new Coordinates(i, j));
            }
        }
        return result;
    }

    public boolean isFieldAvailableForMove(Map map) {
        return !(map.getEntity(coordinates).getClass().getSimpleName().equals("Rock") && map.getEntity(coordinates).getClass().getSimpleName().equals("Tree"));
    }
}

