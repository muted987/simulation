package com.muted987.simulation.simulationmap.entityarragement;

import com.muted987.simulation.Coordinates;
import com.muted987.simulation.entities.*;
import com.muted987.simulation.entities.creatures.Herbivore;
import com.muted987.simulation.entities.creatures.Predator;
import com.muted987.simulation.simulationmap.SimulationMap;

public class EntityDefaultArrangement extends EntityArrangement{

    @Override
    public SimulationMap arrange() {
        defaultArrangement();
        return map;
    }

    private void defaultArrangement(){
        //Расположение травы
        map.setEntityOnMap(new Coordinates(7, 7), new Grass(EntityName.GRASS));
        map.setEntityOnMap(new Coordinates(9, 1), new Grass(EntityName.GRASS));
        //Расположение камней
        map.setEntityOnMap(new Coordinates(4, 2), new Rock(EntityName.ROCK));
        map.setEntityOnMap(new Coordinates(3, 5), new Rock(EntityName.ROCK));
        map.setEntityOnMap(new Coordinates(3, 7), new Rock(EntityName.ROCK));
        map.setEntityOnMap(new Coordinates(5, 4), new Rock(EntityName.ROCK));
        //Расположение деревьев
        map.setEntityOnMap(new Coordinates(5, 7), new Tree(EntityName.TREE));
        map.setEntityOnMap(new Coordinates(6, 5), new Tree(EntityName.TREE));
        map.setEntityOnMap(new Coordinates(7, 3), new Tree(EntityName.TREE));
        //Расположение хищника
        map.setEntityOnMap(new Coordinates(1, 9), new Predator(EntityName.PREDATOR));
        //Расположение травоядного
        map.setEntityOnMap(new Coordinates(2, 3), new Herbivore(EntityName.HERBIVORE));
    }

}
