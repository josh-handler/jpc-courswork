package entities;

import simulation.Control;
import simulation.Order;

import static simulation.Main.control;

public class PackingStation extends Entity {


    //Location??
    private enum Status {IDLE, REQUESTING ,WAITING, PACKING}
    private Status status;
    private Order order;
    /**
     * method:
     * AT A CURRENT tick
     * CHECK PackingStation STATUS
     * <p>
     * switch CASE
     * getting: getting order function at that tick
     * Waiting: Waiting for Robot
     * Packing: packing order function that needs certain amt of ticksToPack
     * Dispacthing: dispacting completed order at that tick
     * <p>
     * method: get order from order manager
     * method: take item from robot
     * method: pack order
     * method: dispacth order
     **/

    public PackingStation(String entityID){
        status=Status.IDLE;
        eType = EntityType.PACKINGSTATION;
        this.entityID=entityID;
    }
    public void activate(){
        switch (status){
            case IDLE:
                requestOrder();
                requestRobots();
                break;
            case REQUESTING:
                requestRobots();
            case PACKING:
                pack();
                break;
            }

    }
    public void requestOrder() {

    }

    public void requestRobots(){
        control.robotsForOrder(this);

    }

    public void pack(){


    }

    ;
}