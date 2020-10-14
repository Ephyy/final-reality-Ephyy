package com.github.Ephyy.finalreality.model.weapon;

/**
 * A class that holds all the information of a Staff.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Staff extends AbstractWeapon {

  // magic damage

  /**
   * Create a new Staff with a base name, damage and weight.
   */
  public Staff(String name, int damage, int weight, WeaponType type) {
    super(name, damage, weight, type);
  }
}
