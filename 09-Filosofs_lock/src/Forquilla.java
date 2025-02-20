package src;

import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {

  public static final int LLIURE = -1;

  private ReentrantLock lock = new ReentrantLock(true);

  public final int index;


  public Forquilla(int i) {
    index = i;
  }



  public void agafar() {
    lock.lock();
  }

  synchronized public void deixar() {
    if (lock.isHeldByCurrentThread()) {
      lock.unlock();
    }
  }


}