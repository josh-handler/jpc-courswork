package simulation;

import entities.Robot;

import java.util.ArrayList;
/**
 @author Josh
 */
public class OrderList {
    ArrayList<Order> orderList;
    int count;
    public OrderList() {
        orderList = new ArrayList<Order>();
        count=0;
    }

    public OrderList(String documentPath) {
        // This fills in the requestList from a document in the specified path
    }

    public void appendToRequestList(Order newOrder) {
        // adds an order to the end of the requestList. Primarily intended for use when
        // generating a simulation from a startup document
        orderList.add(newOrder);
    }

    public ArrayList<String> getOrderList() {
        return getOrderList();
    }

    public Robot callRobot() {
        return callRobot();
    }

    public String newOrderID(){
        count++;
        return "order " + count;
    }

}
