package src;

public class Associacio {

  private final int numSocis = 100;
  private final Soci[] socis = new Soci[numSocis];

  public Associacio() {
    for (int i = 0; i < numSocis; i++) {
      socis[i] = new Soci();
    }

  }

  public void iniciaCompteTempsSocis() {
    for (Soci s: socis) {
      s.start();
    }
  }

  public void esperaPeriodeSocis() {
    for(Soci s: socis) {
      try {
        s.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
  public void mostraBalancComptes() {
    for (Soci s: socis) {
      System.out.printf("Saldo: %.2f%n",s.getCompte().getSaldo());
      break;
    }
  }

  public static void main(String[] args) {
    
    Associacio aso = new Associacio();

    aso.iniciaCompteTempsSocis();
    aso.esperaPeriodeSocis();
    aso.mostraBalancComptes();

  }


}