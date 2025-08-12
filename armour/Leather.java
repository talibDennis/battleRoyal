package armour;

public class Leather extends Armour {
  private int armourAmount = 10;
  private int dexterityCost = 5;
  private String armourType = "Leather";

  public Leather() {
    super();
    super.setArmourAmount(this.armourAmount);
    super.setDexterityCost(this.dexterityCost);
    super.setArmourType(this.armourType);
  } // constructor

  public Leather(int armourAmount, int dexterityCost) {
    super();
    super.setArmourAmount(this.armourAmount);
    super.setDexterityCost(this.dexterityCost);
    super.setArmourType(this.armourType);
  } // constructor
} // class