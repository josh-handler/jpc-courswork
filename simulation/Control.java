package simulation;

import entities.*;
import framework.FileToArrayList;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Control {
    private ArrayList<Entity> entityList;
    private Grid grid;
    private OrderList orders;

    public Control(){

    }

    public void generateSimulation(File dataFile) throws Exception{
        ArrayList<String> simulationData = new ArrayList<>();
        simulationData = FileToArrayList.readFile(dataFile);
        entityList = readEntities(simulationData);
        grid = readGrid(simulationData);
        orders = new OrderList();


    }

    public void addOrder(String oneOrder){
        String[] itemsArray = oneOrder.split("=");
        Order toAdd = new Order(orders.newOrderID(), itemsArray);
        orders.appendToRequestList(toAdd);
    }

    public void readAndAddOrders(File orderFile){
        ArrayList<String> ordersToMake = FileToArrayList.readFile(orderFile);
        for (String line:ordersToMake) {
            Order toAdd = new Order(orders.newOrderID(),line.split(","));
            orders.appendToRequestList(toAdd);
        }
    }

    public ArrayList<Entity> readEntities(ArrayList<String> simulationData){
        ArrayList<Entity> entitiesFromFile = new ArrayList<>();

        for (String line: simulationData
             ) {
            switch (line.split("=")[0]){
                case "chargingPods":
                    String[] splitPodList = line.split("\\[\\[|],\\[|]]");
                    for (int i = 1; i<splitPodList.length; i++){
                        addPod("cP" + i, splitPodList[i]);
                }
                    break;
                case "storageShelves":
                    String[] splitShelfList = line.split("\\[\\[|],\\[|]]");
                    for (int i = 1; i<splitShelfList.length; i++){
                        addShelf("sS" + i, splitShelfList[i]);
                    }

                    break;
                case "packingStations":
                    String[] splitStationList = line.split("\\[\\[|],\\[|]]");
                    for (int i = 1; i<splitStationList.length; i++){
                        addStation("sS" + i, splitStationList[i]);
                    }
                    break;
            }

        }
        return entitiesFromFile;
    }

    //TODO integrate with grid
    public void addPod(String eID, String podData){
        String[] splitPodData = podData.split(",");
        ChargingPod newPod = new ChargingPod(eID, Integer.parseInt(splitPodData[2]));
        entityList.add(newPod);

    }
    //TODO integrate with grid
    //TODO add itemUID
    public void addShelf(String eID, String shelfData){
        //String[] splitPodData = shelfData.split(",");
        //may add on for itemUID
        StorageShelf newShelf = new StorageShelf(eID);
        entityList.add(newShelf);
    }
    //TODO integrate with grid
    public void addStation(String eID, String stationData){
        PackingStation newStation = new PackingStation(eID);
        entityList.add(newStation);
    }

    //TODO look into custom exception here - would it be better?
    public Grid readGrid(ArrayList<String> simulationData) throws Exception {
        int x=0;
        int y=0;
        for (String line:
             simulationData) {
            if(line.matches("^x=")){
                x=Integer.parseInt(line.split("=")[1]);
                break;
            }
        }
        for (String line:
                simulationData) {
            if(line.matches("^y=")){
                y=Integer.parseInt(line.split("=")[1]);
                break;
            }
        }
        if(x>0 && y>0) {
            Grid gridFromFile = new Grid(x, y);
            return gridFromFile;
        }
        else{
            Exception gridSizeException = new Exception("Grid Size data missing or incorrect");
            throw gridSizeException;
        }
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

