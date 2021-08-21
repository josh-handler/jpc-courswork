package simulation;

import entities.Entity;
import entities.PackingStation;
import entities.Robot;
import entities.StorageShelf;
import framework.FileToArrayList;

import java.io.File;
import java.util.ArrayList;

public class Control {
    private ArrayList<Entity> entityList;
    private Grid grid;
    private OrderList orders;

    public Control(){

    }

    public void generateSimulation(File dataFile){
        ArrayList<String> simulationData = new ArrayList<>();
        simulationData = FileToArrayList.readFile(dataFile);
        entityList = readEntities(simulationData);
        grid = readGrid(simulationData);
        //orders = readOrderList(dataFile);

    }

    public OrderList readOrderList(ArrayList<String> simulationData){
        OrderList ordersFromFile = new OrderList();
        return ordersFromFile;
    }

    public ArrayList<Entity> readEntities(ArrayList<String> simulationData){
        ArrayList<Entity> entitiesFromFile = new ArrayList<>();

        for (String line: simulationData
             ) {
            switch (line.split("=")[0]){
                case "chargingPods":
                    System.out.println("chargingPods");
                    break;
                case "storageShelves":
                    System.out.println("storageShelves");
                    break;
                case "packingStations":
                    System.out.println("packingStations");
                    break;
            }

        }
        return entitiesFromFile;
    }

    public Grid readGrid(ArrayList<String> simulationData) {
        Grid gridFromFile = new Grid();
        return gridFromFile;
    }

    public void runSimulation(){}

    public ArrayList<Robot> robotsForOrder(PackingStation endpoint){
        ArrayList<Robot> available = new ArrayList<>();
        for (Entity entity:
             entityList) {
            if(entity.getEntityType()== Entity.EntityType.ROBOT){
                available.add((Robot) entity);
        }
        }
        for (Robot robot:
             available) {
            if(robot.getState()!= Robot.Status.IDLE){
                available.remove(robot);
            }
        }
        return available;
    }

}

