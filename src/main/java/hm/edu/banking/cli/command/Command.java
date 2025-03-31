package hm.edu.banking.cli.command;

import hm.edu.banking.cli.service.BankingService;

/**
 * The Command class serves as an abstract base class for all commands in the banking system. Each
 * command represents a specific action (such as deposit, withdraw, or show balance) that can be
 * executed by the bank machine. Concrete subclasses must implement the execute method.
 */
public abstract class Command {

  /** The BankingService instance used by the command to perform banking operations. */
  protected final BankingService bankingService;

  /**
   * Constructor to initialize the Command with the BankingService.
   *
   * @param bankingService the BankingService used to perform banking operations
   */
  protected Command(BankingService bankingService) {
    this.bankingService = bankingService;
  }

  /**
   * Executes the command with the provided arguments. Each command implements this method to
   * perform its specific action.
   *
   * @param args the arguments needed for the command execution (such as account ID and amount)
   */
  public abstract void execute(String... args);
}
