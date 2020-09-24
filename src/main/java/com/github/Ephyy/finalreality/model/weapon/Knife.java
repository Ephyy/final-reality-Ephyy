package com.github.Ephyy.finalreality.model.weapon;

/**
 * A class that holds all the information of a Knife.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Knife extends AbstractWeapon {

  /**
   * Create a new Knife with a base name, damage and weight.
   */
  public Knife(String name, int damage, int weight, WeaponType type) {
    super(name, damage, weight, type);
  }
}
