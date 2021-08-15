package entities;

public class ChargingPod extends Entity{
    private final int chargeSpeed;

    public int getChargeSpeed() {
        return chargeSpeed;
    }

    public ChargingPod(String entityID, int chargeSpeed) {
        this.entityID = entityID;
        this.chargeSpeed=chargeSpeed;
    }


}
