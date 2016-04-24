/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 9
 * Class/Program: Random Walk
 * File: GraphPanel.java
 * Description: This is a program that reproduce the two dimension random walk.
 * @author Rubén Labrador Páez
 * @version 1.0.0 18/04/2016
 **/

package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JPanel;

public class GraphPanel extends JPanel {
  private ArrayList<Coord> puntos = new ArrayList<Coord>();
  private Random rm = new Random();
 

  GraphPanel() {
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, this.getWidth(), this.getHeight());
    g.setColor(Color.RED);
    puntosGen(100);
    for (Coord punto : puntos){
      g.fillOval(punto.getX()-2, punto.getY()-2, 4, 4);
    }
    g.setColor(Color.BLUE);
    Collections.sort(puntos);
    g.drawLine(puntos.get(0).getX(), puntos.get(0).getY(), puntos.get(puntos.size()-1).getX(), puntos.get(puntos.size()-1).getY());
  }
 
  public void puntosGen (int cantidad){
    for (int i = 0; i < cantidad; i++){
      int y = rm.nextInt((int)(this.getHeight()*0.8))+(int)(this.getHeight()*0.1);
      int x = rm.nextInt((int)(this.getWidth()*0.8))+(int)(this.getWidth()*0.1);
      puntos.add(new Coord (y, x));
    
    }
  }

  
}
