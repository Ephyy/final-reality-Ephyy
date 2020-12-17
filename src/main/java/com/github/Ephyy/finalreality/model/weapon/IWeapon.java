package com.github.Ephyy.finalreality.model.weapon;

import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;

/**
 * This represents a Weapon in the game.
 * A weapon only can be equipped for the player characters
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public interface IWeapon {

  /**
   * Equips a weapon to the character.
   */
  void equipWeapon(IPlayerCharacter playerCharacter);

  /**
   * Returns this Weapon's name.
   */
  String getName();

  /**
   * Returns this Weapon's damage.
   */
  int getDamage();

  /**
   * Returns this Weapon's weight.
   */
  int getWeight();
}
