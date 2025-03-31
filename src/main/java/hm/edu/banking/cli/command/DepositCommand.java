package hm.edu.banking.cli.command;

import hm.edu.banking.cli.service.BankingService;

/**
 * This class represents a command to deposit money into an account. It extends the abstract Command
 * class and provides the implementation of the execute method to perform the deposit operation.
 *
 * <p>The command expects two arguments: account ID and deposit amount. If the arguments are valid,
 * the deposit operation is performed using the BankingService.
 */
public class DepositCommand extends Command {

  /**
   * Constructs a DepositCommand instance with the given BankingService.
   *
   * @param bankingService the BankingService object used to perform banking operations
   */
  public DepositCommand(BankingService bankingService) {
    super(bankingService);
  }

  /**
   * Executes the deposit command. This method expects two arguments: the account ID and the amount
   * to deposit. If the arguments are valid, it calls the BankingService to deposit the amount into
   * the account. If the input is invalid, it prints an error message.
   *
   * @param args the command arguments, where args[0] is the account ID and args[1] is the deposit
   *     amount
   */
  @Override
  public void execute(String... args) {
    if (args.length < 2) {
      System.out.println("Usage: deposit <accountId> <amount>");
      return;
    }

    try {
      int accountId = Integer.parseInt(args[0]);
      double amount = Double.parseDouble(args[1]);

      bankingService.deposit(accountId, amount);
      System.out.println("Deposited " + amount + " into account " + accountId);
    } catch (NumberFormatException e) {
      System.out.println("Invalid input. Please enter a valid account ID and amount.");
    }
  }
}
