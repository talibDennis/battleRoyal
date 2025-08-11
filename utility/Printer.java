package utility;

import warrior.*;
import weapon.*;
import armour.*;

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

  public void welcome() {
    System.out.println("///////////////////////////////////");
    System.out.println(BLUE + "///// Welcome to Warsim 2025! /////");
    System.out.println(WHITE + "///////////////////////////////////\n" + RESET);
  } // welcome

  public void goodbye() {
    System.out.println(YELLOW + "\n*********************************");
    System.out.println(PURPLE + "///// Thank you for playing!! /////");
    System.out.println(YELLOW + "***********************************\n" + RESET);
  } // goodbye

  public void printStats(Warrior player, Weapon pWeapon, Armour pArmour,
    Warrior enemy, Weapon eWeapon, Armour eArmour) {
    System.out.println("/////////////////////////////");
    System.out.printf("/// %s(%s) Stats:%n", "Player ", player.getType());
    System.out.printf("/// " + BLUE + "Armour:    %s%n" + RESET, pArmour.getType());
    System.out.printf("/// Weapon:    %s%n", pWeapon.getType());
    System.out.printf("/// Health:    %12d%n", player.getHealth());
    System.out.printf("/// Strength:  %12d%n", player.getStrength());
    System.out.printf("/// Dexterity: %12d%n", player.getDexterity());
    System.out.println("/////////////////////////////\n");
    System.out.printf("/// %s(%s) Stats:%n", "Enemy ", enemy.getType());
    System.out.printf("/// Armour:    %s%n", eArmour.getType());
    System.out.printf("/// Weapon:    %s%n", eWeapon.getType());
    System.out.printf("/// Health:    %12d%n", enemy.getHealth());
    System.out.printf("/// Strength:  %12d%n", enemy.getStrength());
    System.out.printf("/// Dexterity: %12d%n", enemy.getDexterity());
    System.out.println("/////////////////////////////\n");
  } // printStats()

  public void printResults(String who, int damage, Warrior warrior) {
    System.out.println("/////////////////////////////////////////////////");
    if(who.equals("Player")) {
      if(damage > 0) {
        System.out.printf("/// %s does %d points of damage leaving%n/// enemy with %d points left...%n", 
        who, damage, warrior.getHealth());
      }
      else {
        System.out.printf("/// %s misses enemy still has %d%n", 
        who, warrior.getHealth());
      }
    }
    else {
      if(damage > 0) {
        System.out.printf("/// %s does %d points of damage leaving%n/// player with %d points left...%n", 
        who, damage, warrior.getHealth());
      }
      else {
        System.out.printf("/// %s misses player still has %d%n", 
        who, warrior.getHealth());
      }
    }
    System.out.println("/////////////////////////////////////////////////\n");
  }

  public void attackResult(float damage, Warrior warrior, String who) {
    if(damage > 0) {
      System.out.printf(GREEN + "%s %s deals %.0f points of damage!%n", who, warrior.getType(), damage);
      System.out.printf("%.0f health points removed!%n", damage);
      System.out.printf("Remaining health points %d!%n" + RESET, warrior.getHealth());
      System.out.println();
    }
    else {
      // System.out.println(RED + "This text is red!" + RESET);
      System.out.printf(RED + "%n%s %s MISSES!%n%n" + RESET, who, warrior.getType());
    }
  } // attackResult()

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

  public void warriorMenu() {
    System.out.println("/////////////////////////////");
    System.out.println("/// Select your warrior: ");
    System.out.println("/// 1) Orc");
    System.out.println("/// 2) Elf");
    System.out.println("/// 3) Human");
    System.out.println("/////////////////////////////\n");
  } // warriorMenu()

  public void weaponMenu() {
    System.out.println("/////////////////////////////");
    System.out.println("/// Select your weapon: ");
    System.out.println("/// 1) Dagger");
    System.out.println("/// 2) Sword");
    System.out.println("/// 3) Axe");
    System.out.println("/////////////////////////////\n");
  } // weaponMenu()

  public void armourMenu() {
    System.out.println("/////////////////////////////");
    System.out.println("/// Select your armour: ");
    System.out.println("/// 1) Leather");
    System.out.println("/// 2) Chainmail");
    System.out.println("/// 3) Platemail");
    System.out.println("/////////////////////////////\n");
  } // armourMenu()

  public void attackMenu() {
    System.out.println("/////////////////////////////");
    System.out.println("/// Select your attack: ");
    System.out.println("/// 1) Normal");
    System.out.println("/// 2) Heavy");
    System.out.println("/////////////////////////////\n");
  } // attackMenu()
  
} // class