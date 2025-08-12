package weather;

import java.util.Random;

public abstract class Weather {
  protected int dexterityCost;
  protected String type;
  protected Random randNum = new Random();

  public Weather() { } // constructor

  // getters
  public int getDexterityCost() {
    return this.dexterityCost;
  } // getDexterityCost()
  public String getType() {
    return this.type;
  } // getType()

  // setters
  public void setDexterityCost(int dexterityCost) {
    this.dexterityCost = dexterityCost;
  } // setDexterityCost()
  public void setType(String type) {
    this.type = type;
  } // setType
} // class