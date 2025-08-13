package weather;

public class Stormy extends Weather {
  private int dexterityCost = randNum.nextInt(11) + 10; // 10 - 20
  private String type = "Stormy🌪️ ";

  public Stormy() {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

  public Stormy(int dexterityCost) {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

} // class