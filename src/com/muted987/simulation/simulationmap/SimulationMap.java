package src.com.muted987.simulation.simulationmap;

import com.muted987.simulation.Coordinates;
import com.muted987.simulation.entities.Entity;

import java.util.HashMap;

public class SimulationMap {

    private final int HEIGHT = 10;
    private final int WIDTH = 10;

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }
    HashMap<Coordinates, Entity> simulationMap = new HashMap<>();
    public void setEntityOnMap(Coordinates coordinates, Entity entity){
        simulationMap.put(coordinates, entity);
    }
    public void removeEntityFromMap(Coordinates coordinates) {
        simulationMap.remove(coordinates);
    }
    public Entity getEntity(Coordinates coordinates) {
        return simulationMap.get(coordinates);
    }
    public void simulationMapClear() {
        simulationMap.clear();
    }
    public boolean isFieldFree(Coordinates coordinates) {
        return !simulationMap.containsKey(coordinates);
    }
}
