package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single WhiteMage character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class WhiteMage extends AbstractMage {

  public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                   CharacterClass characterClass, int mana) {
    super(name, turnsQueue, characterClass, mana);
  }
}
