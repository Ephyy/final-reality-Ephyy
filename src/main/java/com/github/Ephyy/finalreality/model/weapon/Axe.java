package com.github.Ephyy.finalreality.model.weapon;

import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;
import com.github.Ephyy.finalreality.model.character.player.classes.common.Knight;

/**
 * A class that holds all the information of an Axe.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class Axe extends AbstractWeapon {

  /**
   * Create a new Axe with a base name, damage and weight.
   */
  public Axe(String name, int damage, int weight) {
    super(name, damage, weight);
  }

  @Override
  public void equipWeapon(IPlayerCharacter playerCharacter) {
    if (this.canEquip(playerCharacter)) {
      playerCharacter.equipAxe(this);
    }
  }
}
