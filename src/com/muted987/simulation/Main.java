package src.com.muted987.simulation;

import com.muted987.simulation.simulationmap.SimulationMap;
import com.muted987.simulation.simulationmap.entityarragement.EntityRandomArrangement;

public class Main {
    public static void main(String[] args) {
        SimulationMap mapWithRandom = (new EntityRandomArrangement()).arrange();
    }
}
