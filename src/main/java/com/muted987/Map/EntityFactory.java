package main.java.com.muted987.Map;

import main.java.com.muted987.Entities.Creatures.Herbivore;
import main.java.com.muted987.Entities.Creatures.Predator;
import main.java.com.muted987.Entities.Entity;
import main.java.com.muted987.Entities.Grass;
import main.java.com.muted987.Entities.Rock;
import main.java.com.muted987.Entities.Tree;

import java.util.HashMap;

public class EntityFactory {
    public Entity fromStringToUnicode(String line, Coordinates coordinates, HashMap<String, Integer> moveSpeedSettings){
        switch (line) {
            case "Grass":
                return new Grass(coordinates, "\uD83C\uDF31");
            case "Tree":
                return new Tree(coordinates, "\uD83C\uDF34");
            case "Rock":
                return new Rock(coordinates, "\uD83D\uDDFF");
            case "Predator":
                return new Predator(coordinates, "\uD83D\uDE3D", moveSpeedSettings.get("predator_MoveSpeed"));
            case "Herbivore":
                return new Herbivore(coordinates, "\uD83D\uDC28", moveSpeedSettings.get("herbivore_MoveSpeed"));
        }
        return null;
    }
}
