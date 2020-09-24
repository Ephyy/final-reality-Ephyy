package com.github.Ephyy.finalreality.model.weapon;

/**
 * A class that holds all the information of a Bow.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Bow extends AbstractWeapon {

  /**
   * Create a new Bow with a base name, damage and weight.
   */
  public Bow(String name, int damage, int weight, WeaponType type) {
    super(name, damage, weight, type);
  }
}
