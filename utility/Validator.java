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

  public int validateAttackType() {
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

  public int validateStadium() {
    boolean isValid = false;
    print.stadiumMenu();

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