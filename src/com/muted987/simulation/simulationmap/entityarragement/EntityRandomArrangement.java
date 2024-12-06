package src.com.muted987.simulation.simulationmap.entityarragement;

import com.muted987.simulation.Coordinates;
import com.muted987.simulation.entities.Entity;
import com.muted987.simulation.entities.EntityFabric;
import com.muted987.simulation.entities.EntityName;
import com.muted987.simulation.simulationmap.SimulationMap;

import java.util.HashMap;
import java.util.Random;

public class EntityRandomArrangement extends EntityArrangement {

    @Override
    public SimulationMap arrange() {
        simulationMapWithRandomArrangementFactory();
        return map;
    }
    private void setEntityOnRandomCoordinate(Entity entity){
        while(true) {
            Coordinates coordinates = generateRandomCoordinate();
            if (map.isFieldFree(coordinates)) {
                map.setEntityOnMap(coordinates, entity);
            }
            break;
        }
    }
    private Coordinates generateRandomCoordinate() {
        Random random = new Random();
        int randomX = random.nextInt(MAXIMUM_HEIGHT);
        int randomY = random.nextInt(MAXIMUM_WIDTH);
        return new Coordinates(randomX, randomY);
    }

    private void simulationMapWithRandomArrangementFactory() {
        EntityFabric entityFabric = new EntityFabric();
        HashMap<EntityName, Integer> entities = amountOfEntities.getDefaultAmountOfEntities();
        for (EntityName entityName : entities.keySet()) {
            for (int i = 1; i <= entities.get(entityName); i++) {
                setEntityOnRandomCoordinate(entityFabric.entityFabric(entityName));
            }
        }
    }
}
