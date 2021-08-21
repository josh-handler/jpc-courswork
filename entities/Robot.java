package entities;

import java.util.ArrayList;

public class Robot extends Entity{

    //private String entityID;
    private ArrayList<String> heldItems;
    private final int maxCharge; //capacity
    private int currentCharge;
    private final ChargingPod pod;
    //STATUS? IDLE, BUSY?


    public Robot(String entityID, int maxCharge, ChargingPod pod){
        heldItems=new ArrayList<>();
        this.entityID = entityID;
        this.maxCharge = maxCharge;
        currentCharge = maxCharge;
        this.pod = pod;
    }

//method to check chargeS


//if robot running, - charge methid: CHECK ROBOT STATUS, THEN MINUS CHARGE ACCORDINGLINY


private void charge() {
        int chargeSpeed = pod.getChargeSpeed();
		if (this.currentCharge + chargeSpeed >= maxCharge) {
      //charged//fully charged
			this.currentCharge = maxCharge;
		}
    else {
      //charging
			this.currentCharge += chargeSpeed;
		}
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
}
