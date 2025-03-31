package hm.edu.banking.cli.command;

import hm.edu.banking.cli.service.BankingService;

import java.util.HashMap;
import java.util.Map;

/**
 * The CommandFactory class is responsible for creating and managing the available commands for the
 * banking application. It stores the mapping of command names to their corresponding Command
 * objects and provides a method to retrieve a specific command based on its name.
 *
 * <p>This factory pattern allows for easy extension and modification of commands without changing
 * the core logic of the application. The available commands include deposit, balance, and withdraw.
 */
public class CommandFactory {

  /**
   * A map that holds the available commands, where the key is the command name and the value is the
   * corresponding Command object.
   */
  private final Map<String, Command> commands = new HashMap<>();

  /**
   * Constructs a CommandFactory with the given BankingService. Initializes the available commands
   * (deposit, balance, and withdraw).
   *
   * @param bankingService the BankingService object used to perform banking operations in the
   *     commands
   */
  public CommandFactory(BankingService bankingService) {
    commands.put("deposit", new DepositCommand(bankingService));
    commands.put("balance", new ShowBalanceCommand(bankingService));
    commands.put("withdraw", new WithdrawCommand(bankingService));
  }

  /**
   * Retrieves the command associated with the given command name.
   *
   * @param commandName the name of the command to retrieve
   * @return the corresponding Command object, or null if the command name is not recognized
   */
  public Command getCommand(String commandName) {
    return commands.get(commandName);
  }
}
