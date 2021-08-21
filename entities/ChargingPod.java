package entities;

public class ChargingPod extends Entity{
  private final int chargeSpeed;
  //private Location Location;

  public ChargingPod(String entityID, int chargeSpeed) {
    this.entityID = entityID;
    this.chargeSpeed=chargeSpeed;
  }

  public int getChargeSpeed() {
    return chargeSpeed;
  }
}
