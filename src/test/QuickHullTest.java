package test;
/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 8
 * Class/Program: Move a Ball
 * File: MoveBallTest.java
 * Description: This program is an exercise to practice the use of Action Listeners. The user can move a blue ball drawn in a JPanel using four buttons. This class implements test using AssertJ libraries and Junit.
 * @author Rubén Labrador Páez
 * @version 1.0.0 11/04/2016
 **/

import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gui.ControlPanel;

public class QuickHullTest {
  private FrameFixture frame;
  
  @Before
  public void initialize() {
    String param[] = {"100", "10"};
    ControlPanel.main(param);
    frame = new FrameFixture(ControlPanel.win);
  }

  @Test
  public void testInic() {
    //frame.maximize();
    //frame.button("inic_").click();
    
  }
 
  @Test
  public void testEjec() {
    //frame.focus();
    //frame.button("ejec_").click();
  }
  
  @Test
  public void testPaso() {
    //frame.focus();
    //frame.button("paso_").click();
  }
  
  @Test
  public void testPausa() {
    //frame.focus();
    frame.button("inic_").click();
  }
  
  /*
  @Test
  public void testPausa() {
    frame.button("pausa").click();
  }
  */
  /**
  @Test
  public void testDown() {
    int temp = window.getBallPanel().getyOffset();
    frame.button("down").click();
    assertThat(window.getBallPanel().getyOffset()).isEqualTo(temp+STEP);
    frame.button("down").click();
    assertThat(window.getBallPanel().getyOffset()).isEqualTo(window.getBallPanel().getyMid()-(window.getBallPanel().getBallD()));
  }
  
  @Test
  public void testLeft() {
    int temp = window.getBallPanel().getxOffset();
    frame.button("left").click();
    assertThat(window.getBallPanel().getxOffset()).isEqualTo(temp-STEP);
    frame.button("left").click();
    frame.button("left").click();
    assertThat(window.getBallPanel().getxOffset()).isEqualTo(-window.getBallPanel().getxMid());
  }
  
  @Test
  public void testRight() {
    int temp = window.getBallPanel().getxOffset();
    frame.button("right").click();
    assertThat(window.getBallPanel().getxOffset()).isEqualTo(temp+STEP);
    frame.button("right").click();
    frame.button("right").click();
    assertThat(window.getBallPanel().getxOffset()).isEqualTo(window.getBallPanel().getxMid()-(window.getBallPanel().getBallD()));
  }
  
  @Test
  public void testResize() {
    frame.focus();
    int temp = window.getBallPanel().getHeight()/2;
    frame.focus();
    int temp2 = window.getBallPanel().getyMid();
    assertThat(1).isEqualTo(1);
    assertThat(temp).isEqualTo(temp2);
    frame.maximize();
    frame.focus();
    temp = window.getBallPanel().getHeight()/2;
    frame.focus();
    temp2 = window.getBallPanel().getyMid();
    assertThat(temp).isEqualTo(temp2);
  }  
*/
  @After
  public void clear() {
    frame.cleanUp();
  }
}