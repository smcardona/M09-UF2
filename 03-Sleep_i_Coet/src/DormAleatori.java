package src;

import java.util.Random;

public class DormAleatori extends Thread {

  private static Random rnd = new Random();

  private long createdAt;
  
  public DormAleatori(String name) {
    super(name);

    createdAt = System.currentTimeMillis();

  }

  @Override
  public void run() {
    
    for (int i = 0; i < 10; i++) {

      long timeSinceCreated = System.currentTimeMillis() - createdAt;
      int timeToSleep = rnd.nextInt(1000);
      

      System.out.printf("%-6s (%d) a dormir %4dms total %7d%n",
        getName(), i, timeToSleep, timeSinceCreated);

      try {
        Thread.sleep(timeToSleep);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      
    }

  }


  public static void main(String[] args) {

    Thread juan = new DormAleatori("Joan");
    Thread pepe = new DormAleatori("Pep");

      
    juan.start();
    pepe.start();

    
    System.out.println("-- Fi de main -----------");


  }




}