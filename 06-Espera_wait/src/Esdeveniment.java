package src;

import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {

  private List<Assistent> assistents = new ArrayList<>();
  private int maxSlots;
  private int slotsLeft;

  public Esdeveniment(int slots) {
    maxSlots = slots;
    slotsLeft = maxSlots;
  }


  public synchronized void ferReserva(Assistent assistent) throws InterruptedException {

    while (slotsLeft == 0){
      wait();
    }

    assistents.add(assistent);
    slotsLeft--;


    System.out.printf("%s ha fet una reserva. Places disponibles: %d%n", assistent.getName(), slotsLeft);

  }


  public synchronized void cancelaReserva(Assistent assistent) {

    if(assistents.remove(assistent)){

      System.out.printf("%s ha cancelat una reserva. Places disponibles: %d%n", assistent.getName(), slotsLeft);
      slotsLeft++;

      notifyAll();

    }
    else{
      System.out.printf("%s no ha pogut cancel·lar una reserva inexistent. Places disponibles: %d%n", assistent.getName(), slotsLeft);
    }
  }


}