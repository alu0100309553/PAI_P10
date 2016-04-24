/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 9
 * Class/Program: Random Walk
 * File: ControlPanel.java
 * Description: This is a program that reproduce the two dimension random walk.
 * @author Rubén Labrador Páez
 * @version 1.0.0 18/04/2016
 **/

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;


public class ControlPanel extends GUI {
  private JButton inic = new JButton("Inicializar");
  private JButton ejec = new JButton("Ejecutar");
  private JButton pausa = new JButton("Pausa");
  private JButton paso = new JButton("Paso");

  private Timer timer = new Timer(100, new MyActionListener());

  private final Dimension BTDIM = new Dimension(120, 30);
  
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

  

  public ControlPanel() {
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
   

    // Setting panel layout
    opPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    // opPanel.setLayout(new GridLayout(13,1,1,1));

    // Adding elements to panel
    opPanel.add(inic);
    opPanel.add(ejec);
    opPanel.add(paso);
    opPanel.add(pausa);

    // Adding opPanel to frame
    getFrame().add(opPanel, BorderLayout.SOUTH);

    // Setting graphic panel default settings
 

    // Setting member variables
 
  }

  

  // Internal class for slider events
  

  // Internal class for buttons and jtextfields events
  protected class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == getTimer()) {

      
      } else if (e.getSource() == getInic()) {
       
      } else if (e.getSource() == getEjec()) {
        
      } else if (e.getSource() == getPaso()) {
       
      } else if (e.getSource() == getPausa()) {
        
      }
    }
  }

 
}
