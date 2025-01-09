package src;

import java.util.Random;

public class Motor extends Thread {

  private static Random rnd = new Random();
  
  private int actualPower = 0;
  private int goalPower = 0;


  public Motor(int i) {
    super(i+""); // name
  }


  public void setPotencia(int pow) {
    goalPower = pow;

    while (true) {

      int delay = rnd.nextInt(1000) + 1000; // min 1000, max 2000 
      String action;
      

      if (actualPower < goalPower) {
        action = "Incre.";
        actualPower++;
        simulateDelay(delay);

      }

      else if (actualPower > goalPower) {
        action = "Decre.";
        actualPower--;
        simulateDelay(delay);
      }

      else { // actual power == goal power
        action = "FerRes";
      }

      System.out.printf( "Motor %s: %s Objectiu: %d Actual: %d%n",
        getName(), action, goalPower, actualPower);

      if (actualPower == goalPower) ;
    }


  }

  @Override
  public void run() {

    while (true) {
      try {
        Thread.sleep(80);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    

    
  }

  private void simulateDelay(int delay) {
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }







}