package simulation;

import entities.Robot;

import java.util.ArrayList;

public class OrderList {
    ArrayList<Order> orderList;

    public OrderList(){
    orderList = new ArrayList<Order>();
    }

    public OrderList(String documentPath){
    //This fills in the requestList from a document in the specified path
    }

    public void appendToRequestList(Order newOrder){
        //adds an order to the end of the requestList. Primarily intended for use when generating a simulation from a startup document
    }

//    public Robot callRobot(){
//
//        return R
//    }

}
