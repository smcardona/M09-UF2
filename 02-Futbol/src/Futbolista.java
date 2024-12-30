package src;
import java.util.Random;

public class Futbolista extends Thread {

  public static final int NUM_JUGADORS = 11;
  public static final int NUM_TIRADES = 20;
  public static final float PROBABILITAT = 0.5f;

  private static final Random rnd = new Random();

  private int gols;
  private int tirades;

  public Futbolista(String name) {
    super(name);
    gols = 0;
    tirades = 0;
  }

  @Override
  public void run() {
    // Tira n veces
    for (tirades = 0; tirades < NUM_TIRADES; tirades++) {
      // si en cada tirada, aleatoriamente se consigue la probabilidad :
      if (rnd.nextFloat() <= PROBABILITAT) {
        gols++; // Cuenta el gol
      }
      Thread.yield(); // Libera el thread para otros jugadores
    }
  }

  public static void main(String[] args) {
    final String[] noms = {
      "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"
    };

    Futbolista[] futbolistas = new Futbolista[NUM_JUGADORS];

    System.out.println("Inici dels xuts --------------------");

    try {
      // Crear y iniciar todos los hilos
      for (int i = 0; i < NUM_JUGADORS; i++) {
        Futbolista f = new Futbolista(noms[i]);
        futbolistas[i] = f;
        f.start();
      }

      // Esperar a que todos los hilos terminen
      for (Futbolista f : futbolistas) {
        f.join();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("Fi dels xuts -----------------------");

    System.out.println("--- Estadístiques ------");
    for (Futbolista f : futbolistas) {
      System.out.printf("%-10s -> %d gols%n", f.getName(), f.gols);
    }
  }
}
