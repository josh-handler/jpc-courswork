package entities;
/**
 @author Josh
 */
public abstract class Entity implements Comparable<Entity>{
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

    @Override
    public int compareTo(Entity anotherEntity) {
        return this.getEntityID().compareTo(anotherEntity.getEntityID());
    }

}
