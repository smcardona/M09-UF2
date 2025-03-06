package src;

import java.util.LinkedList;

public class Barberia extends Thread {

  public final Object condBarber = new Object();

  public static Barberia instance = null;

  private LinkedList<Client> cua = new LinkedList<>();
  private final int MAX_CADIRES;

  public Barberia(int maxCadires) {
    MAX_CADIRES = maxCadires;
  }

  public Client seguentClient() {
    if (cua.size() > 0) return cua.removeFirst();
    else return null;
  }

  public void entrarClient(Client client) {
    if (cua.size() < MAX_CADIRES) {
      // agrega a la cua
      cua.add(client);
      System.out.printf("Client %s en espera%n", client.getNom());
      // desperta al barber
      synchronized (condBarber) {
        condBarber.notifyAll();
      }
    }
    else {
      System.out.printf("No queden cadires, client %s se'n va%n", client.getNom());
    }
  }

  @Override
  public void run() {
    for(int i = 0; i < 10; i++) {
      instance.entrarClient(new Client(i));
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    try {
      Thread.sleep(10_000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    for(int i = 10; i < 20; i++) {
      instance.entrarClient(new Client(i));
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {

    Barberia.instance = new Barberia(3);
    Barber barber = new Barber("Pepe");

    barber.start();
    Barberia.instance.start();
    
  }

  

  


}