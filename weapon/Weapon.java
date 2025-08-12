package weapon;

import armour.*;
import stadium.*;
import warrior.*;
import weather.*;
import java.util.Random;

public abstract class Weapon {
  protected int damageAmount; // the base amount the weapon can do
  protected int dexterityCost; // the cost to the players dexterity
  protected Random randNum = new Random();
  protected String weaponType;

  public Weapon(String type) {
    this.type = type;
  } // constructor

  // getters
  public String getType() {
    return this.type;
  } 
  public int getBaseDamage() {
    return this.baseDamage;
  }
  public int getDexCost() {
    return this.dexCost;
  }
  // poloymorphic strike method
  public abstract int strike(int attackType, int strength, int dexterity, int aDexCost);

  // setters
  public void setType(String type) {
    this.type = type;
  } 
  public void setBaseDamage(int baseDamage) {
    this.baseDamage = baseDamage;
  }
  public void setDexCost(int dexCost) {
    this.dexCost = dexCost;
  }

} // class
