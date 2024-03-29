package com.github.Ephyy.finalreality.model.character.player.classes.magic;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.Ephyy.finalreality.model.weapon.IWeapon;
import com.github.Ephyy.finalreality.model.weapon.Staff;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * An abstract class that holds all the information of a single mage of the game.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class AbstractMage extends AbstractPlayerCharacter implements IMage {

  private int mana;

  /**
   * Create a mage character with a name, mage class and the mana that will have.
   */
  public AbstractMage(BlockingQueue<ICharacter> turnsQueue, String name, int hp, int atk, int def,
                      IWeapon equippedWeapon, int mana) {
    super(turnsQueue, name, hp, atk, def, equippedWeapon);
    this.mana = mana;
  }

  @Override
  public void equipStaff(Staff staff) {
    this.equippedWeapon = staff;
  }

  @Override
  public int getMana() {
    return mana;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractMage that = (AbstractMage) o;
    return mana == that.mana &&
            Objects.equals(equippedWeapon, that.equippedWeapon) &&
            Objects.equals(name, that.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), mana);
  }
}
