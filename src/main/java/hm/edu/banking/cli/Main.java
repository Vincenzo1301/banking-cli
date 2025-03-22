package hm.edu.banking.cli;

import hm.edu.banking.cli.view.BankMachine;

public class Main {
  public static void main(String[] args) {
    BankMachine cli = new BankMachine();
    cli.start();
  }
}
