package armour;

public class Platemail extends Armour {
  private int armourAmount = 100;
  private int dexterityCost = 70;
  private String armourType = "Platemail";

  public Platemail() {
    super();
    super.setArmourAmount(armourAmount);
    super.setDexterityCost(dexterityCost);
    super.setArmourType(armourType);
  } // constructor

  public Platemail(int armourAmount, int dexterityCost) {
    super();
    super.setArmourAmount(this.armourAmount);
    super.setDexterityCost(this.dexterityCost);
    super.setArmourType(this.armourType);
  } // constructor
} // class