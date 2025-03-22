package hm.edu.banking.cli.util;

import java.util.Scanner;

/**
 * The InputHelper class provides utility methods for reading user input from the console. It
 * ensures that the input is of the correct type (int, double, or String) and prompts the user to
 * re-enter the input if it is invalid.
 */
public class InputHelper {

  /** A scanner object used to read input from the console. */
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Reads an integer value from the user input.
   *
   * <p>If the input is not a valid integer, the user is prompted to enter a valid number.
   *
   * @return the valid integer entered by the user
   */
  public static int readInt() {
    while (!scanner.hasNextInt()) {
      System.out.print("Please enter a valid number: ");
      scanner.next();
    }
    return scanner.nextInt();
  }

  /**
   * Reads a double value from the user input.
   *
   * <p>If the input is not a valid double, the user is prompted to enter a valid number.
   *
   * @return the valid double entered by the user
   */
  public static double readDouble() {
    while (!scanner.hasNextDouble()) {
      System.out.print("Please enter a valid number: ");
      scanner.next();
    }
    return scanner.nextDouble();
  }

  /**
   * Reads a string value from the user input.
   *
   * <p>If the input is not a valid string, the user is prompted to enter a valid string.
   *
   * @return the valid string entered by the user
   */
  public static String readString() {
    while (!scanner.hasNext()) {
      System.out.print("Please enter a valid string: ");
      scanner.next();
    }
    return scanner.next();
  }
}
