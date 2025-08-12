package weather;

public class Wind extends Weather {
  private int dexterityCost = randNum.nextInt(6) + 2; // 2 - 7
  private String type = "Wind";

  public Wind() {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

  public Wind(int dexterityCost) {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

} // class