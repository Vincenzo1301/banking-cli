package hm.edu.banking.cli.model;

public class Account {

  private final int id;
  private final String firstName;
  private final String lastName;

  private double balance;

  public Account(int id, String firstName, String lastName, double balance) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.balance = balance;
  }

  public int getId() {
    return id;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) {
    balance -= amount;
  }
}
