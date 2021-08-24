package entities;
/**
 @author Josh
 */
public class StorageShelf extends Entity {
    private int packingTime;
    //Location

   // public StorageShelf(String entityID){this.entityID=entityID; eType = EntityType.STORAGESHELF;}


    public StorageShelf(String entityID, int packingTime){
        this.entityID=entityID;
        this.packingTime=packingTime;
        eType = EntityType.STORAGESHELF;
    }

    public int getpackingTime() {
        return packingTime;
    }
}
