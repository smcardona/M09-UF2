

public class Fill extends Thread {

  private String name;

  public Fill (String name) {
    super();
    this.name = name;
  }

  @Override
  public void run() {

    for (int i = 1; i < 10; i++) {
      System.out.println(String.format("%s %d", name, i));
    }

    System.out.println(String.format("Termina el fill %s", name));
  }

}