package tests;

import entities.PackingStation;
import entities.Robot;
import framework.FileToArrayList;
import org.junit.jupiter.api.Test;
import simulation.Control;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControlTest {

    @Test
    void generateSimulation() {
        Control testControl = new Control();
        File testFile = new File("jpc-coursework/resources/sampleData.txt");
        try{
            testControl.generateSimulation(testFile);
        } catch (Exception gridSizeException){
            System.out.println("gridSizeException");
        }
        System.out.println(testControl.getDisplayGrid());
    }

    @Test
    void readOrderList() {
    }

    @Test
    void readEntities() {
        Control testControl = new Control();
        File testFile = new File("jpc-coursework/resources/sampleData.txt");
        ArrayList<String> simulationData = FileToArrayList.readFile(testFile);
        testControl.readEntities(simulationData);

    }
    @Test
    void robotsForOrder(){
        Control testControl = new Control();
        File testFile = new File("jpc-coursework/resources/sampleData.txt");
        try{
            testControl.generateSimulation(testFile);
        } catch (Exception gridSizeException){
            System.out.println("gridSizeException");
        }
        PackingStation testStation = new PackingStation("testStation");
        ArrayList<Robot> results = testControl.robotsForOrder(testStation);
        for (Robot robot:
             results) {
            assertEquals(Robot.Status.IDLE,robot.getState());
        }

    }

    @Test
    void readGrid() {
    }

    @Test
    void runSimulation() {
    }
}