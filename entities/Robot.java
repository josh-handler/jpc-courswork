package entities;

public class Robot extends Entity{

    //private String entityID;
    private String heldItemID;
    private final int maxCharge;
    private int currentCharge;
    private final String podID;


    public Robot(String entityID, String heldItemID, int maxCharge, String podID){
        this.heldItemID = heldItemID;
        this.entityID = entityID;
        this.maxCharge = maxCharge;
        currentCharge = maxCharge;
        this.podID=podID;
    }


}
