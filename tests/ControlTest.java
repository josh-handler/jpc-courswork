package tests;

import framework.FileToArrayList;
import org.junit.jupiter.api.Test;
import simulation.Control;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControlTest {

    @Test
    void generateSimulation() {
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
    void readGrid() {
    }

    @Test
    void runSimulation() {
    }
}