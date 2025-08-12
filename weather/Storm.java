package weather;

public class Storm extends Weather {
  private int dexterityCost = randNum.nextInt(11) + 10; // 10 - 20
  private String type = "Storm";

  public Storm() {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

  public Storm(int dexterityCost) {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

} // class