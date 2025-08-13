import armour.*;
import terrain.*;
import utility.*;
import warrior.*;
import weapon.*;
import weather.*;
// who
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Battle {
  // object creation
  private static Printer print = new Printer();
  private static Validator validator = new Validator();
  // private static MusicPlayer musicPlayer = new MusicPLayer();
  private static Random randNum = new Random();
  private static Weather weather;
  private static Terrain terrain;
  private static Warrior player;
  private static Weapon pWeapon;
  private static Armour pArmour;
  private static Warrior enemy;
  private static Weapon eWeapon;
  private static Armour eArmour;

  // variables
  // private static boolean isPlayerTurn = true;
  private static boolean gameOver = false;
  private static String turn = "Player";
  private static String winner = "";
  private static String gameSave = "gameSave.txt";
  private static int choice;
  private static int damage;

  public static void main(String[] args) {
/*
    // Path to your audio file (must be .wav format)
    String musicFilePath = "T3_2025_04.wav";
        
    // Create a new thread to play music in the background
    Thread musicThread = new Thread(() -> musicPlayer.play(musicFilePath));
    musicThread.start();
*/
    gameSetup(); // creates combantants, weapons, armour, weather and terrain
    print.welcome(weather, terrain);

    //===================>>
    // Main Game Loop
    while(!gameOver) {
      if(turn == "Player") { // player turn logic/code
        choice = validator.validateAttackType();
        if(choice == 3) { // they want to save and quit
          saveGame();
          gameOver = true;
        }
        else {
          damage = pWeapon.strike(player, pWeapon, pArmour, choice, weather, terrain);
          damage -= eArmour.getArmourAmount();
          if(damage > 0) {
            enemy.takeDamage(damage);
            print.attackResult(damage, enemy, turn);
            if(!enemy.isAlive()) { // is enemy still kickin?
              gameOver = !gameOver;
              winner = "Player!";
              print.gameOver(winner);
            } // if
        }
      }
    } // player if
    else { // enemy turn logic code
      choice = randNum.nextInt(2) + 1;
      
      damage = eWeapon.strike(enemy, eWeapon, eArmour, choice, weather, terrain);
      damage -= pArmour.getArmourAmount();
      if(damage > 0) {
        player.takeDamage(damage);
        print.attackResult(damage, player, turn);
        if(!player.isAlive()) { // is player still kickin?
          gameOver = !gameOver;
          winner = "Enemy!";
          print.gameOver(winner);
        } // if
      } // if
      else {
        print.attackResult(damage, player, turn);
      }
      turn = "Player";
    } // enemy if
      // if the game has ended (gameOver = true)
      // ask if they would like to play again
      if (gameOver) {
        // ask them if they would like to play again?
        int answer = validator.validatePlayAgain();
        if(answer == 1) {
          resetGame();
          print.welcome(weather, terrain);
          print.playerStats(player, pWeapon, pArmour);
          print.enemyStats(enemy, eWeapon, eArmour);
        }
        else { // they said No to play again
          // do nothing
        }
      } // gameOver if
    } // while
  } // main()

  //====================>>
  // Helper methods
  private static void createWarrior(int wPick, String who) {
    switch (wPick) {
      case 1: // Human
        if(who == "Player")
          player = new Human();
        else 
          enemy = new Human();
        break;
      case 2: // Elf
        if(who == "Player")
          player = new Elf();
        else 
          enemy = new Elf();
        break;
      case 3: // Orc
        if(who == "Player")
          player = new Orc();
        else 
          enemy = new Orc();
        break;
      default:
        System.out.println("Select 1 - 4 only!");
        break;
    } // switch
  } // createWarrior()
  private static void createWeapon(int wPick, String who) {
    switch (wPick) {
      case 1: // Dagger
        if(who == "Player")
          pWeapon = new Dagger();
        else 
          eWeapon = new Dagger();
        break;
      case 2: // Elf
        if(who == "Player")
          pWeapon = new Sword();
        else 
          eWeapon = new Sword();
        break;
      case 3: // Orc
        if(who == "Player")
          pWeapon = new Axe();
        else 
          eWeapon = new Axe();
        break;
      default:
        System.out.println("Select 1 - 4 only!");
        break;
    } // switch
  } // createWarrior()
  private static void createArmour(int wPick, String who) {
    switch (wPick) {
      case 1: // Leather
        if(who == "Player")
          pArmour = new Leather();
        else 
          eArmour = new Leather();
        break;
      case 2: // Chainmail
        if(who == "Player")
          pArmour = new Chainmail();
        else 
          eArmour = new Chainmail();
        break;
      case 3: // Platemail
        if(who == "Player")
          pArmour = new Platemail();
        else 
          eArmour = new Platemail();
        break;
      default:
        System.out.println("Select 1 - 4 only!");
        break;
    } // switch
  } // createArmour()
  private static void createWeather(int weatherPick) {
    switch (weatherPick) {
      case 1: // Calm
          weather = new Calm();
        break;
      case 2: // Wind
          weather = new Windy();
        break;
      case 3: // Storm
          weather = new Stormy();
        break;
    } // switch
  } // createWeather()
  private static void createTerrain(int[] picks) {
    int pick = picks[randNum.nextInt(picks.length)];
    switch (pick) {
      case 1: // Ground
          terrain = new Ground();
        break;
      case 2: // Hill
          terrain = new Hill();
        break;
      case 3: // Sand
          terrain = new Sand();
        break;
    } // switch
  } // createTerrain()
  private static void gameSetup() {
    boolean newGame = true;
    // Reading from a file
    try (BufferedReader reader = new BufferedReader(new FileReader(gameSave))) {
      int selection = validator.validateContinueGame();

      if(selection == 1) {
        String line;
        int pos = 1;
        while ((line = reader.readLine()) != null) {
            // read in the line => 1, 1, 71, 63, 99
            recreateObject(pos, line);
            pos++; // increment the pos!!
        } // while
        print.playerStats(player, pWeapon, pArmour);
        print.enemyStats(enemy, eWeapon, eArmour);
        newGame = false;
      }
    } catch (IOException e) {
      System.out.println("No save game found " + e.getMessage());
    } finally {
      if(newGame) {
        makeGame();
      }
    }
  } // gameSetup()
  private static void makeGame() {
    // vote for a terrain
    int pTerrainPick = validator.validateTerrain();
    int eTerrainPick = randNum.nextInt(3) + 1;
    int[] picks = { pTerrainPick, eTerrainPick };
    createTerrain(picks);

    // randomize the weather
    int weatherPick = randNum.nextInt(3) + 1; // 1, 2, 3
    createWeather(weatherPick);

    // player objects
    // player warrior
    int wPick = validator.validateNumber("Warrior");
    createWarrior(wPick, turn);
    wPick = 0;
    
    // Player weapon
    wPick = validator.validateNumber("Weapon");
    createWeapon(wPick, turn);
    wPick = 0;

    // Player armour
    wPick = validator.validateNumber("Armour");
    createArmour(wPick, turn);
    wPick = 0;

    print.playerStats(player, pWeapon, pArmour);
    turn = "enemy"; // no longer players turn

    // Enemy Objects
    // Enemy warrior
    wPick = randNum.nextInt(3) + 1; // 1 - 3
    createWarrior(wPick, turn);

    // Enemy weapon
    wPick = randNum.nextInt(3) + 1; // 1 - 3
    createWeapon(wPick, turn);

    // Enemy armour
    wPick = randNum.nextInt(3) + 1; // 1 - 3
    createArmour(wPick, turn);

    print.enemyStats(enemy, eWeapon, eArmour);
    turn = "Player"; // back to the players turn
  } // makeGame()
  private static void resetGame() {
    // resetting all the needed objects and vars
    weather = null;
    terrain = null;
    player = null;
    enemy = null;
    pWeapon = null;
    eWeapon = null;
    pArmour = null;
    eArmour = null;

    gameOver = false;
    turn = "Player";
    winner = "";
    choice = 0;
    damage = 0;
    gameSetup();
  } // resetGame()
  private static void saveGame() {
    try (FileWriter writer = new FileWriter(gameSave)) {
      //==============>>
      // Warriors
      int warriorType = 0;
      String warriorName = player.getWarriorType();
      switch (warriorName) {
        case "Human":
          warriorType = 1;
        break;
        case "Elf":
          warriorType = 2;
        break;
        case "Orc":
          warriorType = 3;
        break;
      }
      writer.write(warriorType + ", ");
      writer.write(player.getHealth() + ", ");
      writer.write(player.getStrength() + ", ");
      writer.write(player.getDexterity() + "\n");

      warriorName = enemy.getWarriorType();
      switch (warriorName) {
        case "Human":
          warriorType = 1;
        break;
        case "Elf":
          warriorType = 2;
        break;
        case "Orc":
          warriorType = 3;
        break;
      }
      writer.write(warriorType + ", ");
      writer.write(enemy.getHealth() + ", ");
      writer.write(enemy.getStrength() + ", ");
      writer.write(enemy.getDexterity() + "\n");
      
      //==============>>
      // Weapons
      int weaponType = 0;
      String weaponName = pWeapon.getWeaponType();
      switch (weaponName) {
        case "Dagger":
          weaponType = 1;
        break;
        case "Sword":
          weaponType = 2;
        break;
        case "Axe":
          weaponType = 3;
        break;
      }
      writer.write(weaponType + ", ");
      writer.write(pWeapon.getDamageAmount() + ", ");
      writer.write(pWeapon.getDexterityCost() + "\n");
      
      weaponName = eWeapon.getWeaponType();
      switch (weaponName) {
        case "Dagger":
          weaponType = 1;
        break;
        case "Sword":
          weaponType = 2;
        break;
        case "Axe":
          weaponType = 3;
        break;
      }
      writer.write(weaponType + ", ");
      writer.write(eWeapon.getDamageAmount() + ", ");
      writer.write(eWeapon.getDexterityCost() + "\n");

      //==============>>
      // Armour
      int armourType = 0;
      String armourName = pArmour.getArmourType();
      switch (armourName) {
        case "Leather":
          armourType = 1;
        break;
        case "Chainmail":
          armourType = 2;
        break;
        case "Platemail":
          armourType = 3;
        break;
      }
      writer.write(armourType + ", ");
      writer.write(pArmour.getArmourAmount() + ", ");
      writer.write(pArmour.getDexterityCost() + "\n");
      
      armourName = eArmour.getArmourType();
      switch (armourName) {
        case "Leather":
          armourType = 1;
        break;
        case "Chainmail":
          armourType = 2;
        break;
        case "Platemail":
          armourType = 3;
        break;
      }
      writer.write(armourType + ", ");
      writer.write(eArmour.getArmourAmount() + ", ");
      writer.write(eArmour.getDexterityCost() + "\n");

      //================>>
      // terrain
      int terrainType = 0;
      String terrainName = terrain.getType();
      switch (terrainName) {
        case "Ground":
          terrainType = 1;
        break;
        case "Hill":
          terrainType = 2;
        break;
        case "Sand":
          terrainType = 3;
        break;
      }
      writer.write(terrainType + ", ");
      writer.write(terrain.getDexterityCost() + "\n");
      
      //================>>
      // Weather
      int weatherType = 0;
      String weatherName = weather.getType();
      switch (weatherName) {
        case "Calm😌 ":
          weatherType = 1;
        break;
        case "Windy🌬️ ":
          weatherType = 2;
        break;
        case "Stormy🌪️ ":
          weatherType = 3;
        break;
      }
      writer.write(weatherType + ", ");
      writer.write(weather.getDexterityCost() + "");
    } catch (IOException e) {
      System.out.println("An error occurred while writing to the file: " + e.getMessage());
    }
  } // saveGame()
  private static void recreateObject(int pos, String line) {
    String[] values = line.split(", "); // { 1, 77, 67, 99 }
    switch (pos) {
      case 1: // player
        switch (values[0]) {
          case "1": // human
            player = new Human(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]), 
              Integer.parseInt(values[3]));
            break;
          case "2": // elf
            player = new Elf(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]), 
              Integer.parseInt(values[3]));
            break;
          case "3": // orc
            player = new Orc(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]), 
              Integer.parseInt(values[3]));
            break;
          }
        break;
      case 2: // enemy
        switch (values[0]) {
          case "1": // human
            enemy = new Human(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]), 
              Integer.parseInt(values[3]));
            break;
          case "2": // elf
            enemy = new Elf(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]), 
              Integer.parseInt(values[3]));
            break;
          case "3": // orc
            enemy = new Orc(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]), 
              Integer.parseInt(values[3]));
            break;
          }
          break;
      case 3: // player weapon
        switch (values[0]) {
          case "1": // dagger
            pWeapon = new Dagger(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]));
            break;
          case "2": // sword
            pWeapon = new Sword(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]));
            break;
          case "3": // axe
            pWeapon = new Axe(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]));
            break;
          }
        break;
      case 4: // enemy weapon
        switch (values[0]) {
          case "1": // dagger
            eWeapon = new Dagger(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]));
            break;
          case "2": // sword
            eWeapon = new Sword(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]));
            break;
          case "3": // axe
            eWeapon = new Axe(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]));
            break;
          }
        break;
      case 5: // player armour
        switch (values[0]) {
          case "1": // leather
            pArmour = new Leather(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]));
            break;
          case "2": // chainmail
            pArmour = new Chainmail(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]));
            break;
          case "3": // platemail
            pArmour = new Platemail(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]));
            break;
          }
        break;
      case 6: // enemy armour
        switch (values[0]) {
          case "1": // leather
            eArmour = new Leather(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]));
            break;
          case "2": // chainmail
            eArmour = new Chainmail(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]));
            break;
          case "3": // platemail
            eArmour = new Platemail(
              Integer.parseInt(values[1]), 
              Integer.parseInt(values[2]));
            break;
          }
        break;
      case 7: // terrain
        switch (values[0]) {
          case "1": // ground
            terrain = new Ground(
              Integer.parseInt(values[1]));
            break;
          case "2": // hill
            terrain = new Hill(
              Integer.parseInt(values[1]));
            break;
          case "3": // sand
            terrain = new Sand(
              Integer.parseInt(values[1]));
            break;
          }
        break;
      case 8: // weather
        switch (values[0]) {
          case "1": // calm
            weather = new Calm(
              Integer.parseInt(values[1]));
            break;
          case "2": // windy
            weather = new Windy(
              Integer.parseInt(values[1]));
            break;
          case "3": // stormy
            weather = new Stormy(
              Integer.parseInt(values[1]));
            break;
          }
        break; 
    } // switch()
  } // recreateObject
} // Battle class