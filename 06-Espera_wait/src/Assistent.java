package src;

import java.util.Random;

public class Assistent extends Thread {

  private static Random rnd = new Random();

  private Esdeveniment esd;

  public Assistent(int nom, Esdeveniment esd) {
    super("Assistent-"+nom);
    this.esd = esd;
  }


  @Override
  public void run() {
    while (true) {
      try {
        if (rnd.nextFloat() > 0.5)  
          esd.ferReserva(this);
        
        else 
          esd.cancelaReserva(this);
  
        simulateDelay();
      } 
      catch (Exception e) {}

      
    }
  }

  private void simulateDelay() throws InterruptedException {
    Thread.sleep(rnd.nextInt(1000));
  }

  
}