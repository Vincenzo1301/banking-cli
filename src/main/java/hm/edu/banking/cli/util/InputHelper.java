package hm.edu.banking.cli.util;

import java.util.Scanner;

public class InputHelper {

  private static final Scanner scanner = new Scanner(System.in);

  public static int readInt() {
    while (!scanner.hasNextInt()) {
      System.out.print("Please enter a valid number: ");
      scanner.next();
    }
    return scanner.nextInt();
  }

  public static double readDouble() {
    while (!scanner.hasNextDouble()) {
      System.out.print("Please enter a valid number: ");
      scanner.next();
    }
    return scanner.nextDouble();
  }

  public static String readString() {
    while (!scanner.hasNext()) {
      System.out.print("Please enter a valid string: ");
      scanner.next();
    }
    return scanner.next();
  }
}
