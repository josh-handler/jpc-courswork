package entities;

public abstract class Entity {
    protected String entityID;

    public Entity(){

    }

    public Entity(String entityID){
        this.entityID=entityID;
    }

    public String getEntityID() {
        return entityID;
    }
}
