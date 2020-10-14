package com.github.Ephyy.finalreality.model.character.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.github.Ephyy.finalreality.model.character.AbstractCharacterTest;
import com.github.Ephyy.finalreality.model.character.CharacterClass;
import com.github.Ephyy.finalreality.model.character.Enemy;

import java.util.EnumMap;
import java.util.Map;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.weapon.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Abstract class containing the common tests for all the player characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva
 * @see AbstractPlayerCharacter
 */
abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest {

  @Override
  @Test
  public abstract void constructorTest();

  /**
   * Check that a playerCharacter equip and replace their current weapon
   */
  @Test
  public abstract void equipWeaponTest();

  protected void equipWeapon(IWeapon testWeapon) {
    testPlayer.equip(testWeapon);
    assertEquals(testWeapon, testPlayer.getEquippedWeapon());
  }
}
