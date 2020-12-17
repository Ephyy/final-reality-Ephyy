package com.github.Ephyy.finalreality.model.character;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public abstract class AbstractCharacter implements ICharacter {

  protected final PropertyChangeSupport deadEvent = new PropertyChangeSupport(this);
  protected final PropertyChangeSupport turnEvent = new PropertyChangeSupport(this);

  protected final BlockingQueue<ICharacter> turnsQueue;
  protected final String name;
  protected int hp;
  protected int atk;
  protected int def;
  protected boolean life;
  protected ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param hp
   *     the health point of this character
   * @param atk
   *     the attack points of this character
   * @param def
   *     the defense point of this character
   */
  public AbstractCharacter(BlockingQueue<ICharacter> turnsQueue, String name, int hp, int atk,
                           int def) {
    this.turnsQueue = turnsQueue;
    this.name = name;
    this.hp = hp;
    this.atk = atk;
    this.def = def;
    this.life = true;
  }

  @Override
  public void addDeathListener(PropertyChangeListener listener) {
    deadEvent.addPropertyChangeListener(listener);
  }

  @Override
  public void addTurnListener(PropertyChangeListener listener) {
    turnEvent.addPropertyChangeListener(listener);
  }

  protected void startTurn() {
    turnEvent.firePropertyChange("CharacterReady", null, this);
  }

  protected void endTurn() {
    turnEvent.firePropertyChange("TurnEnded", null, this);
  }

  protected void die() {
    deadEvent.firePropertyChange(name + " has died", null, this);
  }

  @Override
  public abstract void waitTurn();

  /**
   * Adds this character to the turns queue.
   */
  protected void addToQueue() {
    turnsQueue.add(this);
    scheduledExecutor.shutdown();
    startTurn();
  }

  @Override
  public abstract void attack(ICharacter opponent);

  protected boolean canAttack(ICharacter opponent) {
    return opponent.isAlive() && this.isAlive();
  }

  @Override
  public boolean isAlive() {
    return life;
  }

  @Override
  public void setLifeDead() {
    this.hp = 0;
    this.life = false;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getHp() {
    return this.hp;
  }

  @Override
  public int getAtk() {
    return this.atk;
  }

  @Override
  public int getDef() {
    return def;
  }
}
