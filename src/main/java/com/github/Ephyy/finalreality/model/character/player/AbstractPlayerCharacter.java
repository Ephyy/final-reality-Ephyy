package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.AbstractCharacter;
import com.github.Ephyy.finalreality.model.character.CharacterClass;
import com.github.Ephyy.finalreality.model.character.ICharacter;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

import com.github.Ephyy.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds all the information of a single character of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter
        implements IPlayerCharacter {

  protected IWeapon equippedWeapon;

  /**
   * Creates a new player character with a name, player class, and initial stats that will have.
   */
  public AbstractPlayerCharacter(BlockingQueue<ICharacter> turnsQueue, String name,
                                 CharacterClass characterClass, int hp, int atk, int def,
                                 IWeapon equippedWeapon) {
    super(turnsQueue, name, characterClass, hp, atk, def);
    this.equippedWeapon = equippedWeapon;
  }

  // Hay que usar DD
  @Override
  public void equip(IWeapon weapon) {
      this.equippedWeapon = weapon;
  }

  @Override
  public IWeapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractPlayerCharacter that = (AbstractPlayerCharacter) o;
    return Objects.equals(equippedWeapon, that.equippedWeapon) &&
            Objects.equals(name, that.getName()) &&
            characterClass == that.getCharacterClass();
  }

  @Override
  public int hashCode() {
    return Objects.hash(equippedWeapon);
  }
}
