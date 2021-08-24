package entities;

import java.util.ArrayList;

import simulation.Control;
import simulation.Grid.*;

import static simulation.Main.control;

/**
 @author Josh
 @author Sanya
 */
public class Robot extends Entity{

    //private String entityID;
    private String heldItem;
    private final int maxCharge; //capacity
    private int currentCharge;
    private final ChargingPod pod;
    public enum Status {IDLE, GETTING, CARRYING, CHARGING, RETURNING, PACKING};
    private  int loadTime;
    Status state;
    private PackingStation currentBoss;
    private StorageShelf pickUpGoal;


    public Robot(String entityID, int maxCharge, ChargingPod pod){

        this.entityID = entityID;
        this.maxCharge = maxCharge;
        currentCharge = maxCharge;
        this.pod = pod;
        eType = EntityType.ROBOT;
        state=Status.IDLE;
    }

//method to check chargeS


//if robot running, - charge method: CHECK ROBOT STATUS, THEN MINUS CHARGE ACCORDINGLINY


private void charge() {
        int chargeSpeed = pod.getChargeSpeed();
		if (currentCharge + chargeSpeed >= maxCharge) {
      //charged//fully charged
			currentCharge = maxCharge;
		}
    else {
      //charging
			currentCharge += chargeSpeed;
		}
	}

public void loseCharge(){
        if(state == Status.CARRYING)
            currentCharge -= 2;
        else
            currentCharge -= 1;
}

  //NEED ORDER MANAGER :()

    public boolean checkIfPossible(PackingStation endpoint, ArrayList<String> midpoint){
        //TODO Get pathfinding and estimation method done, call it here.
        //checks if the robot can pick up any of the items on the list
        return false;
    }

    //getters
    public ChargingPod getPod() {
        return pod;
    }

    public int getCurrentCharge() {
        return currentCharge;
    }

    public int getMaxCharge() {
        return maxCharge;
    }

    public String getHeldItem() {
        return heldItem;
    }
    public Status getState() {return state;}
    public int getLoadTime(){return loadTime;}
    public PackingStation getCurrentBoss(){return currentBoss;}

    public void beginOffloading(){
        currentBoss.setPackGoal(loadTime);
    }

    public void pickUpItem(){state=Status.CARRYING;}

    @Override
    public void act(){
        switch (state){
            case IDLE:
                break;
            case GETTING:
                //Inelegant
                //TODO Use pathfinding to provide direction
                control.moveRobot(this, Control.Direction.NORTH);
                break;
            case CARRYING:
                //TODO Use pathfinding to provide direction
                control.moveRobot(this, Control.Direction.SOUTH);
                break;
            case CHARGING:
                break;
            case RETURNING:
                //TODO Use pathfinding to provide direction
                control.moveRobot(this, Control.Direction.EAST);
                break;
            case PACKING:
                break;
        }
    }
}
