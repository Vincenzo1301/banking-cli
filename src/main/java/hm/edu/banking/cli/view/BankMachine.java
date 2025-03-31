package hm.edu.banking.cli.view;

import static java.lang.String.valueOf;

import hm.edu.banking.cli.command.Command;
import hm.edu.banking.cli.command.CommandFactory;
import hm.edu.banking.cli.persistence.impl.InMemoryAccountStorage;
import hm.edu.banking.cli.service.BankingService;
import hm.edu.banking.cli.util.InputHelper;

public class BankMachine {

  private final BankingService bankingService;
  private final CommandFactory factory;

  public BankMachine() {
    this.bankingService = new BankingService(new InMemoryAccountStorage());
    this.factory = new CommandFactory(bankingService);
  }

  public void start() {
    while (true) {
      System.out.println("--- Banking CLI ---");
      System.out.println("What would you like to do?");
      System.out.println("1. Create account");
      System.out.println("2. Access account");
      System.out.println("3. Exit");
      System.out.print("Please choose an option: ");

      int choice = InputHelper.readInt();
      switch (choice) {
        case 1:
          createAccount();
          break;
        case 2:
          accessAccount();
          break;
        case 3:
          System.out.println("Goodbye!");
          return;
        default:
          System.out.println("Invalid option. Please try again.");
      }
    }
  }

  private void createAccount() {
    System.out.println("Please enter your first name: ");
    String firstName = InputHelper.readString();

    System.out.println("Please enter your last name: ");
    String lastName = InputHelper.readString();

    System.out.println("Please enter your initial balance: ");
    double balance = InputHelper.readDouble();

    bankingService.createAccount(firstName, lastName, balance);
    System.out.println("Account created successfully!");
  }

  private void accessAccount() {
    System.out.print("Please enter your account ID: ");
    int accountId = InputHelper.readInt();

    boolean exists = bankingService.verifyAccount(accountId);
    if (!exists) {
      System.out.println("Account does not exist. Please try again.");
      return;
    }

    manageAccount(accountId);
  }

  private void manageAccount(int accountId) {
    while (true) {
      System.out.println("1. Check balance");
      System.out.println("2. Deposit");
      System.out.println("3. Withdraw");
      System.out.println("4. Exit");
      System.out.print("Please choose an option: ");

      int choice = InputHelper.readInt();

      switch (choice) {
        case 1:
          showBalance(accountId);
          break;
        case 2:
          deposit(accountId);
          break;
        case 3:
          withdraw(accountId);
          break;
        case 4:
          System.out.println("Exiting account.");
          return;
        default:
          System.out.println("Invalid option. Please try again.");
      }
    }
  }

  private void showBalance(int accountId) {
    Command command = factory.getCommand("balance");
    command.execute(valueOf(accountId));
  }

  private void deposit(int accountId) {
    System.out.print("Enter deposit amount: ");
    double amount = InputHelper.readDouble();

    Command command = factory.getCommand("deposit");
    command.execute(valueOf(accountId), valueOf(amount));
  }

  private void withdraw(int accountId) {
    System.out.print("Enter withdrawal amount: ");
    double amount = InputHelper.readDouble();

    Command command = factory.getCommand("withdraw");
    command.execute(valueOf(accountId), valueOf(amount));
  }
}
