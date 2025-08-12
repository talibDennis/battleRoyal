package armour;

public class Chainmail extends Armour {
  private int armourAmount = 50;
  private int dexterityCost = 30;
  private String armourType = "Chainmail";

  public Chainmail() {
    super();
    super.setArmourAmount(armourAmount);
    super.setDexterityCost(dexterityCost);
    super.setArmourType(armourType);
  } // constructor

  public Chainmail(int armourAmount, int dexterityCost) {
    super();
    super.setArmourAmount(this.armourAmount);
    super.setDexterityCost(this.dexterityCost);
    super.setArmourType(this.armourType);
  } // constructor
  
} // class