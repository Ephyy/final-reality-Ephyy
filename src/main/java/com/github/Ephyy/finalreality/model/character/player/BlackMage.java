package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.CharacterClass;
import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single BlackMage character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class BlackMage extends AbstractMage {

  /**
   * Creates a new BlackMage with a name, the queue, stats and mana with the characters ready to
   * play.
   */
  public BlackMage(BlockingQueue<ICharacter> turnsQueue, String name, CharacterClass characterClass,
                   int hp, int atk, int def, IWeapon equippedWeapon, int mana) {
    super(turnsQueue, name, characterClass, hp, atk, def, equippedWeapon, mana);
  }
}
