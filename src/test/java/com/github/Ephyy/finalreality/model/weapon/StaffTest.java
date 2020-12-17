package com.github.Ephyy.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class StaffTest extends AbstractWeaponTest {

  /**
   * Initializes the needed fields for the tests.
   */
  @BeforeEach
  void setUp() {
    super.setUp();
    testWeapon = getWeapon(WeaponType.STAFF);
    testDifferentWeapon = getWeaponWith(WeaponType.STAFF, 30, 15);
    correctCharacters.add(testBlackMage);
    correctCharacters.add(testWhiteMage);
    incorrectCharacters.add(testKnight);
    incorrectCharacters.add(testEngineer);
    incorrectCharacters.add(testThief);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getWeapon(WeaponType.STAFF));
    checkNotEqualsConstruction(new Staff(STAFF_NAME, 11, 11));
    checkNotEqualsConstruction(getWeapon(WeaponType.BOW));
  }
}
