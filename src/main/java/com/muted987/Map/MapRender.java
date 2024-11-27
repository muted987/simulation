package main.java.com.muted987.Map;

public class MapRender {
    public void renderer(Map map, int height, int width) {
        for (int widthIndex = 0; widthIndex < width; widthIndex++) {
            StringBuilder line = new StringBuilder();
            for (int heightIndex = 0; heightIndex < height; heightIndex++) {
                Coordinates coordinates = new Coordinates(heightIndex, widthIndex);
                if (map.isFieldEmpty(coordinates)) {
                    line.append(" ✖ ");
                } else {
                    line.append(" ").append(map.getEntity(coordinates).unicodeSymbol).append(" ");
                }
            }
            System.out.println(line);
        }
    }
}
