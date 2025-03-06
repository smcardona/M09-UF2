package src;

public class Client {

  private String nom;

  public Client(int id) {
    nom = "Client-"+id;
  }

  public void tallarseElCabell() {
    System.out.printf("Tallant cabell a %s%n", nom);
  }

  public String getNom() {
    return nom;
  }
}