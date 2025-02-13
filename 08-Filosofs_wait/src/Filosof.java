package src;

import java.util.Random;

public class Filosof extends Thread {

  private static Random rnd = new Random();

  private Forquilla izq;
  private Forquilla der;
  private int index;

  private int gana = 0;


  public Filosof (int i, Forquilla izq, Forquilla der) {
    super("fil"+i);

    this.index = i;
    this.izq = izq;
    this.der = der;

  }

  @Override
  public void run() {

    try {
      
      while(true) {
        menjar();
        pensar();
      }


    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void agafarForquilles() throws InterruptedException {

    while (true) {
      agafaForquillaEsquerra();
      agafaForquillaDreta();
      if (der.getPropiertary() == this.index) break;
      else Thread.sleep(rnd.nextInt(500) + 500);
    }

  }

  public void agafaForquillaEsquerra() throws InterruptedException {

    while (izq.getPropiertary() != Forquilla.LLIURE) {
      synchronized (this) { wait(); }
    }

    izq.setPropietary(this.index);
    System.out.printf("Filòsof: %s agafa la forquilla esquerra %d%n", getName(), izq.index);
  }

  public void agafaForquillaDreta() throws InterruptedException {
    
    if (der.getPropiertary() != Forquilla.LLIURE) {
      izq.deixar();
      synchronized (this) {
        notifyAll();
      }
      System.out.printf("Filòsof: %s deixa la esquerra(%d) (dreta ocupada)%n", getName(), izq.index);
      incrementaGana();
    }
    else {
      der.setPropietary(this.index);
      System.out.printf("Filòsof: %s agafa la forquilla dreta %d%n", getName(), der.index);
    }

  }

  public void deixarForquilles() {
    izq.deixar();
    der.deixar();
  }

  public int getGana() { return gana; }

  public void menjar() throws InterruptedException {

    agafarForquilles();

    // come
    System.out.printf("Filòsof: %s menja%n", getName());
    Thread.sleep(rnd.nextInt(1000) + 1000);

    // deja las forquillas
    deixarForquilles();

    System.out.printf("Filòsof: %s ha acabat de menjar%n", getName());
    gana = 0;

  }

  public void pensar() throws InterruptedException {
    System.out.printf("Filòsof: %s pensant%n", getName());
    Thread.sleep(rnd.nextInt(1000) + 1000);
  }

  public void esperar() throws InterruptedException {
    Thread.sleep(rnd.nextInt(1000) + 1000);
  }

  public void incrementaGana() {
    gana++;
    System.out.printf("Filòsof: %s gana=%d%n", getName(), gana);
  }



  @Override
  public String toString() {

    return String.format("%s esq:%d dret:%d", getName(), izq.index, der.index);

  }


}