package src;

import java.util.Random;

public class Filosof extends Thread {

  private static Random rnd = new Random();
  private long iniciGana = System.currentTimeMillis();
  private long fiGana = iniciGana;
  private long Gana = 0;

  private Forquilla izq;
  private Forquilla der;



  public Filosof (int i, Forquilla izq, Forquilla der) {
    super("Fil"+i);

    this.izq = izq;
    this.der = der;

  }

  public void calcularGana() {
    fiGana = System.currentTimeMillis();
    Gana = (fiGana - iniciGana) / 1000;
  }

  public void resetGana() {
    iniciGana = System.currentTimeMillis();
    Gana = 0;
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

    agafaForquillaEsquerra();
    agafaForquillaDreta();
    System.out.printf("%s té forquilles esq(%d) dreta(%d)%n", getName(), izq.index, der.index);
  }

  public void agafaForquillaEsquerra() throws InterruptedException {

    izq.agafar();
  }

  public void agafaForquillaDreta() {
    
    der.agafar();
  }

  public void deixarForquilles() {
    izq.deixar();
    der.deixar();

  }

  public void menjar() throws InterruptedException {

    agafarForquilles();

    // come
    calcularGana();
    System.out.printf("%s menja amb gana %d%n", getName(), Gana);
    Thread.sleep(rnd.nextInt(1000) + 1000);

    System.out.printf("%s ha acabat de menjar%n", getName());
    fiGana = System.currentTimeMillis();

    // deja las forquillas
    deixarForquilles();

  }

  public void pensar() throws InterruptedException {
    System.out.printf("%s pensant%n", getName());
    resetGana();
    Thread.sleep(rnd.nextInt(1000) + 1000);
  }


  @Override
  public String toString() {

    return String.format("%s esq:%d dret:%d", getName(), izq.index, der.index);

  }


}
