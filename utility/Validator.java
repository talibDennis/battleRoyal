package utility;

import java.util.Scanner;

public class Validator {
  Scanner input = new Scanner(System.in);
  int choice = 0;

  // constructor
  public Validator() {} // zero-arg constructor

  public int validatePick(int maxVal) {
    choice = 0;

    while (true) {
      System.out.printf("Enter a number between 1 & %d:%n", maxVal);
      try { // wraps code that can break
        choice = Integer.parseInt(input.nextLine());

        if (choice >= 1 && choice <= maxVal) {
          System.out.println("You entered: " + choice);
          break; // valid input, exit loop
        } else {
          System.out.printf("Invalid number. Please enter a number between 1 & %d%n", + maxVal);
        }
      } // try
      catch (NumberFormatException e) { // runs only on error
        System.out.println("That's not a valid number. Please try again.");
      } // catch
      finally { // always runs!
        // do nothing
      }
    } // while

    return choice;
  } // validate()

  public int validateAttackPick(int maxVal) {
    choice = 0;

    while (true) {
      System.out.printf("Enter a number between 1 & %d:$n", maxVal);
      try {
        choice = Integer.parseInt(input.nextLine());

        if (choice >= 1 && choice <= maxVal) {
          System.out.println("You entered: " + choice);
          break; // valid input, exit loop
        } else {
          System.out.printf("Invalid number. Please enter from 1 to %d%n", maxVal);
        }
      } // try
      catch (NumberFormatException e) {
        System.out.println("That's not a valid number. Please try again.");
      } // catch
    } // while

    return choice;
  } // validate()

} // class