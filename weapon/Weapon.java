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

  public Weapon() {} // constructor()

  // getters
  public int getDamageAmount() {
    return this.damageAmount;
  } // getDamageAmount()
  public int getDexterityCost() {
    return this.dexterityCost;
  } // getDexterityCost()
  public String getWeaponType() {
    return this.weaponType;
  } // getWeaponType()
 
  // setters
  public void setDamageAmount(int damageAmount) {
    this.damageAmount = damageAmount;
  } // setDamageAmount()
  public void setDexterityCost(int dexterityCost) {
    this.dexterityCost = dexterityCost;
  } // setDexterityCost()
  public void setWeaponType(String weaponType) {
    this.weaponType = weaponType;
  } // setWeaponType()

   // poloymorphic strike method
  public abstract int strike(Warrior warrior, Weapon weapon, Armour armour, int attackType, Weather weather, Stadium stadium);

} // class
