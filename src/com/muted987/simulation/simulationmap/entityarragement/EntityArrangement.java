package src.com.muted987.simulation.simulationmap.entityarragement;

import com.muted987.simulation.simulationmap.AmountOfEntities;
import com.muted987.simulation.simulationmap.SimulationMap;

public abstract class EntityArrangement {
    protected static SimulationMap map = new SimulationMap();

    final int MAXIMUM_WIDTH = map.getWIDTH();
    protected static final int MAXIMUM_HEIGHT = map.getHEIGHT();
    protected static final AmountOfEntities amountOfEntities = new AmountOfEntities();
    public abstract SimulationMap arrange();
}
