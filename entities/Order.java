package entities;

import java.util.Collections;
import java.util.List;

public class Order extends Entity{

  //private String entityID;
  private final List<String> storageShelfID;
  private final int ticksToPack;
  private int totalTicksRequired;

  public Order(List<String> storageShelfID, int ticksToPack) {
    this.storageShelfID = storageShelfID;
    this.ticksToPack = ticksToPack;
  }

  //sets ticks as non negative int
  public void totalTicks(int totalTicksRequired) {
    if (totalTicksRequired < 0)
    throw new IllegalArgumentException("can not be a negative integer");
    this.totalTicksRequired = totalTicksRequired;
  }

  //getters
  //return storageShelfID for Order
  public List<String> getStorageShelfID() {
    return Collections.unmodifiableList(this.storageShelfID);
  }

  //return ticks to pack the Order
  public int getTicksToPack() {
    return ticksToPack;
  }

  //return total ticks required to pack Order
  public int gettotalTicksRequired() {
    return totalTicksRequired;
  }
}
