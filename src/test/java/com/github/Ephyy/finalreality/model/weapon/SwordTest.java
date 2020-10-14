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
    testWeapon = getWeapon(WeaponType.SWORD);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getWeapon(WeaponType.SWORD));
    checkNotEqualsConstruction(new Sword(SWORD_NAME, 50, 12, WeaponType.SWORD));
    checkNotEqualsConstruction(getWeapon(WeaponType.BOW));
  }
}
