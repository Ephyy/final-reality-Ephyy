package com.github.Ephyy.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Enemy extends AbstractCharacter implements ICharacter {

  private final int weight;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(BlockingQueue<ICharacter> turnsQueue, String name, int hp, int atk, int def,
               int weight) {
    super(turnsQueue, name, hp, atk, def);
    this.weight = weight;
  }

  @Override
  public void attack(ICharacter opponent) {
    if (this.canAttack(opponent)) {
      opponent.receiveEnemyAttack(this);
      endTurn();
    }
  }

  @Override
  public void receiveEnemyAttack(Enemy enemyAttacker) {
  }

  @Override
  public void receivePlayerAttack(IPlayerCharacter playerAttacker) {
    int incomingDamage = playerAttacker.getAtk() + playerAttacker.getEquippedWeapon().getDamage();
    this.hp -= incomingDamage - this.def;
    if (this.getHp() <= 0) {
      this.setLifeDead();
      die();
    }
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var enemy = (Enemy) this;
    scheduledExecutor
            .schedule(this::addToQueue, enemy.getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public boolean isPlayerCharacter() {
    return false;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Enemy enemy = (Enemy) o;
    return weight == enemy.weight &&
            Objects.equals(name, enemy.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(weight);
  }
}
