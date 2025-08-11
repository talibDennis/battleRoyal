package armour;

public abstract class Armour {
  private String type;
  private int protectionAmount;
  private int dexCost;

  public Armour(String type) {
    this.type = type;
  } // constructor

  // getters
  public String getType() {
    return this.type;
  }
  public int getProtectionAmount() {
    return this.protectionAmount;
  }
  public int getDexCost() {
    return this.dexCost;
  }

  // setters
  public void setType(String type) {
    this.type = type;
  }
  public void setProtectionAmount(int protectionAmount) {
    this.protectionAmount = protectionAmount;
  }
  public void setDexCost(int dexCost) {
    this.dexCost = dexCost;
  }
  // public abstract void setArmourReduction(int damageAmount);

} // class