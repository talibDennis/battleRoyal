package weapon;

import armour.Armour;
import terrain.Terrain;
import warrior.Warrior;
import weather.Weather;

public class Dagger extends Weapon {
  private int damageAmount = 50;
  private int dexterityCost = 10;

  public Dagger() {
    super(); // must be the first line!
    super.setDamageAmount(damageAmount);
    super.setDexterityCost(dexterityCost);
    super.setWeaponType("Dagger");
  } // constructor()

  public Dagger(int damageAmount, int dexterityCost) {
    super(); // must be the first line!
    super.setDamageAmount(damageAmount);
    super.setDexterityCost(dexterityCost);
    super.setWeaponType("Dagger");
  } // constructor()

  public int strike(Warrior warrior, Weapon weapon, Armour armour, 
    int attackType, Weather weather, Terrain stadium) {
    int hitTarget = 45;
    int attackScalar = 2;
    int damage = 0;
    int roll = randNum.nextInt(100) + 1; // 1 - 100
    int damageBonus = warrior.getStrength() / (randNum.nextInt(4) + 7) + (attackScalar * attackType); // BONUS to damage
    
    hitTarget -= warrior.getDexterity() / 7; // BONUS to hitTarget
    hitTarget += armour.getDexterityCost() / 13; // COST to hitTarget
    hitTarget += weapon.getDexterityCost() / 13; // COST to hitTarget
    hitTarget += weather.getDexterityCost() / 15; // COST to hitTarget
    hitTarget += stadium.getDexterityCost() / 15; // COST to hitTarget

    if(roll >= hitTarget) { // strike is a success!
      damage = weapon.getDamageAmount() + damageBonus; // 50 + 17 = 67
    }
    else { // miss
      damage = 0;
    }
    return damage;
  } // strike()
} // class