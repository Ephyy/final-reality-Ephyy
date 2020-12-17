package com.github.Ephyy.finalreality.model.character.player.classes.magic;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.character.player.classes.magic.AbstractMage;
import com.github.Ephyy.finalreality.model.weapon.IWeapon;
import com.github.Ephyy.finalreality.model.weapon.Knife;

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
  public BlackMage(BlockingQueue<ICharacter> turnsQueue, String name, int hp, int atk, int def,
                   IWeapon equippedWeapon, int mana) {
    super(turnsQueue, name, hp, atk, def, equippedWeapon, mana);
  }

  @Override
  public void equipKnife(Knife knife) {
    this.equippedWeapon = knife;
  }
}
