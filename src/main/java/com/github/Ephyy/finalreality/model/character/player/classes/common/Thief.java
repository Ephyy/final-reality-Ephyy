package com.github.Ephyy.finalreality.model.character.player.classes.common;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.Ephyy.finalreality.model.weapon.*;

import java.util.concurrent.BlockingQueue;

/**
 * A class that holds all the information of a single Thief character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Thief extends AbstractPlayerCharacter {

  /**
   * Creates a new Thief with a name, the queue and stats with the characters ready to
   * play.
   */
  public Thief(BlockingQueue<ICharacter> turnsQueue, String name, int hp, int atk, int def,
               IWeapon equippedWeapon) {
    super(turnsQueue, name, hp, atk, def, equippedWeapon);
  }

  @Override
  public void equipSword(Sword sword) {
    this.equippedWeapon = sword;
  }

  @Override
  public void equipKnife(Knife knife) {
    this.equippedWeapon = knife;
  }

  @Override
  public void equipBow(Bow bow) {
    this.equippedWeapon = bow;
  }
}
