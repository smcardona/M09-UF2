public class MainDemoFil {
  public static void main(String[] args) {
    Thread currentThread = Thread.currentThread();
    System.out.println("MainDemoFil.main:");
    System.out.println("Prioritat -> " + currentThread.getPriority() + ", Nom -> " + currentThread.getName());
    System.out.println("toString() -> " + currentThread.toString());

    final String[] noms = {
      "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"
    };

    Futbolista[] futbolistas = new Futbolista[Futbolista.NUM_JUGADORS];


    try {
      for (int i = 0; i < Futbolista.NUM_JUGADORS; i++) {
        
        Futbolista f = new Futbolista(noms[i]);

        futbolistas[i] = f;

        f.start();
  
      }

      for (Thread t: futbolistas) {
        t.join();
        
        System.out.printf("Proritat -> %d, Nom -> %s%n", t.getPriority(), t.getName());
        System.out.println("toString() -> " + t.toString());
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }

    
  }
}
