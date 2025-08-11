package armour;

public class Platemail extends Armour {
  // should be a calc with damage NOT a straight protection amount
  private int protectionAmount = 60; // calc a damage of 60%
  private int dexCost = 65;
  private int armourDurabilityFactor = 15;

  public Platemail() {
    super("Platemail");
    super.setProtectionAmount(protectionAmount);
    super.setDexCost(dexCost);
  } // constructor

  // setters
  public void setArmourReduction(int damageAmount) {
    // 10 damage would take away 1 armour points
    this.protectionAmount -= damageAmount / armourDurabilityFactor;
  }

} // class