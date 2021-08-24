package simulation;

import java.util.ArrayList;
/**
 @author Josh
 */
public class Order {
    public enum Type {UNASSIGNED, ASSIGNED, DISPATCHED}
    private final String orderID;
    private String[] orderItems;
    private Type status;

    public Order(String orderID, String[] orderItems){
        this.orderID=orderID;
        status = Type.UNASSIGNED;
        this.orderItems=orderItems;
    }

    public simulation.Order.Type getStatus() {
        return status;
    }

    public String[] getOrderItems() {
        return orderItems;
    }

    public String getOrderID() {
        return orderID;
    }

    @Override
    public String toString(){
        String contents = getOrderItems()[0];
        for (int i =1; i<getOrderItems().length;i++){
            contents+=", " + getOrderItems()[i];
        }
        return getOrderID() + " is " + getStatus() + " and contains: " + contents;
    }
}
