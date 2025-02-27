package src;

public class Barri {

  private Estanc estanc;
  private Fumador[] fumadors = new Fumador[3];

  public Barri() {
    estanc = new Estanc();

    for (int i = 0; i <3; i++) {
      fumadors[i] = new Fumador(estanc, i);
    }

  }

  public static void main(String[] args) {

    Barri barri = new Barri();
    
    for (Fumador f: barri.fumadors) {
      f.start();
    }

    barri.estanc.start();

    for (Fumador f: barri.fumadors) {
      try {
        f.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    barri.estanc.tancarEstanc();

  }

}