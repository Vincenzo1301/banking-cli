package hm.edu.banking.cli.controller;

import hm.edu.banking.cli.model.Account;
import hm.edu.banking.cli.persistence.AccountStorage;

public class BankingController {

  private AccountStorage accountStorage = new AccountStorage();

  public void createAccount(int id, String firstName, String lastName, double balance) {
    if (accountStorage.readAccount(id) == null) {
      Account account = new Account(id, firstName, lastName, balance);
      accountStorage.createAccount(account);
    } else {
      throw new IllegalArgumentException("Account already exists.");
    }
  }

  public boolean verifyAccount(int id) {
    return accountStorage.readAccount(id) != null;
  }

  public void deposit(int id, double amount) {
    Account account = accountStorage.readAccount(id);

    if (amount > 0) {
      account.deposit(amount);
      System.out.println(amount + " EUR deposited.");
    } else {
      System.out.println("Amount must be greater than 0.");
    }
  }

  public boolean withdraw(int id, double amount) {
    Account account = accountStorage.readAccount(id);

    if (amount > 0 && amount <= account.getBalance()) {
      account.withdraw(amount);
      return true;
    } else {
      return false;
    }
  }

  public double getBalance(int id) {
    Account account = accountStorage.readAccount(id);
    return account.getBalance();
  }

  public int getNextAccountId() {
    return accountStorage.getNextAccountId();
  }
}
