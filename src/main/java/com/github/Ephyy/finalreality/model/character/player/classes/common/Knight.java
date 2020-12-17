package com.github.Ephyy.finalreality.model.character.player.classes.common;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.Ephyy.finalreality.model.weapon.Axe;
import com.github.Ephyy.finalreality.model.weapon.IWeapon;
import com.github.Ephyy.finalreality.model.weapon.Knife;
import com.github.Ephyy.finalreality.model.weapon.Sword;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single Knight character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Knight extends AbstractPlayerCharacter {

  /**
   * Creates a new Knight with a name, the queue and stats with the characters ready to
   * play.
   */
  public Knight(BlockingQueue<ICharacter> turnsQueue, String name, int hp, int atk, int def,
                IWeapon equippedWeapon) {
    super(turnsQueue, name, hp, atk, def, equippedWeapon);
  }

  @Override
  public void equipSword(Sword sword) {
    this.equippedWeapon = sword;
  }

  @Override
  public void equipAxe(Axe axe) {
    this.equippedWeapon = axe;
  }

  @Override
  public void equipKnife(Knife knife) {
    this.equippedWeapon = knife;
  }
}
