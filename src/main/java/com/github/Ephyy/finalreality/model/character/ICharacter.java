package com.github.Ephyy.finalreality.model.character;

import com.github.Ephyy.finalreality.model.character.player.CharacterClass;
import com.github.Ephyy.finalreality.model.weapon.Weapon;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva
 */
public interface ICharacter {

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's class.
   */
  CharacterClass getCharacterClass();
}