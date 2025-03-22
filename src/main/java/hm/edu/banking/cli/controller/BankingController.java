package hm.edu.banking.cli.controller;

import hm.edu.banking.cli.model.Account;
import hm.edu.banking.cli.persistence.AccountStorage;

/**
 * The BankingController class handles the core business logic for banking operations, including
 * creating accounts, verifying accounts, depositing and withdrawing money, and getting account
 * balances.
 */
public class BankingController {

  /** The AccountStorage object that handles the persistence of account data. */
  private AccountStorage accountStorage = new AccountStorage();

  /**
   * Creates a new account if it doesn't already exist.
   *
   * @param id the unique ID of the account to create
   * @param firstName the first name of the account holder
   * @param lastName the last name of the account holder
   * @param balance the initial balance of the account
   * @throws IllegalArgumentException if an account with the given ID already exists
   */
  public void createAccount(int id, String firstName, String lastName, double balance) {
    if (accountStorage.readAccount(id) == null) {
      Account account = new Account(id, firstName, lastName, balance);
      accountStorage.createAccount(account);
    } else {
      throw new IllegalArgumentException("Account already exists.");
    }
  }

  /**
   * Verifies if an account with the given ID exists.
   *
   * @param id the ID of the account to verify
   * @return true if the account exists, false otherwise
   */
  public boolean verifyAccount(int id) {
    return accountStorage.readAccount(id) != null;
  }

  /**
   * Deposits a specified amount into the account.
   *
   * @param id the ID of the account to deposit into
   * @param amount the amount to deposit
   * @throws IllegalArgumentException if the amount is less than or equal to 0
   */
  public void deposit(int id, double amount) {
    Account account = accountStorage.readAccount(id);

    if (amount > 0) {
      account.deposit(amount);
      System.out.println(amount + " EUR deposited.");
    } else {
      System.out.println("Amount must be greater than 0.");
    }
  }

  /**
   * Withdraws a specified amount from the account if sufficient funds are available.
   *
   * @param id the ID of the account to withdraw from
   * @param amount the amount to withdraw
   * @return true if the withdrawal is successful, false otherwise (e.g., insufficient funds)
   */
  public void withdraw(int id, double amount) {
    Account account = accountStorage.readAccount(id);

    if (amount > 0 && amount <= account.getBalance()) {
      account.withdraw(amount);
      System.out.println(amount + " EUR withdrawn.");
    } else {
      System.out.println("Insufficient funds.");
    }
  }

  /**
   * Retrieves the balance of the account with the given ID.
   *
   * @param id the ID of the account to retrieve the balance for
   * @return the current balance of the account
   */
  public double getBalance(int id) {
    Account account = accountStorage.readAccount(id);
    return account.getBalance();
  }

  /**
   * Retrieves the next available account ID for creating a new account.
   *
   * @return the next available account ID
   */
  public int getNextAccountId() {
    return accountStorage.getNextAccountId();
  }
}
