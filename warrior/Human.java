package warrior;

public class Human extends Warrior { // extends is for inheritence
  private int baseHealth = 75;
  private int bonusHealth = 75;
  private int baseStrength = 50;
  private int bonusStrength = 50;
  private int baseDexterity = 50;
  private int bonusDexterity = 50;
  private String warriorType = "Human";

  public Human() {
    super(); // calls the parent contructor
                                         // 50 (0 - 49) + 50
    super.setHealth(super.randNum.nextInt(bonusHealth) + baseHealth);
    super.setStrength(super.randNum.nextInt(bonusStrength) + baseStrength);
    super.setDexterity(super.randNum.nextInt(bonusDexterity) + baseDexterity);
    super.setWarriorType(this.warriorType);
  } // constructor()

  public Human(int health, int strength, int dexterity) {
    super(); // calls the parent contructor
    super.setHealth(health);
    super.setStrength(strength);
    super.setDexterity(dexterity);
    super.setWarriorType(this.warriorType);
  } // constructor()
  
} // class