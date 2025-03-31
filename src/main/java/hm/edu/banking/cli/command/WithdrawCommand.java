package hm.edu.banking.cli.command;

import hm.edu.banking.cli.service.BankingService;

/**
 * The WithdrawCommand class represents the command to withdraw money from a specific bank account.
 * It extends the Command class and implements the execute method to perform the withdrawal
 * operation.
 */
public class WithdrawCommand extends Command {

  /**
   * Constructor to initialize the WithdrawCommand with the provided BankingService.
   *
   * @param bankingService the BankingService used to perform the withdrawal operation
   */
  protected WithdrawCommand(BankingService bankingService) {
    super(bankingService);
  }

  /**
   * Executes the command to withdraw a specified amount from the account. It takes an account ID
   * and an amount as parameters, validates them, and performs the withdrawal operation using the
   * BankingService.
   *
   * @param args the arguments for the command; expects the account ID as the first argument and the
   *     withdrawal amount as the second argument
   */
  @Override
  public void execute(String... args) {
    if (args.length < 2) {
      System.out.println("Usage: withdraw <accountId> <amount>");
      return;
    }

    try {
      int accountId = Integer.parseInt(args[0]);
      double amount = Double.parseDouble(args[1]);
      bankingService.withdraw(accountId, amount);
    } catch (NumberFormatException e) {
      System.out.println("Invalid input. Please enter a valid account ID and amount.");
    }
  }
}
