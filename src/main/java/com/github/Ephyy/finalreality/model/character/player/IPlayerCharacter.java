package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.weapon.*;

/**
 * This represents a player character in the game.
 * Only a player can use this types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public interface IPlayerCharacter extends ICharacter {

  /**
   * Return this character's equipped weapon.
   */
  IWeapon getEquippedWeapon();

  /**
   * Try to equip a Sword to this player character.
   * @param sword the sword that will be equipped.
   */
  void equipSword(Sword sword);

  /**
   * Try to equip an Axe to this player character.
   * @param axe the axe that will be equipped.
   */
  void equipAxe(Axe axe);

  /**
   * Try to equip a Knife to this player character.
   * @param knife the knife that will be equipped.
   */
  void equipKnife(Knife knife);

  /**
   * Try to equip a Staff to this player character.
   * @param staff the staff that will be equipped.
   */
  void equipStaff(Staff staff);

  /**
   * Try to equip a Bow to this player character.
   * @param bow the bow that will be equipped.
   */
  void equipBow(Bow bow);

}
