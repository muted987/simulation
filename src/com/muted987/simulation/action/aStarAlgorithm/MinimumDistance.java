package com.muted987.simulation.action.aStarAlgorithm;

import com.muted987.simulation.entity.Coordinates;

public class MinimumDistance {
    public int getDistance(Coordinates firstCoordinates, Coordinates secondCoordinates) {
        int firstX = firstCoordinates.getX();
        int firstY = firstCoordinates.getY();
        int secondX = secondCoordinates.getX();
        int secondY = secondCoordinates.getY();
        int result;
        if (firstX == secondX) {
            result = Math.abs(firstY - secondY);
        } else if (firstY == secondY) {
            result = Math.abs(firstX - secondX);
        } else result = Math.abs(firstX - secondX) + Math.abs(firstY - secondY);

        return result;
    }
}
