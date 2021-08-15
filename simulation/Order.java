package simulation;

import java.util.ArrayList;

public class Order {
    private enum Type {UNASSIGNED, ASSIGNED, DISPATCHED}
    private final String orderID;
    private ArrayList<String> orderItems;
    private Type status;

    public Order(String orderID){
        this.orderID=orderID;
        status = Type.UNASSIGNED;
    }

    public simulation.Order.Type getStatus() {
        return status;
    }

    public ArrayList<String> getOrderItems() {
        return orderItems;
    }

    public String getOrderID() {
        return orderID;
    }
}
