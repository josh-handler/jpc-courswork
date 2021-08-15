package simulation;

import entities.Entity;

import java.io.File;
import java.util.ArrayList;

public class Control {
    private ArrayList<Entity> entityList;
    private Grid grid;
    private OrderList orders;

    public Control(){

    }

    public void generateSimulation(File dataFile){
        entityList = readEntities(dataFile);
        grid = readGrid(dataFile);
        orders = readOrderList(dataFile);

    }

    public OrderList readOrderList(File dataFile){
        OrderList ordersFromFile = new OrderList();
        return ordersFromFile;
    }

    public ArrayList<Entity> readEntities(File dataFile){
        ArrayList<Entity> entitiesFromFile = new ArrayList<Entity>();
        return entitiesFromFile;
    }

    public Grid readGrid(File dataFile) {
        Grid gridFromFile = new Grid();
        return gridFromFile;
    }

    public void runSimulation(){}

}
