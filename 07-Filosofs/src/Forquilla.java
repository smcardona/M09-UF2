package src;

public class Forquilla {

  private boolean enUs = false;
  public final int index;

  public Forquilla(int i) {
    index = i;
  }

  public boolean enUs() { return enUs; }

  public void pillar() {

    enUs = true;
  }

  public void deixar() {

    enUs = false;

  }


}