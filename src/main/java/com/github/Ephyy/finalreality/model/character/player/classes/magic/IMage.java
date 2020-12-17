package com.github.Ephyy.finalreality.model.character.player.classes.magic;

import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;

/**
 * This represents a mage character in the game.
 * This character can use magical skills.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public interface IMage extends IPlayerCharacter {

  /**
   * Return this mage's mana
   */
  int getMana();
}
