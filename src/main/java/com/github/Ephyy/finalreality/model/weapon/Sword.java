package com.github.Ephyy.finalreality.model.weapon;

/**
 * A class that holds all the information of a Sword.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Sword extends AbstractWeapon {

  /**
   * Create a new Sword with a base name, damage and weight.
   */
  public Sword(String name, int damage, int weight, WeaponType type) {
    super(name, damage, weight, type);
  }
}
