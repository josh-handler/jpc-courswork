package entities;

import java.util.ArrayList;
import simulation.Grid.*;
/**
 @author Josh
 @author Sanya
 */
public class Robot extends Entity{

    //private String entityID;
    private ArrayList<String> heldItems;
    private final int maxCharge; //capacity
    private int currentCharge;
    private final ChargingPod pod;
    public enum Status {IDLE, GETTING, CARRYING};
    Status state;


    public Robot(String entityID, int maxCharge, ChargingPod pod){
        heldItems=new ArrayList<>();
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

    public ArrayList<String> getHeldItems() {
        return heldItems;
    }
    public Status getState() {return state;}
    
}
