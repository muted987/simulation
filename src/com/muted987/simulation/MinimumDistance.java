package com.muted987.simulation;

import com.muted987.simulation.entity.Coordinates;

public class MinimumDistance {
    public int getDistance(Coordinates firstCoordinates, Coordinates secondCoordinates) {
        int firstX = firstCoordinates.getX();
        int firstY = firstCoordinates.getY();
        int secondX = secondCoordinates.getX();
        int secondY = secondCoordinates.getY();
        return (int) Math.sqrt(Math.pow(Math.abs(firstX - secondX), 2) + Math.pow(Math.abs(firstY - secondY), 2));
    }

}
