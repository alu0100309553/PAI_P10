/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 10
 * Class/Program: QuickHull
 * File: GraphPanel.java
 * Description: This is a program that use the quickhull algorithm to calculate the comvex hull .
 * @author Rubén Labrador Páez
 * @version 1.0.0 25/04/2016
 **/

package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class GraphPanel extends JPanel {
  private ArrayList<Point> points = new ArrayList<Point>();
  private ArrayList<Point> blackpoints = new ArrayList<Point>();
  private ArrayList<Point> bluepoints = new ArrayList<Point>();
  private ArrayList<Point> yellowpoints = new ArrayList<Point>();
  private Random rm = new Random();
  private QuickHull alg;
  private ArrayList<Step> lines = new ArrayList<Step>();
  private ArrayList<Step> linesTodraw = new ArrayList<Step>();
  private int stepControl = 0;
  private int nPoints = 0;
  private final int P_RADIO = 3;
  private final int P_DIAM = 6;
  private final double SC_RED_FACTOR = 0.8;
  private final double SC_OFFSET = 0.1;

  //Getters and Setters
  private ArrayList<Point> getPoints() {
    return points;
  }

  private ArrayList<Point> getBlackpoints() {
    return blackpoints;
  }

  private ArrayList<Point> getBluepoints() {
    return bluepoints;
  }

  private ArrayList<Point> getYellowpoints() {
    return yellowpoints;
  }

  private Random getRm() {
    return rm;
  }

  private QuickHull getAlg() {
    return alg;
  }
  
  private void  setAlg(QuickHull alg_) {
    alg = alg_;
  }

  private ArrayList<Step> getLines() {
    return lines;
  }

  private ArrayList<Step> getLinesTodraw() {
    return linesTodraw;
  }

  private int getStepControl() {
    return stepControl;
  }

  private int getnPoints() {
    return nPoints;
  }

  private void setStepControl(int stepControl) {
    this.stepControl = stepControl;
  }

  GraphPanel(int pointsN) {
    nPoints = pointsN;
  }
  
  //Method to initialize the GraphPanel parameters and list
  public void init() {
    getLines().clear();
    getPoints().clear();
    getBlackpoints().clear();
    getBluepoints().clear();
    getYellowpoints().clear();
    getLinesTodraw().clear();
    setStepControl(0);
    pointsGen(getnPoints());
    repaint();
  }

  //Method to draw a step of the algorithm
  public boolean drawStep() {
    Graphics g = this.getGraphics();
    g.setColor(Color.BLUE);

    if (getStepControl() < getLines().size()) {
      Step step = getLines().get(getStepControl());
      if (getStepControl() == 0) {
        getBlackpoints().removeAll(step.getOutSidePoints());
        getBluepoints().addAll(step.getOutSidePoints());
        getLinesTodraw().add(step);
      }
      if (getStepControl() == 1) {
        getBlackpoints().removeAll(step.getOutSidePoints());
        getBluepoints().addAll(step.getOutSidePoints());
        getLinesTodraw().add(step);
      }
      if (getStepControl() > 1) {
        getBluepoints().addAll(getPoints());
        getBluepoints().removeAll(step.getOutSidePoints());
        getYellowpoints().clear();
        getYellowpoints().addAll(step.getOutSidePoints());
        getLinesTodraw().add(step);
      }
      setStepControl(getStepControl() + 1);
      repaint();
      return true;
    } else {
      return false;
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    g.setColor(Color.BLACK);
    for (Point point : getBlackpoints()) {
      g.fillOval(point.x - P_RADIO, point.y - P_RADIO, P_DIAM, P_DIAM);
    }
    g.setColor(Color.BLUE);
    for (Point point : getBluepoints()) {
      g.fillOval(point.x - P_RADIO, point.y - P_RADIO, P_DIAM, P_DIAM);
    }
    g.setColor(Color.YELLOW);
    for (Point point : getYellowpoints()) {
      g.fillOval(point.x - P_RADIO, point.y - P_RADIO, P_DIAM, P_DIAM);
    }
    g.setColor(Color.RED);
    for (Step step : getLinesTodraw()) {
      g.drawLine(step.getA().x, step.getA().y, step.getB().x, step.getB().y);
    }
  }

  //Method to generate random points 
  public void pointsGen(int cantidad) {
    getPoints().clear();
    for (int i = 0; i < cantidad; i++) {
      int y = getRm().nextInt((int) (this.getHeight() * SC_RED_FACTOR))
          + (int) (this.getHeight() * SC_OFFSET);
      int x = getRm().nextInt((int) (this.getWidth() * SC_RED_FACTOR))
          + (int) (this.getWidth() * SC_OFFSET);
      getPoints().add(new Point(x, y));
    }
    setAlg(new QuickHull());
    getBlackpoints().addAll(points);
    getAlg().quickHull(points);
    getLines().clear();
    getLines().addAll(getAlg().getSteps());
    }
}
