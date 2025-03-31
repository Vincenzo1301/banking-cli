package hm.edu.banking.cli.persistence.impl;

import hm.edu.banking.cli.model.Account;
import hm.edu.banking.cli.persistence.AccountStorage;
import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountStorage implements AccountStorage {

  private final Map<Integer, Account> accountMap = new HashMap<>();

  @Override
  public Account readAccount(int id) {
    return accountMap.get(id);
  }

  @Override
  public void createAccount(Account account) {
    accountMap.put(account.getId(), account);
  }

  @Override
  public int getNextAccountId() {
    return accountMap.size() + 1;
  }
}
