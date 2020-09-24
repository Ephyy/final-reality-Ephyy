package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.weapon.Weapon;

/**
 * @author Vicente Ardiles Silva.
 */
public interface IPlayerCharacter {

  /**
   * Equips a weapon to the character.
   */
  void equip(Weapon weapon);

  /**
   * Return this character's equipped weapon.
   */
  Weapon getEquippedWeapon();
}
