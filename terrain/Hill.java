package terrain;

public class Hill extends Terrain {
  private int dexterityCost = randNum.nextInt(3) + 4; // 4 - 6
  private String type = "Hill";

  public Hill() {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

  public Hill(int dexterityCost) {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

} // class