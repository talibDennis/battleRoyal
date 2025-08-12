package terrain;

public class Ground extends Terrain {
  private int dexterityCost = randNum.nextInt(3) + 1; //  1 2 3
  private String type = "Ground";

  public Ground() {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

  public Ground(int dexterityCost) {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

} // class