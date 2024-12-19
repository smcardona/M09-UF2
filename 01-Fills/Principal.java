


public class Principal {


  public static void main(String[] args) {
    
    Thread juan = new Fill("Juan");
    Thread pepe = new Fill("Pepe");


    try {
      pepe.setPriority(5);
      juan.setPriority(5);

      pepe.start();
      juan.start();

      pepe.join();
      juan.join();

    } catch (Exception e) {
      e.printStackTrace();
    }

    



    System.out.println("Termina el fill main");

  }

}