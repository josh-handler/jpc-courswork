public class Point {
  private int x;
  private int y;


  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  //move north
  public Point north() {
    int yNorth = y + 1;
    Point newLocation = new Point(x, yNorth);
    //if at edge, stay
    if (yNorth > Floor.Width) {
      return new Point(x, y);
    }
    else {
      return newLocation;
    }
  }

  //move east
  public Point east() {
    int xEast = x + 1;
    Point newLocation = new Point(xEast, y);
    //if at edge, stay
    if (xEast > Floor.Length) {
      return new Point(x, y);
    }
    else {
      return newLocation;
    }
  }

  //move south
  public Point south() {
    int ySouth = y - 1;
    Point newLocation = new Point(x, ySouth);
    //if at edge, stay
    if (ySouth < 0) {
      return new Point(x, y);
    }
    else {
      return newLocation;
    }
  }

  //move west
  public Point west() {
    int xWest = x - 1;
    Point newLocation = new Point(xWest, y);
    //if at edge, stay
    if (xWest < 0) {
      return new Point(x, y);
    }
    else {
      return newLocation;
    }
  }

  //getters
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  //setters
  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

}
