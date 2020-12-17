package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.AbstractCharacter;
import com.github.Ephyy.finalreality.model.character.Enemy;
import com.github.Ephyy.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.github.Ephyy.finalreality.model.weapon.*;

/**
 * An abstract class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter
        implements IPlayerCharacter, ICharacter {

  protected IWeapon equippedWeapon;

  /**
   * Creates a new player character with a name, player class, and initial stats that will have.
   */
  public AbstractPlayerCharacter(BlockingQueue<ICharacter> turnsQueue, String name, int hp, int atk,
                                 int def, IWeapon equippedWeapon) {
    super(turnsQueue, name, hp, atk, def);
    this.equippedWeapon = equippedWeapon;
  }

  public void attack(ICharacter enemyOpponent) {
    if (this.canAttack(enemyOpponent)) {
      enemyOpponent.receivePlayerAttack(this);
      endTurn();
    }
  }

  public void receiveEnemyAttack(Enemy enemyAttacker) {
    this.hp -= enemyAttacker.getAtk() - this.def;
    if (this.getHp() <= 0) {
      this.setLifeDead();
      die();
    }
  }

  public void receivePlayerAttack(IPlayerCharacter playerAttacker) {
  }

  public void equipSword(Sword sword) {}

  public void equipAxe(Axe axe) {}

  public void equipKnife(Knife knife) {}

  public void equipStaff(Staff staff) {}

  public void equipBow(Bow bow) {}

  @Override
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(this::addToQueue,
            this.getEquippedWeapon().getWeight() / 10, TimeUnit.SECONDS);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractPlayerCharacter that = (AbstractPlayerCharacter) o;
    return Objects.equals(equippedWeapon, that.equippedWeapon) &&
            Objects.equals(name, that.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(equippedWeapon);
  }
}
