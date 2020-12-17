package com.github.Ephyy.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class AxeTest extends AbstractWeaponTest {

  /**
   * Initializes the needed fields for the tests.
   */
  @BeforeEach
  void setUp() {
    super.setUp();
    testWeapon = getWeapon(WeaponType.AXE);
    testDifferentWeapon = getWeaponWith(WeaponType.AXE, 30, 15);
    correctCharacters.add(testKnight);
    correctCharacters.add(testEngineer);
    incorrectCharacters.add(testThief);
    incorrectCharacters.add(testBlackMage);
    incorrectCharacters.add(testWhiteMage);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getWeapon(WeaponType.AXE));
    checkNotEqualsConstruction(getWeaponWith(WeaponType.AXE, 11, WEIGHT));
    checkNotEqualsConstruction(getWeaponWith(WeaponType.AXE, DAMAGE, 11));
    checkNotEqualsConstruction(getWeapon(WeaponType.BOW));
  }
}
