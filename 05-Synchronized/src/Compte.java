package src;


public class Compte {
  private Compte() {}
  private static final Compte globalAccount = new Compte();


  private float saldo;


  public static Compte getInstance() { return globalAccount; }

  public float getSaldo() { return saldo; }

  public void setSaldo(float saldo) { this.saldo = saldo; }

  public synchronized void deposita(float amount) { 
    this.saldo += Math.abs(amount);
  }

  public synchronized void treu(float amount) { 
    this.saldo -= Math.abs(amount);
  }


}