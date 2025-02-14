package com.muted987.simulation.action.aStarAlgorithm;

import com.muted987.simulation.entity.Coordinates;
import com.muted987.simulation.entity.EntitySymbol;
import com.muted987.simulation.entity.creature.Creature;
import com.muted987.simulation.simulationMap.SimulationMap;

import java.util.*;

public class AStar {

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static List<Node> findPath(SimulationMap simulationMap, Map.Entry<Coordinates, Creature> entrySet) {
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(node -> node.f));
        Set<Node> closedList = new HashSet<>();
        Creature startCreature = entrySet.getValue();
        Coordinates startCoordinates = entrySet.getKey();
        EntitySymbol entityType = startCreature.getEntitySymbol();
        Node startNode = NodeFactory.createNode(startCoordinates);
        Node endNode = NodeFactory.createNode(startCreature.getTargetCoordinates());
        startNode.g = 0;
        startNode.h = heuristic(startNode, endNode);
        startNode.f = startNode.g = startNode.h;
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node current = openList.poll();

            if (current.equals(endNode)) {
                return reconstructPath(current);
            }
            closedList.add(current);

            for (int[] dir : DIRS) {
                int newX = current.getX() + dir[0];
                int newY = current.getY() + dir[1];
                Coordinates coordinates = new Coordinates(newX, newY);
                if (entityType == EntitySymbol.Herbivore) {
                    if (isCellAvailableToMoveForHerbivore(coordinates, simulationMap)) {
                        continue;
                    }
                } else {
                    if (isCellAvailableToMoveForPredator(coordinates, simulationMap)) {
                        continue;
                    }
                }
                Node neighbour = new Node(coordinates);
                if (closedList.contains(neighbour)) {
                    continue; //Пропуск клеток которые были изучены
                }
                int tempG = current.g + 1; // Стоимость перемещения на 1 клетку

                if (!openList.contains(neighbour) || tempG < neighbour.g) {
                    neighbour.g = tempG;
                    neighbour.h = heuristic(neighbour, endNode);
                    neighbour.f = neighbour.g + neighbour.h;
                    neighbour.parent = current;
                }
                if (!openList.contains(neighbour)) {
                    openList.add(neighbour);
                }
            }
        }
        return Collections.emptyList();
    }

    private static boolean isCellAvailableToMoveForHerbivore(Coordinates coordinates, SimulationMap simulationMap) {
        return coordinates.getX() < 0 || coordinates.getX() >= simulationMap.getMAX_X() || coordinates.getY() < 0 || coordinates.getY() >= simulationMap.getMAX_Y() || simulationMap.isType(coordinates, EntitySymbol.Rock) || simulationMap.isType(coordinates, EntitySymbol.Tree) || simulationMap.isType(coordinates, EntitySymbol.Herbivore) || simulationMap.isType(coordinates, EntitySymbol.Predator);
    }

    private static boolean isCellAvailableToMoveForPredator(Coordinates coordinates, SimulationMap simulationMap) {
        return coordinates.getX() < 0 || coordinates.getX() >= simulationMap.getMAX_X() || coordinates.getY() < 0 || coordinates.getY() >= simulationMap.getMAX_Y() || simulationMap.isType(coordinates, EntitySymbol.Rock) || simulationMap.isType(coordinates, EntitySymbol.Grass) || simulationMap.isType(coordinates, EntitySymbol.Tree) || simulationMap.isType(coordinates, EntitySymbol.Predator);
    }

    private static int heuristic(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }


    private static List<Node> reconstructPath(Node node) {
        List<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }
}