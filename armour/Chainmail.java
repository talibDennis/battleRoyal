package armour;

public class Chainmail extends Armour {
  private int protectionAmount = 40; // 40% reduction
  private int dexCost = 35;
  private int armourDurabilityFactor = 12;

  public Chainmail() {
    super("Chainmail");
    super.setProtectionAmount(protectionAmount);
    super.setDexCost(dexCost);
  } // constructor

  // setters
  public void setArmourReduction(int damageAmount) {
    // 10 damage takes away 1 armour points
    this.protectionAmount -= damageAmount / armourDurabilityFactor;
  }
  
} // class