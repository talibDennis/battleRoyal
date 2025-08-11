package weapon;

public class Sword extends Weapon {
  private int baseDamage = 50;
  private int baseDexterityCost = 25;
  private int hitChance = 60;

  public Sword() {
    super("Sword");
    super.setBaseDamage(baseDamage);
    super.setDexCost(baseDexterityCost);
  } // constructor

  // strike method
  public int strike(int attackType, int strength, int dexterity, int aDexCost) {
    int damageAmount = 0;
    int roll = super.randNum.nextInt(100) + 1; // 1 - 100
    roll += attackType * super.FACTOR_5; // hit chance REDUCED
    roll -= dexterity / super.FACTOR_10; // hit change INCREASED based on player dexterity
    roll += aDexCost / super.FACTOR_10; // hit chance REDUCED based on the weight of the armour
    
    // System.out.println("Roll: " + roll);
    // System.out.printf("%nHitChance: %d Roll: %d%n", this.hitChance, roll);
    
    if(roll <= this.hitChance) { // hit
      damageAmount = this.baseDamage + super.randNum.nextInt(strength / super.FACTOR_5);
      // System.out.println("Damage: " + damageAmount);
      // System.out.println("Actual damage is " + damageAmount);
    }
    else { // miss
      // do nothing
    }

    return damageAmount;
  } // strike{}
  
} // class