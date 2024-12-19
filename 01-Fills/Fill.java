

public class Fill extends Thread {

  private String name;

  public Fill (String name) {
    super();
    this.name = name;
  }

  @Override
  public void run() {

    for (int i = 1; i <= 10; i++) {


      if (i == 10) System.out.println("Termina el fill "+name);
      else System.out.println(name + " "+ i);

      Thread.yield();

    }
    

  }

}