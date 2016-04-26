/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 10
 * Class/Program: QuickHull
 * File: Step.java
 * Description: This is a program that use the quickhull algorithm to calculate the comvex hull .
 * @author Rubén Labrador Páez
 * @version 1.0.0 25/04/2016
 **/

package gui;

import java.awt.Point;
import java.util.ArrayList;

//Class that stores a step of the algorithm
public class Step {
  private Point a;
  private Point b;
  private ArrayList <Point> outsidepoints;
  
  Step (Point a_, Point b_){
    a = a_;
    b = b_;
    outsidepoints = new ArrayList <Point>();
  }
  
  Step (Point a_, Point b_, ArrayList<Point> points_){
    a = a_;
    b = b_;
    outsidepoints = points_; 
  }
  
  public Point getA(){
    return a;
  }
  
  public Point getB(){
    return b;
  }
  
  public ArrayList <Point> getOutSidePoints(){
    return outsidepoints;
  }
}

