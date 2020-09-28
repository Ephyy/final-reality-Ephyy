package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that holds all the information of a single mage of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class AbstractMage extends AbstractPlayerCharacter implements IMage {

  private int mana;

  /**
   * Create a mage character with a name, mage class and the mana that will have.
   */
  public AbstractMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                      CharacterClass characterClass, int mana) {
    super(name, turnsQueue, characterClass);
    this.mana = mana;
  }
}
