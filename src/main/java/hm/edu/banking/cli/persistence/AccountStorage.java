package hm.edu.banking.cli.persistence;

import hm.edu.banking.cli.model.Account;
import java.util.ArrayList;
import java.util.List;

public class AccountStorage {

  private final List<Account> accounts = new ArrayList<>();
  private int nextAccountId = 1;

  public int getNextAccountId() {
    return nextAccountId;
  }

  public void createAccount(Account account) {
    accounts.add(account);
    nextAccountId++;
  }

  public Account readAccount(int id) {
    for (Account account : accounts) {
      if (account.getId() == id) {
        return account;
      }
    }
    return null;
  }
}
