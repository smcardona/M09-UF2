package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread {

  private static Random rnd = new Random();

  private List<Tabac> tabacs;
  private List<Paper> papers;
  private List<Llumi> llumins;
  private boolean obert = false;

  public Estanc() {
    tabacs = new ArrayList<>();
    papers = new ArrayList<>();
    llumins = new ArrayList<>();
  }

  synchronized public void nouSubministrament() {
    int choice = rnd.nextInt(3);
    switch (choice) {
      case 0: addTabac(); break;
      case 1: addPaper(); break;
      case 2: addLlumi(); break;
    }

    notifyAll();
  }

  public void addTabac() { 
    System.out.println("Afegint Tabac");
    tabacs.add(new Tabac()); 
  }
  public void addLlumi() { 
    System.out.println("Afegint Llumi");
    llumins.add(new Llumi()); 
  }
  public void addPaper() { 
    System.out.println("Afegint Paper");
    papers.add(new Paper()); 
  }

  public Tabac venTabac() { 
    if (tabacs.size() > 0) {
      return tabacs.removeLast();
    }
    else return null;
  }

  public Llumi venLlumi() { 
    if (llumins.size() > 0) return llumins.removeLast();
    else return null;
  }

  public Paper venPaper() { 
    if (papers.size() > 0) return papers.removeLast();
    else return null;
  }

  @Override
  public void run() {

    obert = true;
    System.out.println("Estanc obert");

    while (obert) {
      nouSubministrament();
      
      try {
        Thread.sleep(rnd.nextInt(1000) + 500);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    System.out.println("Estanc tancat");

  }

  public void tancarEstanc() { obert = false; }

}