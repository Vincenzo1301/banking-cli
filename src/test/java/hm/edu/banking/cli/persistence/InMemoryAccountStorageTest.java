package hm.edu.banking.cli.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hm.edu.banking.cli.model.Account;
import hm.edu.banking.cli.persistence.impl.InMemoryAccountStorage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InMemoryAccountStorageTest {

  private final AccountStorage accountStorage = new InMemoryAccountStorage();

  @Test
  void shouldCreateAccount() {
    // given
    Account account = new Account(1, "John", "Doe", 100);
    // when
    accountStorage.createAccount(account);
    // then
    Account createdAccount = accountStorage.readAccount(account.getId());
    assertEquals(account, createdAccount);
  }

  @Test
  void shouldReadAccount() {
    // given
    Account account = new Account(1, "John", "Doe", 100);
    accountStorage.createAccount(account);
    // when
    Account readAccount = accountStorage.readAccount(account.getId());
    // then
    assertEquals(account, readAccount);
  }

  @Test
  void shouldReturnNullWhenAccountDoesNotExist() {
    // given
    Account account = new Account(1, "John", "Doe", 100);
    // when
    Account readAccount = accountStorage.readAccount(account.getId());
    // then
    Assertions.assertNull(readAccount);
  }

  @Test
  void shouldReturnNextAccountId() {
    // given
    Account account = new Account(1, "John", "Doe", 100);
    accountStorage.createAccount(account);
    // when
    int nextAccountId = accountStorage.getNextAccountId();
    // then
    assertEquals(account.getId() + 1, nextAccountId);
  }
}
