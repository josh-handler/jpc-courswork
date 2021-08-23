package simulation;

import entities.Entity;

import java.io.File;
import java.util.*;
/**
 @author Josh
 */
public class Grid {

    private char[][] displayGrid;
    private int mapWidth;
    private int mapHeight;
    private TreeMap<Entity, int[]> map;

    public TreeMap<Entity, int[]> getMap() {
        return map;
    }



    public Grid(){}
    public Grid(int width, int height){
        mapWidth=width;
        mapHeight=height;
        map = new TreeMap ();
    }

    public void addEntityToMap(Entity entity, int xPos, int yPos){
        int[]coordinates = {xPos,yPos};
        map.put(entity, coordinates);
    }

    public boolean moveRobot(){return false;};

    public void generateDisplayGrid() {
        displayGrid = new char[mapWidth][mapHeight];
        for(int i = 0; i<mapWidth; i++){
            for (int j=0; j<mapHeight; j++){
                displayGrid[i][j]= '.';
            }
        }
        ArrayList<Entity> robotsToFill = new ArrayList<>();
        for (Entity entity:map.keySet()
             ) {
            if(entity.getEntityType()== Entity.EntityType.ROBOT){
                robotsToFill.add(entity);
            }
            else{
                char rep = getCharRep(entity.getEntityType());
                updateSingleDisplayPosition(rep, map.get(entity)[0], map.get(entity)[1]);
            }
        }
        for (Entity robot:robotsToFill
             ) {
            char rep = getCharRep(robot.getEntityType());
            updateSingleDisplayPosition(rep, map.get(robot)[0], map.get(robot)[1]);
        }
    }

    public void updateSingleDisplayPosition(char representation,int xPos, int yPos){
        switch (displayGrid[xPos][yPos]){
            case '.':
                displayGrid[xPos][yPos]= representation;
                break;
            case 'c':
                displayGrid[xPos][yPos]= 'C';
                break;
            case 'p':
                displayGrid[xPos][yPos]= 'P';
                break;
            case 's':
                displayGrid[xPos][yPos]= 'S';
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + displayGrid[xPos][yPos]);
        }

    }

    public char getCharRep(Entity.EntityType entityType){
        switch (entityType){
            case CHARGINGPOD:
                return 'c';
            case PACKINGSTATION:
                return 'p';
            case STORAGESHELF:
                return 's';
            case ROBOT:
                return 'r';
            default:
                return '?';
        }
    }

    public void updateDisplayGrid(){}
    public char[][] getDisplayGrid() {
        return displayGrid;
    }
}
