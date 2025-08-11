package warrior;

public class Orc extends Warrior {
    private int minHealth = 350; // min amount a Orc warrior starts with
    private int bonusHealth = 90; // the bonus or extra range for the health stat
    private int minStrength = 120;
    private int bonusStrength = 70;
    private int minDexterity = 20;
    private int bonusDexterity = 10;

    public Orc() {
        super("Orc");
        // 0 - 99 + 180 = 180 to 279
        super.setHealth(super.randNum.nextInt(this.bonusHealth) + this.minHealth);
        super.setStrength(super.randNum.nextInt(this.bonusStrength) + this.minStrength);
        super.setDexterity(super.randNum.nextInt(this.bonusDexterity) + this.minDexterity);
    } // contructor

    // getters

    // setters

} // class