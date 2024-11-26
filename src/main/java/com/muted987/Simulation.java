package main.java.com.muted987;

public class Simulation {
    public void simulation(){
        Map map = (new MapFactory()).customMap();
        MapRender render = new MapRender();
        render.renderer(map, map.getHeight(), map.getWidth());
    }
}
