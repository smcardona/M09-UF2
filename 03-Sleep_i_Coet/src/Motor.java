package src;

import java.util.Random;

public class Motor extends Thread {

  private static Random rnd = new Random();
  private boolean running = false;
  
  private int actualPower = 0;
  private int goalPower = 0;


  public Motor(int i) {
    super(i+""); // name
  }


  public void setPotencia(int pow) {
    goalPower = pow;
  }


  public void stopMotor() {
    running = false;
  }

  @Override
  public void run() {
    running = true;
        try {

      while (running) {
        // Mantiene vivo el thread, mientras no se le pida que pare
        Thread.sleep(100);

        
        // Si encuentra diferencia, cambia el poder al poder que se quiere
        if (actualPower != goalPower) {
          changePower();
        }
      }

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void simulateDelay(int delay) {
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    
  }


  public void changePower() {
    while (true) {

      int delay = rnd.nextInt(1000) + 1000; // min 1000, max 2000 
      // Texto para mostrar que se hará
      String action = actualPower < goalPower ? "Incre." :
                      actualPower > goalPower ? "Decre." : 
                      "FerRes";

      System.out.printf( "Motor %s: %s Objectiu: %d Actual: %d%n",
        getName(), action, goalPower, actualPower);

      if (actualPower == goalPower) break;
      
      simulateDelay(delay);

      // Incrementa o decrementa segun si era mayor o menor
      actualPower += actualPower < goalPower ? 1 : -1;


    }

  }

}