package gui;


public class Coord implements Comparable<Coord>{
  private int y;
  private int x;
  
  Coord(int y_, int x_){
    y = y_;
    x = x_;
  }
  
  public int getX(){
    return x;
  }
  
  public int getY(){
    return y;
  }

  @Override
  public int compareTo(Coord c) {
    if (getX() < c.getX()){
      return -1;
    } else if (getX() > c.getX()){
      return 1;
    } else {
      return 0;
    }
  }
  
  

}
