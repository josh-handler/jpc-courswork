ifYMoveSouthpackage simulation;

import entities.Entity;
import entities.Robot;

import java.io.File;
import java.util.*;
import java.util.LinkedList;

/**
 @author Josh
 @author Saniya
 */
public class Grid {

    private char[][] displayGrid;
    private int mapWidth;
    private int mapHeight;
    private TreeMap<Entity, int[]> map;
    public TreeMap<int[], Robot> robots;

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
        if (entity.getEntityType()==Entity.EntityType.ROBOT)
            robots.put(coordinates, (Robot) entity);
    }


    public boolean moveRobot(Robot moveRobot, int verticalOrHorizontal, int alongOrBack){
        int[] startPosition = map.get(moveRobot);
        int[] endPosition = startPosition;
        endPosition[verticalOrHorizontal] += alongOrBack;
        if(robots.keySet().contains(endPosition))
            return true;
        else {
            map.replace(moveRobot, endPosition);
            robots.remove(startPosition);
            robots.put(endPosition, moveRobot);
            return false;
        }
    }

    // Robot finds path by comapring the distance between each point. This is done by using Points to track each "Grid"Cell and then
    // comparing each scenario where the Robot moves north, east, south or west.

    public LinkedList<Point> findPath(Point current, Point endPosition) {

      //create list of Points
      LinkedList<Point> path = new LinkedList<Point>();

      Point currentPosition = new Point(current.getX(), current.getY());

      //while Robot not at detsination
      while (currentPosition.getX() != endPosition.getX() || currentPosition.getY() != endPosition.getY()) {

        //check x points (compare difference in distance if we move east or west)
        if (currentPosition.getX() != endPosition.getX()) {
          //if we go east
          int ifXMoveEast = Math.abs(endPosition.getX() - currentPosition.east().getX());

          //if we go west
          int ifXMoveWest = Math.abs(endPosition.getX() - currentPosition.west().getX());

          // go east if less distance
          if (ifXMoveEast <= ifXMoveWest) {
            Point newPoint = new Point(currentPosition.east().getX(), currentPosition.getY());

            currentPosition = newPoint;

            path.add(newPoint);
          }

          // go west if less distance
          else {
            Point newPoint = new Point(currentPosition.west().getX(), currentPosition.getY());

            currentPosition = newPoint;

            path.add(newPoint);
          }
        }

        //check y points (compare difference in distance if we move north or south)
        else if (currentPosition.getY() != endPosition.getY()) {

          //if we move north
          int ifYMoveNorth = Math.abs(endPosition.getY() - currentPosition.north().getY());

          //if we move south
          int ifYMoveSouth = Math.abs(endPosition.getY() - currentPosition.south().getY());

          //go north if less distance
          if (ifYMoveNorth <= ifYMoveSouth) {
            Point newPoint = new Point(currentPosition.getX(), currentPosition.north().getY());

            currentPosition = newPoint;

            path.add(newPoint);
          }

          //go south if less disatance
          else {
            Point newPoint = new Point(currentPosition.getX(), currentPosition.south().getY());

            currentPosition = newPoint;

            path.add(newPoint);
          }
        }
      }
      return path;
    }

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
