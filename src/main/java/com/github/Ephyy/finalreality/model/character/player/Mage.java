package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single mage character in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Mage extends AbstractPlayerCharacter {

  private int mana;

  /**
   * Create a mage character with a name, mage class and the mana that will have.
   */
  public Mage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
              CharacterClass characterClass, int mana) {
    super(name, turnsQueue, characterClass);
    this.mana = mana;
  }
}
