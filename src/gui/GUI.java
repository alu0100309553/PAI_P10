/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 10
 * Class/Program: QuickHull
 * File: GUI.java
 * Description: This is a program that use the quickhull algorithm to calculate the comvex hull .
 * @author Rubén Labrador Páez
 * @version 1.0.0 25/04/2016
 **/

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JApplet;

//Basic JApplet class
public class GUI extends JApplet {
  protected GraphPanel graphPanel;

  public void init(int points){
    graphPanel = new GraphPanel(points);
    setLayout(new BorderLayout());
    add(graphPanel, BorderLayout.CENTER);
    Dimension screenSize = new Dimension (600,300);
    //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screenSize);
    setVisible(true);
  }

  public GraphPanel getGraphPanel() {
    return graphPanel;
  }
}



