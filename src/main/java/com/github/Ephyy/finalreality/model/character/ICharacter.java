package com.github.Ephyy.finalreality.model.character;

import com.github.Ephyy.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;

import java.beans.PropertyChangeListener;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva
 */
public interface ICharacter {

  /**
   * Add a death listener to notify the controller when this character dies
   * @param listener the death listener
   */
  void addDeathListener(PropertyChangeListener listener);

  /**
   * Add a turn listener to notify the controller when this character start and end his turn
   * @param listener the death listener
   */
  void addTurnListener(PropertyChangeListener listener);

  /**
   * Makes this character attack another
   * @param opponent the character that will be attacked.
   */
  void attack(ICharacter opponent);

  /**
   * Makes  this character receive an enemy character attack
   * @param enemyAttacker the enemy character that is attacking
   */
  void receiveEnemyAttack(Enemy enemyAttacker);

  /**
   * Makes this character receive a player character attack
   * @param playerAttacker the player character that is attacking
   */
  void receivePlayerAttack(IPlayerCharacter playerAttacker);

  /**
   * Sets a scheduled executor to make this character (thread) wait for {@code speed / 10}
   * seconds before adding the character to the queue.
   */
  void waitTurn();

  /**
   * Returns this character's life status
   */
  boolean isAlive();

  /**
   * Sets this character's life status
   */
  void setLifeDead();

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's hp.
   */
  int getHp();

  /**
   * Returns this character's attack.
   */
  int getAtk();

  /**
   * Returns this character's defense
   */
  int getDef();
}
