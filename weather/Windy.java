package weather;

public class Windy extends Weather {
  private int dexterityCost = randNum.nextInt(6) + 2; // 2 - 7
  private String type = "Windy";

  public Windy() {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

  public Windy(int dexterityCost) {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

} // class