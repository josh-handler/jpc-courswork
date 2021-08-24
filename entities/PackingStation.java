package entities;

import simulation.Order;

import java.util.ArrayList;
import java.util.Arrays;

import static simulation.Main.control;
/**
 @author Josh
 */
public class PackingStation extends Entity {


    //Location??
    private enum OrderStatus {IDLE, REQUESTING ,WAITING}
    private OrderStatus status;
    private Order order;
    private ArrayList<String> required;
    private boolean canPack=false;
    private int packCount = 0;
    private  int packGoal;
    int[] location;

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

    public PackingStation(String entityID, int[] location){
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
        required = new ArrayList<>();
        required.addAll(Arrays.asList(order.getOrderItems()));
    }

    public void requestRobots(){
        ArrayList<Robot> availableBots = control.robotsForOrder(this);
        boolean jobTaken = false;
        while (availableBots.iterator().hasNext() && jobTaken==false)
            availableBots.iterator().next().checkIfPossible(this, required);


    }

    public void pack(){

        packCount+=1;
        if(packGoal<=packCount)
            canPack=false;


    }

    ;

    public void setPackGoal(int goal){packGoal=goal;}
}