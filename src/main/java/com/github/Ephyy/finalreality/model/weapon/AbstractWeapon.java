package com.github.Ephyy.finalreality.model.weapon;

import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;

import java.util.Objects;

/**
 * An abstract class that holds all the information of a weapon.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public abstract class AbstractWeapon implements IWeapon {

  private final String name;
  private final int damage;
  private final int weight;

  /**
   * Creates a weapon with a name, a base damage, speed and it's type.
   */
  public AbstractWeapon(final String name, final int damage, final int weight) {
    this.name = name;
    this.damage = damage;
    this.weight = weight;
  }

  protected boolean canEquip(IPlayerCharacter playerCharacter) {
    return playerCharacter.isAlive();
  }

  @Override
  public abstract void equipWeapon(IPlayerCharacter playerCharacter);

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getDamage() {
    return damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractWeapon)) {
      return false;
    }
    final AbstractWeapon weapon = (AbstractWeapon) o;
    return getDamage() == weapon.getDamage() &&
        getWeight() == weapon.getWeight() &&
        getName().equals(weapon.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getDamage(), getWeight());
  }
}
