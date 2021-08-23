package simulation;

import entities.Entity;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Grid {

    private char[][] displayGrid;
    private int mapWidth;
    private int mapHeight;

    public HashMap<Entity, int[]> getMap() {
        return map;
    }

    private HashMap<Entity, int[]> map;

    public Grid(){}
    public Grid(int width, int height){
        mapWidth=width;
        mapHeight=height;
        map = new HashMap();
    }

    public void addEntityToMap(Entity entity, int xPos, int yPos){
        int[] coordinates = new int[2];
        coordinates[0] = xPos;
        coordinates[1] = yPos;
        map.put(entity, coordinates);
    }

    public boolean moveRobot(){return false;};

    public void generateDisplayGrid() {
        displayGrid = new char[mapWidth][mapHeight];
        char[] fillLine = new char[mapHeight];
        Arrays.fill(fillLine, '.');
        Arrays.fill(displayGrid, fillLine);
        int x;
        int y;
        for (Entity entity :
                map.keySet()) {
            switch (entity.getEntityType()) {
                case PACKINGSTATION:
                    x = map.get(entity)[0];
                    y = map.get(entity)[1];
                    if (displayGrid[x][y] == 'r')
                        displayGrid[x][y] = 'P';
                    else
                        displayGrid[x][y] = 'p';
                    break;
                case STORAGESHELF:
                    x = map.get(entity)[0];
                    y = map.get(entity)[1];
                    if (displayGrid[x][y] == 'r')
                        displayGrid[x][y] = 'S';
                    else
                        displayGrid[x][y] = 's';
                    break;
                case CHARGINGPOD:
                    x = map.get(entity)[0];
                    y = map.get(entity)[1];
                    if (displayGrid[x][y] == 'r')
                        displayGrid[x][y] = 'C';
                    else
                        displayGrid[x][y] = 'c';
                    break;
                case ROBOT:
                    x = map.get(entity)[0];
                    y = map.get(entity)[1];
                    char changeTo = 'r';
                    switch (displayGrid[x][y]) {
                        case 'p':
                            changeTo = 'P';
                            break;
                        case 's':
                            changeTo = 'S';
                            break;
                        case 'c':
                            changeTo = 'C';
                            break;
                    }
                    displayGrid[x][y] = changeTo;
                        break;
                    }
            }
        }

    public void updateDisplayGrid(){}
    public char[][] getDisplayGrid() {
        return displayGrid;
    }
}
