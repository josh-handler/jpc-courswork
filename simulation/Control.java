package simulation;

import entities.*;
import framework.FileToArrayList;
import framework.GridSizeException;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 @author Josh
 */
public class Control {


    private ArrayList<Entity> entityList;
    private Grid grid;
    private OrderList orders;

    public Control(){

    }

    public void generateSimulation(File dataFile) throws GridSizeException{
        ArrayList<String> simulationData;
        simulationData = FileToArrayList.readFile(dataFile);
        grid = readGrid(simulationData);
        entityList = new ArrayList<>();
        readEntities(simulationData);
        orders = new OrderList();
        grid.generateDisplayGrid();


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

    public void readEntities(ArrayList<String> simulationData){
        for (String line: simulationData
             ) {
            String[] subLine = line.split("=");
            switch (subLine[0]){
                case "chargingPodsAndRobots":
                    String[] splitPodList = subLine[1].split("\\(\\(|\\),\\(|\\)\\)");
                    for (int i = 1; i<splitPodList.length; i++){
                        addPod("cP" + i, splitPodList[i]);

                }
                    break;
                case "storageShelves":
                    String[] splitShelfList = line.split("\\(\\(|\\),\\(|\\)\\)");
                    for (int i = 1; i<splitShelfList.length; i++){
                        addShelf("sS" + i, splitShelfList[i]);
                    }

                    break;
                case "packingStations":
                    String[] splitStationList = line.split("\\(\\(|\\),\\(|\\)\\)");
                    for (int i = 1; i<splitStationList.length; i++){
                        addStation("pS" + i, splitStationList[i]);
                    }
                    break;
            }

        }

    }

    public void addPod(String eID, String podData){
        String[] splitPodData = podData.split(",");
        ChargingPod newPod = new ChargingPod(eID, Integer.parseInt(splitPodData[2]));
        entityList.add(newPod);
        grid.addEntityToMap(newPod,Integer.parseInt(splitPodData[0]),Integer.parseInt(splitPodData[1]));
        addRobot(eID.replace("cP","rB"), splitPodData,newPod);
    }

    public void addRobot(String eID, String[] splitPodData, ChargingPod linkedPod){
        Robot newRobot = new Robot(eID, Integer.parseInt(splitPodData[3]), linkedPod);
        entityList.add(newRobot);
        grid.addEntityToMap(newRobot,Integer.parseInt(splitPodData[0]),Integer.parseInt(splitPodData[1]));
    }

    //TODO add itemUID
    public void addShelf(String eID, String shelfData){
        String[] splitShelfData = shelfData.split(",");
        //may add on for itemUID
        StorageShelf newShelf = new StorageShelf(eID);
        entityList.add(newShelf);
        grid.addEntityToMap(newShelf,Integer.parseInt(splitShelfData[0]),Integer.parseInt(splitShelfData[1]));
    }

    public void addStation(String eID, String stationData){
        String[] splitStationData = stationData.split(",");
        PackingStation newStation = new PackingStation(eID);
        entityList.add(newStation);
        grid.addEntityToMap(newStation,Integer.parseInt(splitStationData[0]),Integer.parseInt(splitStationData[1]));
    }

    public Grid readGrid(ArrayList<String> simulationData) throws GridSizeException {
        int x=0;
        int y=0;
        for (String line:
             simulationData) {
            if(line.contains("width")){
                x=Integer.parseInt(line.split("=")[1]);
                break;
            }
        }
        for (String line:
                simulationData) {
            if(line.contains("height")){
                y=Integer.parseInt(line.split("=")[1]);
                break;
            }
        }
        if((x > 0) && (y > 0)) {
            return new Grid(x, y);
        }
        else{
            System.out.println("x="+x+" y=" + y);
            throw new GridSizeException("Grid Size data missing or incorrect");
        }

    }

    public String[] getTheDisplayGrid(){
        ArrayList<String> gridHolder = new ArrayList<>();
        String gridLine="";
        for (int i = 0; i<grid.getDisplayGrid().length;i++){
            for (int j = 0; j < grid.getDisplayGrid()[i].length; j++) {
                gridLine += grid.getDisplayGrid()[i][j] + " ";
                }
                gridHolder.add(gridLine);
                gridLine = "";
            }

        String[] displayGrid  = gridHolder.toArray(new String[0]);

        return displayGrid;

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
    public ArrayList<Entity> getEntityList() {
        return entityList;
    }
    public Grid getGrid() {
        return grid;
    }

}

