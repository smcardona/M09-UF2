package src;


public class Taula {

  private Filosof[] comensals;
  private Forquilla[] forquilles;

  public Taula(final int NUM_COMENSALS) {

    // inicia forquilles
    forquilles = new Forquilla[NUM_COMENSALS];
    for(int i = 0; i < NUM_COMENSALS; i++) {
      forquilles[i] = new Forquilla(i);
    }

    // inicia comensals
    comensals = new Filosof[NUM_COMENSALS];
    for(int i = 0; i < NUM_COMENSALS; i++) {
      int forqDer = (i+1) % NUM_COMENSALS;

      comensals[i] = new Filosof(i, forquilles[i], forquilles[forqDer]);

    }

  }

  public void mostrarTaula () {
    
    System.out.println("\n------------------------------");
    for (Filosof fil: comensals) {
      System.out.println("Comensal"+fil.toString());
    }
    System.out.println("------------------------------");
  }

  public void cridarTaula () {
    for (Thread com: comensals) {
      com.start();
    }

    for (Thread com: comensals) {
      try {
        com.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  public static void main(String[] args) {

    Taula taula = new Taula(4);

    taula.mostrarTaula();

    taula.cridarTaula();


  }


}