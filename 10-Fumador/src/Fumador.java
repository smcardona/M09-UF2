package src;

import java.util.Random;

public class Fumador extends Thread {
  private Random rnd = new Random();

  private Estanc estanc;
  public final int id;
  private Tabac tabac = null;
  private Llumi llumi = null;
  private Paper paper = null;
  private int fumades = 0;

  public Fumador(Estanc estanc, int id) {
    this.estanc = estanc;
    this.id = id;
  }

  public void fuma() throws InterruptedException {
    if (tabac != null && llumi != null && paper != null) {
      System.out.printf("Fumador %d fumant%n", id);
      fumades++;
      System.out.printf("Fumador %d ha fumat %d vegades%n", id, fumades);

      tabac = null;
      llumi = null;
      paper = null;

      Thread.sleep(rnd.nextInt(500) + 500);
      
    }
  }

  public void compraTabac() throws InterruptedException {
    System.out.printf("Fumador %d comprant Tabac%n", id);
    synchronized (estanc) {
      while ((tabac = estanc.venTabac()) == null) {
        estanc.wait();
      }
    }
  }

  public void compraPaper() throws InterruptedException {
    System.out.printf("Fumador %d comprant Paper%n", id);
    synchronized (estanc) {
      while((paper = estanc.venPaper()) == null) {
        estanc.wait();
      }
    }
  }

  public void compraLlumi() throws InterruptedException {
    System.out.printf("Fumador %d comprant Llumi%n", id);
    synchronized (estanc) {
      while((llumi = estanc.venLlumi()) == null) {
        estanc.wait();
      }
    }
  }

  @Override
  public void run() {

    while (fumades < 3) {

      try {
        compraTabac();
        compraPaper();
        compraLlumi();

        fuma();
      } catch (Exception e) {
        e.printStackTrace();
      }

    }

  }
  
}