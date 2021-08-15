package framework;

import java.io.*;
import java.util.ArrayList;

public  class FileToArrayList {
    public static ArrayList<String[]> readFile(File target){
        System.out.println("Test Running");
        String reading = "";
        ArrayList<String[]> contents = new ArrayList<>();
        try {
            FileReader fReader = new FileReader(target);
            BufferedReader bReader = new BufferedReader(fReader);
            while ((reading = bReader.readLine())!=null){
                contents.add(reading.split(","));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents;
    }
}
