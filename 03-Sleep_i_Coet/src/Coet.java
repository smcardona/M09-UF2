package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coet {
  private static BufferedReader reader = new BufferedReader(
    new InputStreamReader(System.in)
  );

  private Motor[] motors;

  public Coet(int motors) {
    this.motors = new Motor[motors];

    for (int i = 0; i < motors; i++) {
      this.motors[i] = new Motor(i);
      this.motors[i].start();
    }
  }

  public void passaAPotencia(int pow) throws InterruptedException {

    if (pow < 0 || pow > 10) throw new IllegalArgumentException("Potència invàlida");

    for(Motor m: motors) {
      m.setPotencia(pow);
    }

  }

  public void apaga() {
    for(Motor m: motors) {
      m.stopMotor();;
    }
  }

  public static void main(String[] args) {
    
    Coet coet = new Coet(4);

    while(true) {
      try {

        int pow = requestPower();

        System.out.printf("Passant a potència %d%n", pow);

        coet.passaAPotencia(pow);

        if (pow == 0) {
          coet.apaga();
          break;
        };
        
        
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

  private static int requestPower() throws NumberFormatException, IOException {
    return Integer.parseInt(reader.readLine());
  }




}