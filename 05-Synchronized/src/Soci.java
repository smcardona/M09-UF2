package src;

import java.util.Random;

public class Soci extends Thread {

  private Compte compte = Compte.getInstance();
  
  private static Random rnd = new Random();
  private static final float aportacio = 10f;
  private static final int esperaMax = 10;
  private static final int maxAnys = 10;

  public Soci() {}

  public Compte getCompte () { return this.compte; }

  @Override
  public void run () {
    // por cada año
    for (int i = 0; i < maxAnys; i++) {
      // por cada mes
      for (int mes = 0; mes < 12; mes++) {

        if (mes % 2 == 0) {
          compte.deposita(aportacio);
        }
        else {
          compte.treu(aportacio);
        }

        simulateDelay();

      }

    }

  }

  public void simulateDelay() {
    try {
      Thread.sleep(rnd.nextInt(esperaMax));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }






}