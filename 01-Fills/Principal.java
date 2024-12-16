


public class Principal {


  public static void main(String[] args) {
    
    Thread juan = new Fill("Juan");
    Thread pepe = new Fill("Pepe");

    juan.setPriority(1);
    pepe.setPriority(1);

    juan.start();
    pepe.start();

    System.out.println("Termina el fill main");

  }

}