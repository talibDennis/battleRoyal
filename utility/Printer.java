package utility;

import warrior.*;
import weapon.*;
import armour.*;
import weather.*;
import stadium.*;

public class Printer {
  // ANSI escape codes
  public static final String RESET = "\u001B[0m";
  public static final String BLACK = "\u001B[30m"; // not really black
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String WHITE = "\u001B[37m";

  public static final String BG_BLACK = "\u001B[40m";
  public static final String BG_RED = "\u001B[41m";
  public static final String BG_GREEN = "\u001B[42m";
  public static final String BG_YELLOW = "\u001B[43m";
  public static final String BG_BLUE = "\u001B[44m";
  public static final String BG_PURPLE = "\u001B[45m";
  public static final String BG_CYAN = "\u001B[46m";
  public static final String BG_WHITE = "\u001B[47m";

  public Printer() {} // zero-arg contructor

    public void gameOver(String winner) {
    System.out.println("///////////////////////////////////////////");
    System.out.printf("// %s Wins the match awesome job!%n", winner);
    System.out.println("/////////////////////////////////////////");
  } // welcomeMessage()
  public void playAgainMenu() {
    System.out.println("///////////////////////////////////////////");
    System.out.println("// Play again?");
    System.out.println("// 1) Yes");
    System.out.println("// 2) No");
    System.out.println("/////////////////////////////////////////");
  } // playAgain()

  public void continueGameMenu() {
    System.out.println("///////////////////////////////////////////");
    System.out.println("// Continue Game?");
    System.out.println("// 1) Yes");
    System.out.println("// 2) No");
    System.out.println("/////////////////////////////////////////");
  } // continueGameMenu()

  public void stadiumMenu() {
    System.out.println("\nPick a Stadium:");
    System.out.printf("1) Ground%n");
    System.out.printf("2) Hill%n");
    System.out.printf("3) Sand%n");
  } // attackMenu()

  public void warriorMenu() {
    System.out.println("Pick a warrior:");
    System.out.printf("1) Human%n");
    System.out.printf("2) Elf%n");
    System.out.printf("3) Orc%n");
  } // printWarriorMenu()

  public void weaponMenu() {
    System.out.println("Pick a weapon:");
    System.out.printf("1) Dagger%n");
    System.out.printf("2) Sword%n");
    System.out.printf("3) Axe%n");
  } // printWeaponMenu()

  public void armourMenu() {
    System.out.println("Pick your armour:");
    System.out.printf("1) Leather%n");
    System.out.printf("2) Chainmail%n");
    System.out.printf("3) Platemail%n");
  } // printArmourMenu()

  public void playerStats(Warrior warrior, Weapon weapon, Armour armour) {
    System.out.printf("%nYou're a %s with a %s wearing %s%n.", 
      warrior.getWarriorType(), weapon.getWeaponType(), armour.getArmourType());
    System.out.printf("Health: %d%n", warrior.getHealth());
    System.out.printf("Strength: %d%n", warrior.getStrength());
    System.out.printf("Dexterity: %d%n", warrior.getDexterity());
  } // stats()

  public void enemyStats(Warrior warrior, Weapon weapon, Armour armour) {
    System.out.printf("%nYour enemy is a %s with a %s wearing %s%n.", 
      warrior.getWarriorType(), weapon.getWeaponType(), armour.getArmourType());
    System.out.printf("Health: %d%n", warrior.getHealth());
    System.out.printf("Strength: %d%n", warrior.getStrength());
    System.out.printf("Dexterity: %d%n", warrior.getDexterity());
  } // enemyStats()

  public void welcome(Weather weather, Stadium stadium) {
    System.out.println("///////////////////////////////////////////");
    System.out.println("// Welcome to Warsim 2025 Beta edition.");
    System.out.printf("// The stadium type is: %s!%n", stadium.getType());
    System.out.printf("// It's a %s day, good luck!%n", weather.getType());
    System.out.println("/////////////////////////////////////////");
  } // welcomeMessage()

  public void attackMenu() {
    System.out.println("\nPick an Attack:");
    System.out.printf("1) Light%n");
    System.out.printf("2) Heavy%n");
    System.out.printf("3) Save & Quit%n");
  } // attackMenu()

  public void attackResult(int damage, Warrior warrior, String who) {
    if(damage > 0) {
      System.out.printf(GREEN + "%n%s %s HITS for %d points!%n", who, warrior.getWarriorType(), damage);
      System.out.printf("%d health points removed!%n", damage);
      System.out.printf("%d health points remain!%n" + RESET, warrior.getHealth());
      System.out.println();
    }
    else {
      // System.out.println(RED + "This text is red!" + RESET);
      System.out.printf(RED + "%n%s %s MISSES!%n" + RESET, who, warrior.getWarriorType());
    }
  } // attackResult()
  
} // class