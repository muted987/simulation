package main.java.com.muted987;

import main.java.com.muted987.Action.Action;
import main.java.com.muted987.Map.Map;
import main.java.com.muted987.Map.MapRender;

public class Simulation {

    public void simulation(){
        Map map;
        Action action = new Action();
        map = action.startSimulation();
        MapRender render = new MapRender();
        render.renderer(map, map.getHeight(), map.getWidth());

        while (true) {
            action.simulation(map);
        }
    }
}
