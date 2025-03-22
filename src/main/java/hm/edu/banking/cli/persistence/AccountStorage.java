package hm.edu.banking.cli.persistence;

import hm.edu.banking.cli.model.Account;
import java.util.ArrayList;
import java.util.List;

/**
 * The AccountStorage class manages the storage and retrieval of account objects. It provides
 * methods to create new accounts, read existing accounts, and maintain a list of all accounts along
 * with a unique account ID generator.
 */
public class AccountStorage {

  /** A list that stores all the account objects. */
  private final List<Account> accounts = new ArrayList<>();

  /** The next available account ID to be assigned when a new account is created. */
  private int nextAccountId = 1;

  /**
   * Gets the next available account ID.
   *
   * @return the next available account ID
   */
  public int getNextAccountId() {
    return nextAccountId;
  }

  /**
   * Creates a new account by adding it to the storage and increments the next account ID.
   *
   * @param account the account to be created and added to storage
   */
  public void createAccount(Account account) {
    accounts.add(account);
    nextAccountId++;
  }

  /**
   * Reads an account from the storage based on its unique account ID.
   *
   * @param id the ID of the account to retrieve
   * @return the account with the specified ID, or null if no account with the given ID is found
   */
  public Account readAccount(int id) {
    for (Account account : accounts) {
      if (account.getId() == id) {
        return account;
      }
    }
    return null;
  }
}
