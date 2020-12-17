package com.github.Ephyy.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class SwordTest extends AbstractWeaponTest {
  /**
   * Initializes the needed fields for the tests.
   */
  @BeforeEach
  void setUp() {
    super.setUp();
    testWeapon = getWeapon(WeaponType.SWORD);
    testDifferentWeapon = getWeaponWith(WeaponType.SWORD, 30, 15);
    correctCharacters.add(testKnight);
    correctCharacters.add(testThief);
    incorrectCharacters.add(testEngineer);
    incorrectCharacters.add(testBlackMage);
    incorrectCharacters.add(testWhiteMage);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getWeapon(WeaponType.SWORD));
    checkNotEqualsConstruction(new Sword(SWORD_NAME, 50, 12));
    checkNotEqualsConstruction(getWeapon(WeaponType.BOW));
  }
}
