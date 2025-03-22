package hm.edu.banking.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hm.edu.banking.cli.persistence.AccountStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountStorageTest {

  private final AccountStorage accountStorage = new AccountStorage();

  @Test
  void shouldCreateAccount() {
    // given
    Account account = new Account();
    // when
    accountStorage.createAccount(account);
    // then
    Account createdAccount = accountStorage.readAccount(account.getId());
    assertEquals(account, createdAccount);
  }

  @Test
  void shouldReadAccount() {
    // given
    Account account = new Account();
    accountStorage.createAccount(account);
    // when
    Account readAccount = accountStorage.readAccount(account.getId());
    // then
    assertEquals(account, readAccount);
  }

  @Test
  void shouldReturnNullWhenAccountDoesNotExist() {
    // given
    Account account = new Account();
    // when
    Account readAccount = accountStorage.readAccount(account.getId());
    // then
    Assertions.assertNull(readAccount);
  }

  @Test
  void shouldReturnNextAccountId() {
    // given
    Account account = new Account();
    accountStorage.createAccount(account);
    // when
    int nextAccountId = accountStorage.getNextAccountId();
    // then
    assertEquals(account.getId() + 1, nextAccountId);
  }

  @Test
  void shouldIncrementNextAccountId() {
    // given
    Account account1 = new Account();
    Account account2 = new Account();
    // when
    accountStorage.createAccount(account1);
    accountStorage.createAccount(account2);
    // then
    assertEquals(account1.getId() + 1, account2.getId());
  }
}
