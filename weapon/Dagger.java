package weapon;

public class Dagger extends Weapon {
    private int baseDamage = 25;
    private int dexCost = 5;
    private int hitChance = 80; // need to roll below this target!

    public Dagger() {
        super("Dagger");
        super.setBaseDamage(baseDamage);
        super.setDexCost(dexCost);
    } // constructor

    // strike method
    public int strike(int attackType, int strength, int dexterity, int aDexCost) {
        int damageAmount = 0;
        int roll = super.randNum.nextInt(100) + 1; // 1 - 100
        roll += attackType * super.FACTOR_5; // hit chance REDUCED
        roll -= dexterity / super.FACTOR_10; // hit change INCREASED based on player dexterity
        roll += aDexCost / super.FACTOR_10;  // hit chance REDUCED based on the weight of the armour

        if(roll <= this.hitChance) { // hit!
            damageAmount = this.baseDamage + super.randNum.nextInt(strength / super.FACTOR_5);
        }

        // can be different in many many ways!

        return damageAmount;
    } // strike

} // class