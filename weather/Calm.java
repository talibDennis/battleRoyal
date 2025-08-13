package weather;

public class Calm extends Weather {
  private int dexterityCost = randNum.nextInt(3) + 1; // 1 2 3
  private String type = "Calm😌 ";

  public Calm() {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // constructor

  public Calm(int dexterityCost) {
    super();
    super.setDexterityCost(this.dexterityCost);
    super.setType(this.type);
  } // construtor

} // class