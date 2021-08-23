package entities;
/**
 @author Josh
 */
public class StorageShelf extends Entity {
    private String[] itemUID;
    //Location

    public StorageShelf(String entityID){this.entityID=entityID; eType = EntityType.STORAGESHELF;}


    public StorageShelf(String entityID, String[] itemUID){
        this.entityID=entityID;
        this.itemUID=itemUID;
        eType = EntityType.STORAGESHELF;
    }

    public String[] getItemUID() {
        return itemUID;
    }
}
