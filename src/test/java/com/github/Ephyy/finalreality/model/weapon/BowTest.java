package com.github.Ephyy.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class BowTest extends AbstractWeaponTest {

  /**
   * Initializes the needed fields for the tests.
   */
  @BeforeEach
  void setUp() {
    testWeapon = getWeapon(WeaponType.BOW);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getWeapon(WeaponType.BOW));
    checkNotEqualsConstruction(new Bow(BOW_NAME, 11, 11, WeaponType.BOW));
    checkNotEqualsConstruction(getWeapon(WeaponType.AXE));
  }
}
