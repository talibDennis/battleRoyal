package terrain;

public class Sand extends Terrain {
  private int dexterityCost = randNum.nextInt(6) + 7; // 7 - 12
  private String type = "Sand";

  public Sand() {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

  public Sand(int dexterityCost) {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

} // class