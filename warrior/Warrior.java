package warrior;

import java.util.Random;

// an abstract class protects the class
// from being directly instantiated!
public abstract class Warrior {
    private int health; // the amount of health points, hit zero and you are defeated
    private int strength; // the strength you have, used for hit damage bonus
    private int dexterity; // skill: affects the chance to hit the opponent, higher dex = higher hit chance
    protected String warriorType;
    protected Random randNum = new Random();
    // private int hitChance = 65; 65% chance of getting hit
    
    public Warrior() {
    } // constructor

    // getters
    public int getHealth() {
        return this.health;
    } // getHealth()
    public int getStrength() {
        return this.strength;
    } // getStrength()
    public int getDexterity() {
        return this.dexterity;
    } // getDexterity()
    public String getWarriorType() {
        return this.warriorType;
    } // getWarriorType()
      public boolean isAlive() {
    if(this.health > 0)
      return true;
    else
      return false;
  } // isAlive()

    // setters
    public void setHealth(int health) {
        this.health = health;
    } // setHealth()
    public void setStrength(int strength) {
        this.strength = strength;
    } // setStrength()
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    } // setDexterity()
    public void setWarriorType(String warriorType) {
        this.warriorType = warriorType;
    } // setWorriorType()
    public void takeDamage(int damageAmount) {
        if (damageAmount > 0)
        this.health -= damageAmount;
    } // takeDamage()
    
} // class