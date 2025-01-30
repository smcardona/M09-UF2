package src;

public class Organitzador {

  public static void main(String[] args) {
    
    Esdeveniment esd = new Esdeveniment(5);

    Assistent[] assists = new Assistent[10];

    for(int i = 0; i < 10; i++) {
      assists[i] = new Assistent(i, esd);
    }


    for(Assistent assist: assists) {
      assist.start();
    }


  }

}