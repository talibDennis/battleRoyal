package weapon;

import armour.Armour;
import stadium.Stadium;
import warrior.Warrior;
import weather.Weather;

public class Sword extends Weapon {
  private int damageAmount = 100;
  private int dexterityCost = 40;

  public Sword() {
    super();
    super.setDamageAmount(damageAmount);
    super.setDexterityCost(dexterityCost);
    super.setWeaponType("Sword");
  } // constructor()

  public Sword(int damageAmount, int dexterityCost) {
    super(); // must be the first line!
    super.setDamageAmount(damageAmount);
    super.setDexterityCost(dexterityCost);
    super.setWeaponType("Sword");
  } // constructor()

  public int strike(Warrior warrior, Weapon weapon, Armour armour, 
    int attackType, Weather weather, Stadium stadium) {
    int hitTarget = 57;
    int attackScalar = 4;
    int damage = 0;
    int roll = randNum.nextInt(100) + 1; // 1 - 100
    int damageBonus = warrior.getStrength() / (randNum.nextInt(4) + 7) + (attackScalar * attackType); // BONUS to damage
    
    hitTarget -= warrior.getDexterity() / 10; // BONUS to hitTarget
    hitTarget += armour.getDexterityCost() / 7; // COST to hitTarget
    hitTarget += weapon.getDexterityCost() / 7; // COST to hitTarget
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