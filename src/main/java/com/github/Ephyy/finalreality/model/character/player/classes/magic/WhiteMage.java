package com.github.Ephyy.finalreality.model.character.player.classes.magic;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.character.player.classes.magic.AbstractMage;
import com.github.Ephyy.finalreality.model.weapon.IWeapon;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single WhiteMage character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class WhiteMage extends AbstractMage {

  /**
   * Creates a new WhiteMage with a name, the queue and stats with the characters ready to
   * play.
   */
  public WhiteMage(BlockingQueue<ICharacter> turnsQueue, String name, int hp, int atk, int def,
                   IWeapon equippedWeapon, int mana) {
    super(turnsQueue, name, hp, atk, def, equippedWeapon, mana);
  }
}
