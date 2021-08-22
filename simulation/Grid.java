package simulation;

import entities.Entity;

import java.io.File;
import java.util.Map;

public class Grid {

    private char[][] displayGrid;
    private int mapWidth;
    private int mapHeight;
    private Map<Entity, int[]> map;

    public Grid(){}
    public Grid(int width, int height){mapWidth=width; mapHeight=height;}

    public void addEntityToMap(){}

    public boolean moveRobot(){return false;};

    public void generateDisplayGrid() {
        displayGrid = new char[mapWidth][mapHeight];
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
