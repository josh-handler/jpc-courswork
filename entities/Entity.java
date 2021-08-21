package entities;

public abstract class Entity {
    String entityID;
    public enum EntityType {ROBOT, CHARGINGPOD, PACKINGSTATION, STORAGESHELF, GENERIC}
    EntityType eType;
    Entity(){

    }

    public Entity(String entityID){
        this.entityID=entityID;
        eType= EntityType.GENERIC;
    }

    public String getEntityID() {
        return entityID;
    }

    public EntityType getEntityType(){return eType;}

}
