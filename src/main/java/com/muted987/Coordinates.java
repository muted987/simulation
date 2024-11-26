package main.java.com.muted987;

import java.util.Objects;

public class Coordinates {
    public final int height;
    public final int width;

    public Coordinates(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return height == that.height && width == that.width;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }
//    @Override
//    public String toString(){
//        return "h " + height + " w " + width;
//    }
}
