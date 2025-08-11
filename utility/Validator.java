package utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
  private Printer print = new Printer();
  private Scanner input = new Scanner(System.in);
  private int number = 0;
  int choice = 0;

  // constructor
  // public Validator() {} // zero-arg constructor
  public int validateNumber(String type) {
    boolean isValid = false;

    // Print the relavent menu first
    if(type == "Warrior") {
      print.warriorMenu();
    } else if (type == "Weapon") {
      print.weaponMenu();
    } else {
      print.armourMenu();
    }

  /*public int validatePick(int maxVal) {
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
  } // validate()*/
    //----------------------------------------------
    while(!isValid) {
      try {
        number = input.nextInt();
        // Range validation
        if (number < 1 || number > 3) {
          throw new IllegalArgumentException("Number is out of the valid range (1-3).");
        }
        isValid = true;
      } // try
      catch (InputMismatchException e) {
        System.out.println("Error: Invalid input. Please enter an integer.");
        input.nextLine();
      } // input mismatch catch
      catch (IllegalArgumentException elivs) {
        System.out.println("Error: " + elivs.getMessage());
      } // illegal arg catch
      finally { // finally always runs!
        if (!isValid) {
          System.out.println("Please try again with valid input.");
        }
      } // finally
    } // while()
    return number;
  } // validateNumer()

  public int validateAttackPick(int maxVal) {
    boolean isValid = false;
    print.attackMenu();

    while(!isValid) {
      try {
        number = input.nextInt();
        // Range validation
        if(number < 1 || number > 3) {
          throw new IllegalArgumentException("Number is out of the valid range (1-3).");
        }
        isValid = true;
      } // try
      catch (InputMismatchException e) {
        System.out.println("Error: Invalid input. Please enter an integer.");
        input.nextLine();
      } // input mismatch catch
      catch (IllegalArgumentException elvis) {
        System.out.println("Error: " + elvis.getMessage());
      } // illegal arg catch
      finally { // finally always runs!
        if (!isValid) {
          System.out.println("Please try again with a valid input.");
        }
      } // finally
    } // while()

    return number;
  } // validate()

  public int validatePlayAgain() {
    boolean isValid = false;
    print.playAgainMenu();

    while(!isValid) {
      try {
        number = input.nextInt();
        // Range validation
        if (number < 1 || number > 2) {
          throw new IllegalArgumentException("Number is out of the valid range (1-2).");
        }
        isValid = true;
      } // try
      catch (InputMismatchException e) {
        System.out.println("Error: Invalid input. Please enter an integer.");
        input.nextLine();
      } // input mismatch catch
      catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
      } // illegal arg catch
      finally { // finally always runs!
        if (!isValid) {
          System.out.println("Please try again with valid input.");
        }
      } // finally
    } // while()
    return number;
  } // validatePlayAgain()

  public int validateContinueGame() {
    boolean isValid = false;
    print.continueGameMenu();

    while(!isValid) {
      try {
        number = input.nextInt();
        // Range validation
        if (number < 1 || number > 2) {
          throw new IllegalArgumentException("Number is out of the valid range (1-2).");
        }
        isValid = true;
      } // try
      catch (InputMismatchException e) {
        System.out.println("Error: Invalid input. Please enter an integer.");
        input.nextLine();
      } // input mismatch catch
      catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
      } // illegal arg catch
      finally { // finally always runs!
        if (!isValid) {
          System.out.println("Please try again with valid input.");
        }
      } // finally
    } // while()
    return number;
  } // validateContinueGame()

} // class