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
    testWeapon = getWeapon(WeaponType.STAFF);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getWeapon(WeaponType.STAFF));
    checkNotEqualsConstruction(new Staff(STAFF_NAME, 11, 11, WeaponType.STAFF));
    checkNotEqualsConstruction(getWeapon(WeaponType.BOW));
  }
}
