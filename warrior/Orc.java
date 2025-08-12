package warrior;

public class Orc extends Warrior {
  private int baseHealth = 120;
  private int bonusHealth = 90;
  private int baseStrength = 200; // 200 - 274
  private int bonusStrength = 75;
  private int baseDexterity = 30;
  private int bonusDexterity = 15;
  private String warriorType = "Orc";

  public Orc() {
    super(); // calls the parent contructor
    super.setHealth(super.randNum.nextInt(bonusHealth) + baseHealth);
    super.setStrength(super.randNum.nextInt(bonusStrength) + baseStrength);
    super.setDexterity(super.randNum.nextInt(bonusDexterity) + baseDexterity);
    super.setWarriorType(this.warriorType);
  } // constructor()

  public Orc(int health, int strength, int dexterity) {
    super(); // calls the parent contructor
    super.setHealth(health);
    super.setStrength(strength);
    super.setDexterity(dexterity);
    super.setWarriorType(this.warriorType);
  } // constructor()
  
} // class