package entities;

public class Robot extends Entity{

    //private String entityID;
    private String heldItemID;
    private final int maxCharge; //capacity
    private int currentCharge;
    private final String podID;
    //STATUS? IDLE, BUSY?


    public Robot(String entityID, String heldItemID, int maxCharge, String podID){
        this.heldItemID = heldItemID;
        this.entityID = entityID;
        this.maxCharge = maxCharge;
        currentCharge = maxCharge;
        this.podID=podID;
    }

//method to check chargeS


//if robot running, - charge methid: CHECK ROBOT STATUS, THEN MINUS CHARGE ACCORDINGLINY


private void charge() {
//MAKE A FLOOR CLASS, MAKE METHOD TO CKECK IF AT ChargingPod


		if (this.currentCharge + chargeSpeed >= maxCharge) {
      //charged//fully charhed
			this.currentCharge = maxCharge;
		}
    else {
      //charging
			this.currentCharge += chargeSpeed;
		}
	}

  //NEED ORDER MANAGER :()



    //getters
    public String getPodID() {
        return podID;
    }

    public int getCurrentCharge() {
        return currentCharge;
    }

    public int getMaxCharge() {
        return maxCharge;
    }

    public String getHeldItemID() {
        return heldItemID;
    }
}
