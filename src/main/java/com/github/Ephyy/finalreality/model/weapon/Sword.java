package com.github.Ephyy.finalreality.model.weapon;

import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;

/**
 * A class that holds all the information of a Sword.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Sword extends AbstractWeapon {

  /**
   * Create a new Sword with a base name, damage and weight.
   */
  public Sword(String name, int damage, int weight) {
    super(name, damage, weight);
  }

  @Override
  public void equipWeapon(IPlayerCharacter playerCharacter) {
    if (this.canEquip(playerCharacter)) {
      playerCharacter.equipSword(this);
    }
  }
}
