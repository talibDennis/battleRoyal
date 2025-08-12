package weapon;

import armour.Armour;
import terrain.Terrain;
import warrior.Warrior;
import weather.Weather;

public class Axe extends Weapon {
  private int damageAmount = 180;
  private int dexterityCost = 80;

  public Axe() {
    super();
    super.setDamageAmount(damageAmount);
    super.setDexterityCost(dexterityCost);
    super.setWeaponType("Axe");
  } // constructor()

  public Axe(int damageAmount, int dexterityCost) {
    super(); // must be the first line!
    super.setDamageAmount(damageAmount);
    super.setDexterityCost(dexterityCost);
    super.setWeaponType("Axe");
  } // constructor()

  public int strike(Warrior warrior, Weapon weapon, Armour armour, 
    int attackType, Weather weather, Terrain stadium) {
    int hitTarget = 65;
    int attackScalar = 6;
    int damage = 0;
    int roll = randNum.nextInt(100) + 1; // 1 - 100
    int damageBonus = warrior.getStrength() / (randNum.nextInt(5) + 9) + (attackScalar * attackType); // BONUS to damage
    
    hitTarget -= warrior.getDexterity() / 12; // BONUS to hitTarget
    hitTarget += armour.getDexterityCost() / 3; // COST to hitTarget
    hitTarget += weapon.getDexterityCost() / 3; // COST to hitTarget
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