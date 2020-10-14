package com.github.Ephyy.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  protected final CharacterClass characterClass;
  protected final int hp;
  protected final int atk;
  protected final int def;
  private ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   * @param hp
   *     the health point of this character
   * @param atk
   *     the attack points of this character
   * @param def
   *     the defense point of this character
   */
  public AbstractCharacter(BlockingQueue<ICharacter> turnsQueue, String name,
                           CharacterClass characterClass, int hp, int atk, int def) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.characterClass = characterClass;
    this.hp = hp;
    this.atk = atk;
    this.def = def;
  }

  // Hay que usar DD aqui, asi que esto esta incorrecto
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (this instanceof IPlayerCharacter) {
      var player = (IPlayerCharacter) this;
      scheduledExecutor
              .schedule(this::addToQueue,
                      player.getEquippedWeapon().getWeight() / 10, TimeUnit.SECONDS);
    } else {
      var enemy = (Enemy) this;
      scheduledExecutor
          .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
    }
  }

  /**
   * Adds this character to the turns queue.
   */
  private void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public CharacterClass getCharacterClass() {
    return characterClass;
  }
}
