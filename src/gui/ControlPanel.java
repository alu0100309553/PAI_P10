/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 10
 * Class/Program: QuickHull
 * File: ControlPanel.java
 * Description: This is a program that use the quickhull algorithm to calculate the comvex hull .
 * @author Rubén Labrador Páez
 * @version 1.0.0 25/04/2016
 **/

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class ControlPanel extends GUI {
  private JButton inic = new JButton("Inicializar");
  private JButton ejec = new JButton("Ejecutar");
  private JButton pausa = new JButton("Pausa");
  private JButton paso = new JButton("Paso");
  private boolean isStandAlone = false;
  private int points = 100;
  private int velocity = 10;
  private Timer timer; 
  private final Dimension BTDIM = new Dimension(120, 30);
  private final int DEF_TIME = 1000;
  public static JFrame win = new JFrame(); 

  //Getters and setters
  private Timer getTimer() {
    return timer;
  }

  private JButton getInic() {
    return inic;
  }

  private JButton getEjec() {
    return ejec;
  }

  private JButton getPausa() {
    return pausa;
  }

  private JButton getPaso() {
    return paso;
  }

  //init method for applet.
  public void init(){
    // Reading arguments for applet use
    if (!isStandAlone){
      points = Integer.parseInt(getParameter("points"));
      velocity = Integer.parseInt(getParameter("velocity"));
    }
    super.init(points);
    
    // Setting period time
    int time = DEF_TIME/velocity;
    timer = new Timer(time, new MyActionListener());
    
    // Panel for controls
    JPanel opPanel = new JPanel();

    // Adding Listeners
    inic.addActionListener(new MyActionListener());
    ejec.addActionListener(new MyActionListener());
    paso.addActionListener(new MyActionListener());
    pausa.addActionListener(new MyActionListener());


    // Setting dimensions
    inic.setPreferredSize(BTDIM);
    ejec.setPreferredSize(BTDIM);
    paso.setPreferredSize(BTDIM);
    pausa.setPreferredSize(BTDIM);
    
    // Setting names to BDD
    inic.setName("inic");
    ejec.setName("ejec");
    paso.setName("paso");
    pausa.setName("pausa");

    // Setting panel layout
    opPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

    // Adding elements to panel
    opPanel.add(inic);
    opPanel.add(ejec);
    opPanel.add(paso);
    opPanel.add(pausa);
    
    // Adding panel to applet
    add(opPanel, BorderLayout.SOUTH);
  }
  
  // Method to start the algorithm
  public void run() {
    getTimer().start();
  }

  // Method to stop the algorithm
  public void stop() {
    getTimer().stop();
  }

  // Class to define the listener for buttons
  protected class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == getTimer()) {
        boolean aux = graphPanel.drawStep();
        if (!aux){
          stop();
        }
      } else if (e.getSource() == getInic()) {
        graphPanel.init();
      } else if (e.getSource() == getEjec()) {
        run();
      } else if (e.getSource() == getPaso()) {
        graphPanel.drawStep();
      } else if (e.getSource() == getPausa()) {
        stop();
      }
    }
  }

  // Main to use as stand alone app.
  public static void main(String[] args) {
    if (args.length ==2){
      
      ControlPanel window = new ControlPanel();
      //window.win = new JFrame();
      window.points = Integer.parseInt(args[0]);
      window.velocity = Integer.parseInt(args[1]);
      window.isStandAlone = true;
      win.add(window,BorderLayout.CENTER);
      window.init();
      window.start();
      win.setTitle("Quickhull");
      win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension screenSize = new Dimension (600,300);
      win.setSize(screenSize);
      win.setVisible(true);
    }
    else {
      System.err.println("No arguments or argument wrong: try java -jar quickhull.jar <number_of_points>  <velocity>");
    }
  }


}
