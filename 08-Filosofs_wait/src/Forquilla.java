package src;

public class Forquilla {

  public static final int LLIURE = -1;

  public final int index;
  private int propiertari = LLIURE;


  public Forquilla(int i) {
    index = i;
  }


  public int getPropiertary() { return propiertari; }

  public void setPropietary(int nouPropietari) {
    this.propiertari = nouPropietari;
  }

  synchronized public void deixar() {
    this.propiertari = LLIURE;
    notifyAll();
  }


}