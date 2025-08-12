package warrior;

public class Human extends Warrior { // extends is for inheritence
    private int minHealth = 75; // min amount a Human warrior starts with
    private int bonusHealth = 40; // the bonus or extra range for the health stat
    private int minStrength = 50;
    private int bonusStrength = 50;
    private int minDexterity = 50;
    private int bonusDexterity = 50;
    private String warriorType = "Human";

    public Human() { // new Human!
        super(); // calls the parent constructor
                                            // 50 (0 - 49) + 50
        super.setHealth(super.randNum.nextInt(this.bonusHealth) + this.minHealth);
        super.setStrength(super.randNum.nextInt(this.bonusStrength) + this.minStrength);
        super.setDexterity(super.randNum.nextInt(this.bonusDexterity) + this.minDexterity);
        super.setWarriorType(this.warriorType);
    } // constructor

    // restores a Human from saved file
    public Human(int health, int strength, int dexterity) {
        super(); // calls the parent constructor
        super.setHealth(health);
        super.setStrength(strength);
        super.setDexterity(dexterity);
        super.setWarriorType(this.warriorType);
    } // constructor

    // getters

    // setters

} // class
