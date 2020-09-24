package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * @author Vicente Ardiles Silva.
 */
public class Common extends AbstractPlayerCharacter {

  /**
   * Create a new common character with a name and common class
   */
  public Common(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                CharacterClass characterClass) {
    super(name, turnsQueue, characterClass);
  }
}
