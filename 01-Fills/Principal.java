


public class Principal {


  public static void main(String[] args) {
    
    Thread juan = new Fill("Juan");
    Thread pepe = new Fill("Pepe");

    pepe.setPriority(9);
    juan.setPriority(1);

    pepe.start();
    juan.start();



    System.out.println("Termina el fill main");

  }

}