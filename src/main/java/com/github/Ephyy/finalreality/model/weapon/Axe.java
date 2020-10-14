package com.github.Ephyy.finalreality.model.weapon;

/**
 * A class that holds all the information of an Axe.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Axe extends AbstractWeapon {

  /**
   * Create a new Axe with a base name, damage and weight.
   */
  public Axe(String name, int damage, int weight, WeaponType type) {
    super(name, damage, weight, type);
  }
}
