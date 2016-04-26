/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 10
 * Class/Program: QuickHull
 * File: QuickHull.java
 * Description: This is a program that use the quickhull algorithm to calculate the comvex hull .
 * @author Rubén Labrador Páez
 * @version 1.0.0 25/04/2016
 **/

package gui;

import java.awt.Point;
import java.util.ArrayList;

public class QuickHull{
  private ArrayList <Step> steps = new ArrayList <Step>();
  
  public ArrayList <Step> getSteps (){
    return steps;
  }

  //method that starts the algorithm
  public void quickHull(ArrayList<Point> points_){
    ArrayList<Point> points = new ArrayList<Point>();
    points.addAll(points_);
    if (points.size() < 3){
      getSteps().add(new Step(points.get(0), points.get(1)));
      getSteps().add(new Step(points.get(1), points.get(2)));
      getSteps().add(new Step(points.get(2), points.get(0)));
    }

    int minPoint = -1, maxPoint = -1;
    int minX = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    for (int i = 0; i < points.size(); i++)    {
      if (points.get(i).x < minX)      {
        minX = points.get(i).x;
        minPoint = i;
      }
      if (points.get(i).x > maxX)      {
        maxX = points.get(i).x;
        maxPoint = i;
      }
    }
    Point a = points.get(minPoint);
    Point b = points.get(maxPoint);
    points.remove(a);
    points.remove(b);

    ArrayList<Point> leftSet = new ArrayList<Point>();
    ArrayList<Point> rightSet = new ArrayList<Point>();

    for (int i = 0; i < points.size(); i++){
      Point p = points.get(i);
      if (pointLocation(a, b, p) == -1)
        leftSet.add(p);
      else if (pointLocation(a, b, p) == 1)
        rightSet.add(p);
    }
    getSteps().add(new Step(a, b, rightSet));
    getSteps().add(new Step(b, a, leftSet));
    hullSet(a, b, rightSet);
    hullSet(b, a, leftSet);
  }
  
  //Method to calculate the distance to a line
  public int distance(Point a, Point b, Point c){
    int abx = b.x - a.x;
    int aby = b.y - a.y;
    int num = abx * (a.y - c.y) - aby * (a.x - c.x);
    if (num < 0)
      num = -num;
    return num;
  }

  //method for the recursive phase of the algorithm
  public void hullSet(Point a, Point b, ArrayList<Point> set){
    if (set.size() == 0)
      return;
    if (set.size() == 1){
      Point p = set.get(0);
      getSteps().add(new Step(a, p));
      getSteps().add(new Step(p, b));
      return;
    }
    int dist = Integer.MIN_VALUE;
    int furthestPoint = -1;
    for (int i = 0; i < set.size(); i++){
      Point p = set.get(i);
      int distance = distance(a, b, p);
      if (distance > dist){
        dist = distance;
        furthestPoint = i;
      }
    }
    Point p = set.get(furthestPoint);

    // Determine the points outside of a-p
    ArrayList<Point> leftSetAP = new ArrayList<Point>();
    for (int i = 0; i < set.size(); i++){
      Point m = set.get(i);
      if (pointLocation(a, p, m) == 1)
      {
        leftSetAP.add(m);
      }
    }

    // Determine the points outside of p-b
    ArrayList<Point> leftSetPB = new ArrayList<Point>();
    for (int i = 0; i < set.size(); i++){
      Point M = set.get(i);
      if (pointLocation(p, b, M) == 1){
        leftSetPB.add(M);
      }
    }
    getSteps().add(new Step(a, p, leftSetAP));
    getSteps().add(new Step(p, b, leftSetPB));
    hullSet(a, p, leftSetAP);
    hullSet(p, b, leftSetPB);
  }

  //Method to determine the position of the points respect of a line 
  public int pointLocation(Point a, Point b, Point p){
    int cp1 = (b.x - a.x) * (p.y - a.y) - (b.y - a.y) * (p.x - a.x);
    if (cp1 > 0)
      return 1;
    else if (cp1 == 0)
      return 0;
    else
      return -1;
  }
}
