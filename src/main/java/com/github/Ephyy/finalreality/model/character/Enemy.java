package com.github.Ephyy.finalreality.model.character;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Enemy extends AbstractCharacter {

  private final int weight;

  /**
   * Creates a new enemy with a name, a weight and the queue with the characters ready to
   * play.
   */
  public Enemy(BlockingQueue<ICharacter> turnsQueue, String name, CharacterClass characterClass,
               int hp, int atk, int def, int weight) {
    super(turnsQueue, name, characterClass, hp, atk, def);
    this.weight = weight;
  }

  /**
   * Returns the weight of this enemy.
   */
  public int getWeight() {
    return weight;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Enemy enemy = (Enemy) o;
    return weight == enemy.weight &&
            Objects.equals(name, enemy.getName()) &&
            characterClass == enemy.getCharacterClass();
  }

  @Override
  public int hashCode() {
    return Objects.hash(weight);
  }
}
