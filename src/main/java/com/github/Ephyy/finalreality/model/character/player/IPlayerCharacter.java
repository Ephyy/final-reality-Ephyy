package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.weapon.IWeapon;

/**
 * This represents a player character in the game.
 * Only a player can use this types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public interface IPlayerCharacter {

  /**
   * Equips a weapon to the character.
   */
  void equip(IWeapon weapon);

  /**
   * Return this character's equipped weapon.
   */
  IWeapon getEquippedWeapon();
}
