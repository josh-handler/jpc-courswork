package entities;

import simulation.Order;
import static simulation.Main.control;
/**
 @author Josh
 */
public class PackingStation extends Entity {


    //Location??
    private enum OrderStatus {IDLE, REQUESTING ,WAITING}
    private OrderStatus status;
    private Order order;
    private boolean canPack=false;
    private int packCount=0;
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
        status=OrderStatus.IDLE;
        eType = EntityType.PACKINGSTATION;
        this.entityID=entityID;
    }
    @Override
    public void act(){
        switch (status){
            case IDLE:
                requestOrder();
                requestRobots();
                break;
            case REQUESTING:
                requestRobots();
                break;
            }
        if(canPack){
            pack();
        }
        if (order.getStatus()== Order.Type.DISPATCHED)
            status=OrderStatus.IDLE;
    }
    public void requestOrder() {

    }

    public void requestRobots(){
        control.robotsForOrder(this);

    }

    public void pack(){
        packCount+=1;

    }

    ;
}