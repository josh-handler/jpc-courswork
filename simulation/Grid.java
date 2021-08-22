package simulation;

import entities.Entity;

import java.io.File;
import java.util.Map;

public class Grid {

    //protected char[][] displayGrid;
    private int mapWidth;
    private int mapHeight;
    private Map<Entity, int[][]> map;

    public Grid(){}
    public Grid(int width, int height){mapWidth=width; mapHeight=height;}

    public void addEntityToMap(){}

    public boolean moveRobot(){return false;};

}
