package com.github.Ephyy.finalreality.model.weapon;

import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;

/**
 * A class that holds all the information of a Staff.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Staff extends AbstractWeapon {

  // magic damage

  /**
   * Create a new Staff with a base name, damage and weight.
   */
  public Staff(String name, int damage, int weight) {
    super(name, damage, weight);
  }

  @Override
  public void equipWeapon(IPlayerCharacter playerCharacter) {
    if (this.canEquip(playerCharacter)) {
      playerCharacter.equipStaff(this);
    }
  }
}
