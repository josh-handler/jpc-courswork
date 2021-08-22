package simulation;

import java.util.ArrayList;

public class Order {
    private enum Type {UNASSIGNED, ASSIGNED, DISPATCHED}
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
}
