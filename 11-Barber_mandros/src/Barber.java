package src;

import java.util.Random;

public class Barber extends Thread {

  private static Random rnd = new Random();

  private String nom;

  public Barber(String nom) {
    this.nom = nom;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  @Override
  public void run() {

    while (true) {

      Client actual = null;
  
      while ((actual = Barberia.instance.seguentClient()) == null) {
        try {
          System.out.println("Ningú en espera");
          System.out.printf("Barber %s dormint%n", nom);
          synchronized (Barberia.instance.condBarber) {
            Barberia.instance.condBarber.wait();
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
  
  
      System.out.printf("Li toca al client %s%n", actual.getNom());
      actual.tallarseElCabell();

      try {
        Thread.sleep(900 + rnd.nextInt(100));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }




    
    }



  }

  

}