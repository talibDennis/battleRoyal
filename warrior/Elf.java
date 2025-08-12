package warrior;

public class Elf extends Warrior {
  private int baseHealth = 50;
  private int bonusHealth = 50;
  private int baseStrength = 40;
  private int bonusStrength = 30;
  private int baseDexterity = 90; // (0 - 74) + 90 => 90 - 163
  private int bonusDexterity = 75;
  private String warriorType = "Elf";

  public Elf() {
    super(); // calls the parent contructor
    super.setHealth(super.randNum.nextInt(bonusHealth) + baseHealth);
    super.setStrength(super.randNum.nextInt(bonusStrength) + baseStrength);
    super.setDexterity(super.randNum.nextInt(bonusDexterity) + baseDexterity);
    super.setWarriorType(this.warriorType);
  } // constructor()

  public Elf(int health, int strength, int dexterity) {
    super(); // calls the parent contructor
    super.setHealth(health);
    super.setStrength(strength);
    super.setDexterity(dexterity);
    super.setWarriorType(this.warriorType);
  } // constructor()
  
} // class