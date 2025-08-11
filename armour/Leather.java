package armour;

public class Leather extends Armour {
  private int protectionAmount = 20;
  private int dexCost = 5;
  private int armourDurabilityFactor = 10;

  public Leather() {
    super("Leather");
    super.setProtectionAmount(protectionAmount);
    super.setDexCost(dexCost);
  } // constructor

  // setters
  public void setArmourReduction(int damageAmount) {
    // 10 damage would take away 1 armour points
    this.protectionAmount -= damageAmount / armourDurabilityFactor;
  }

} // class