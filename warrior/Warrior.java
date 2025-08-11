package warrior;

import java.util.Random;

public abstract class Warrior {
    private String type;
    private int health; // the amount of health points, hit zero and you are defeated
    private int strength; // the strength you have, used for hit damage bonus
    private int dexterity; // skill: affects the chance to hit the opponent, higher dex = higher hit chance
    protected String warriorType;
    // private int hitChance = 65; 65% chance of getting hit

    protected Random randNum = new Random();

    public Warrior(String type) {
        this.type = type;
    } // constructor

    // getters
    public String getType() {
        return this.type;
    } // getType()
    public int getHealth() {
        if(this.health <= 0)
            return 0;
        else
            return this.health;
    } // getHealth()
    public int getStrength() {
        return this.strength;
    } // getStrength()
    public int getDexterity() {
        return this.dexterity;
    } // getDexterity()
    public String getWorriorType() {
        return this.warriorType;
    } // getWarriorType()
      public boolean isAlive() {
    if(this.health > 0)
      return true;
    else
      return false;
  } // isAlive()

    // setters
    // public void setType(String type) {
    public String setType() {
        return this.type;
    } // setType()
    public void setHealth(int health) {
        this.health = health;
    } // setHealth()

    public void setStrength(int strength) {
        this.strength = strength;
    } // setStrength()
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    } // setDexterity()
    public void setWorriorType(int worriorType) {
        this.warriorType = warriorType;
    } // setWorriorType()

    // take damage
    public void reduceHealth(float damageAmount) {
        this.health -= damageAmount;
    }
    
} // class