
package warrior;

public class Elf extends Warrior {
    private int minHealth = 240; // min amount a Elf warrior starts with
    private int bonusHealth = 50; // the bonus or extra range for the health stat
    private int minStrength = 70;
    private int bonusStrength = 20;
    private int minDexterity = 150;
    private int bonusDexterity = 75;

    public Elf() {
        super("Elf");
        // 0 - 79 + 120 = 120 to 179
        super.setHealth(super.randNum.nextInt(this.bonusHealth) + this.minHealth);
        super.setStrength(super.randNum.nextInt(this.bonusStrength) + this.minStrength);
        super.setDexterity(super.randNum.nextInt(this.bonusDexterity) + this.minDexterity);
    } // contructor

    // getters

    // setters

} // class
