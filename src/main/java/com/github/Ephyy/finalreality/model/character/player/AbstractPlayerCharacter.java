package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.AbstractCharacter;
import com.github.Ephyy.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import com.github.Ephyy.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter
        implements IPlayerCharacter {

  private Weapon equippedWeapon = null;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param characterClass
   *     the class of this character
   */
  public AbstractPlayerCharacter(@NotNull String name,
                                 @NotNull BlockingQueue<ICharacter> turnsQueue,
                                 final CharacterClass characterClass) {
    super(turnsQueue, name, characterClass);
  }

  // Hay que usar DD
  @Override
  public void equip(Weapon weapon) {
    if (this instanceof IPlayerCharacter) {
      this.equippedWeapon = weapon;
    }
  }
  @Override
  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCharacterClass());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractPlayerCharacter)) {
      return false;
    }
    final AbstractPlayerCharacter that = (AbstractPlayerCharacter) o;
    return getCharacterClass() == that.getCharacterClass()
        && getName().equals(that.getName());
  }
}