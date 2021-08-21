package entities;

public class PackingStation extends Entity {

//entityID?
//Location??
private enum Type {GETTING, WAITING, PACKING, DISPATCHING}

/**
method:
AT A CURRENT tick
CHECK PackingStation STATUS

switch CASE
 getting: getting order function at that tick
 Waiting: Waiting for Robot
 Packing: packing order function that needs certain amt of ticksToPack
 Dispacthing: dispacting completed order at that tick

method: get order from order manager
method: take item from robot
method: pack order
method: dispacth order

**/
}
