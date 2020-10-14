package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.CharacterClass;
import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single Knight character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Knight extends AbstractPlayerCharacter implements ICommon {

  /**
   * Creates a new Knight with a name, the queue and stats with the characters ready to
   * play.
   */
  public Knight(BlockingQueue<ICharacter> turnsQueue, String name, CharacterClass characterClass,
                int hp, int atk, int def, IWeapon equippedWeapon) {
    super(turnsQueue, name, characterClass, hp, atk, def, equippedWeapon);
  }
}
