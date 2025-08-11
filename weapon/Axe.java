package weapon;

public class Axe extends Weapon {
    private int baseDamage = 90;
    private int dexCost = 50;
    private int hitChance = 40;

    public Axe() {
        super("Axe");
        super.setBaseDamage(baseDamage);
        super.setDexCost(dexCost);
    } // constructor

    // strike method
  public int strike(int attackType, int strength, int dexterity, int aDexCost) {
    int damageAmount = 0;
    int roll = super.randNum.nextInt(100) + 1; // 1 - 100
    roll += attackType * super.FACTOR_5; // hit chance REDUCED
    roll -= dexterity / super.FACTOR_10; // hit chance INCREASED based on player dexterity
    roll += aDexCost / super.FACTOR_10; // hit chance REDUCED based on the weight of the armour

    if(roll <= this.hitChance) { // hit
      damageAmount = this.baseDamage + super.randNum.nextInt(strength / super.FACTOR_5);
    }

    return damageAmount;
  } // strike{}
} // class
