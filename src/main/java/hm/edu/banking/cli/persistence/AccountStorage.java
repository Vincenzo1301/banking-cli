package hm.edu.banking.cli.persistence;

import hm.edu.banking.cli.model.Account;

/**
 * The AccountStorage interface defines the methods for handling account persistence. It provides
 * methods to read, create, and retrieve account IDs. Implementations of this interface manage the
 * storage and retrieval of account data, whether it's stored in memory, a database, or other
 * systems.
 */
public interface AccountStorage {

  /**
   * Retrieves the account associated with the given account ID.
   *
   * @param id the unique ID of the account to retrieve
   * @return the Account object corresponding to the given ID, or null if no account exists with the
   *     specified ID
   */
  Account readAccount(int id);

  /**
   * Creates a new account and stores it.
   *
   * @param account the Account object to be created and stored
   */
  void createAccount(Account account);

  /**
   * Retrieves the next available unique account ID.
   *
   * @return the next available account ID to be used when creating a new account
   */
  int getNextAccountId();
}
