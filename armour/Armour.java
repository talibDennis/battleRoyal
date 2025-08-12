package armour;

// library imports Random, Scanner yada yada

public abstract class Armour { // 'is-a' is inheritance Leather is-a Armour
  private int armourAmount;
  private int dexterityCost;
  private String armourType;

  public Armour() {} // constructor

  // getters or accessors
  public int getArmourAmount() {
    return this.armourAmount;
  } // getArmourAmount()
  public int getDexterityCost() {
    return this.dexterityCost;
  } // getDexterityCost()
  public String getArmourType() {
    return this.armourType;
  } // getArmourType()

  // setters or Mutators
  public void setArmourAmount(int armourAmount) {
    this.armourAmount = armourAmount;
  } // setArmourAmount()
  public void setDexterityCost(int dexterityCost) {
    this.dexterityCost = dexterityCost;
  } // setDexterityCost()
  public void setArmourType(String armourType) {
    this.armourType = armourType;
  } // setArmourType()

} // class