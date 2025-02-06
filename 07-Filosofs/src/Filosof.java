package src;

import java.util.Random;

public class Filosof extends Thread {

  private static Random rnd = new Random();

  private Forquilla izq;
  private Forquilla der;

  private int gana = 0;


  public Filosof (int i, Forquilla izq, Forquilla der) {
    super("fil"+i);

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


  public int getGana() { return gana; }

  public void menjar() throws InterruptedException {

    // intenta pillar primera forquilla
    if (izq.enUs()) {
      incrementaGana();
      tornaAIntentar();
      return;
    }
    
    izq.pillar();
    System.out.printf("Filòsof: %s agafa la forquilla esquerra %d%n", getName(), izq.index);

    // intenta pillar segunda forquilla
    if (der.enUs()) {
      izq.deixar(); // deja la forquilla al haberla pillado anteriormente
      System.out.printf("Filòsof: %s deixa la esquerra(%d) (dreta ocupada)%n", getName(), izq.index);
      incrementaGana();
      tornaAIntentar();
      return;
    }

    der.pillar();
    System.out.printf("Filòsof: %s agafa la forquilla dreta %d%n", getName(), der.index);


    // come
    System.out.printf("Filòsof: %s menja%n", getName());
    Thread.sleep(rnd.nextInt(1000) + 1000);

    // deja las forquillas
    izq.deixar();
    der.deixar();

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

  private void tornaAIntentar() throws InterruptedException {
    Thread.sleep(rnd.nextInt(500) + 500);
    menjar();
  }

  @Override
  public String toString() {

    return String.format("%s esq:%d dret:%d", getName(), izq.index, der.index);

  }


}