package hm.edu.banking.cli.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import hm.edu.banking.cli.model.Account;
import hm.edu.banking.cli.persistence.AccountStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BankingServiceTest {

  @Mock private AccountStorage accountStorage;

  @InjectMocks private BankingService bankingService;

  @Test
  void shouldCreateAccountWhenAccountDoesNotExist() {
    // given
    int accountId = 1;
    String firstName = "John";
    String lastName = "Doe";
    double balance = 100.0;
    when(accountStorage.getNextAccountId()).thenReturn(1);

    // when
    bankingService.createAccount(firstName, lastName, balance);

    // then
    verify(accountStorage).createAccount(any());
  }

  @Test
  void shouldVerifyAccountExists() {
    // given
    int accountId = 1;
    when(accountStorage.readAccount(accountId))
        .thenReturn(new Account(accountId, "John", "Doe", 100.0));

    // when
    boolean exists = bankingService.verifyAccount(accountId);

    // then
    assertTrue(exists);
  }

  @Test
  void shouldReturnFalseWhenAccountDoesNotExist() {
    // given
    int accountId = 1;
    when(accountStorage.readAccount(accountId)).thenReturn(null);

    // when
    boolean exists = bankingService.verifyAccount(accountId);

    // then
    assertFalse(exists);
  }

  @Test
  void shouldDepositAmountWhenValid() {
    // given
    int accountId = 1;
    double depositAmount = 50.0;
    Account mockAccount = mock(Account.class);
    when(accountStorage.readAccount(accountId)).thenReturn(mockAccount);

    // when
    bankingService.deposit(accountId, depositAmount);

    // then
    verify(mockAccount).deposit(depositAmount);
  }

  @Test
  void shouldNotDepositWhenAmountIsZeroOrNegative() {
    // given
    int accountId = 1;
    double depositAmount = -10.0;
    Account mockAccount = mock(Account.class);
    when(accountStorage.readAccount(accountId)).thenReturn(mockAccount);

    // when
    bankingService.deposit(accountId, depositAmount);

    // then
    verify(mockAccount, never()).deposit(anyDouble());
  }

  @Test
  void shouldWithdrawWhenSufficientPrintCurrentBalance() {
    // given
    int accountId = 1;
    double withdrawAmount = 50.0;
    Account mockAccount = mock(Account.class);
    when(accountStorage.readAccount(accountId)).thenReturn(mockAccount);
    when(mockAccount.getBalance()).thenReturn(100.0);

    // when
    bankingService.withdraw(accountId, withdrawAmount);

    // then
    verify(mockAccount).withdraw(withdrawAmount);
  }

  @Test
  void shouldNotWithdrawWhenInsufficientPrintCurrentBalance() {
    // given
    int accountId = 1;
    double withdrawAmount = 200.0;
    Account mockAccount = mock(Account.class);
    when(accountStorage.readAccount(accountId)).thenReturn(mockAccount);
    when(mockAccount.getBalance()).thenReturn(100.0);

    // when
    bankingService.withdraw(accountId, withdrawAmount);

    // then
    verify(mockAccount, never()).withdraw(anyDouble());
  }

  @Test
  void shouldReturnNextAccountId() {
    // given
    when(accountStorage.getNextAccountId()).thenReturn(5);

    // when
    int nextId = bankingService.getNextAccountId();

    // then
    assertEquals(5, nextId);
  }
}
