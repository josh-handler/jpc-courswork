package tests;

import framework.FileToArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
/**
 @author Josh
 */
class FileToArrayListTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void readFile() {
        File testFile = new File("jpc-coursework/resources/sampleData.txt");
        ArrayList<String> stringAL = FileToArrayList.readFile(testFile);
        assertEquals("SIMULATION DATA FILE", stringAL.get(0));
            }
}