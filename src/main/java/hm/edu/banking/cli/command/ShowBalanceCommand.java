package hm.edu.banking.cli.command;

import hm.edu.banking.cli.service.BankingService;

/**
 * The ShowBalanceCommand class represents the command to show the balance of a specific bank
 * account. It extends the Command class and implements the execute method to perform the balance
 * retrieval operation.
 */
public class ShowBalanceCommand extends Command {

  /**
   * Constructor to initialize the ShowBalanceCommand with the provided BankingService.
   *
   * @param bankingService the BankingService used to retrieve the account balance
   */
  public ShowBalanceCommand(BankingService bankingService) {
    super(bankingService);
  }

  /**
   * Executes the command to retrieve and display the balance of the specified account. It takes an
   * account ID as a parameter, validates it, and fetches the balance from the BankingService.
   *
   * @param args the arguments for the command; expects the account ID as the first argument
   */
  @Override
  public void execute(String... args) {
    if (args.length < 1) {
      System.out.println("Usage: balance <accountId>");
      return;
    }

    try {
      int accountId = Integer.parseInt(args[0]);
      bankingService.printCurrentBalance(accountId);
    } catch (NumberFormatException e) {
      System.out.println("Invalid input. Please enter a valid account ID.");
    }
  }
}
