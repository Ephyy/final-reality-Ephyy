package com.github.Ephyy.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class KnifeTest extends AbstractWeaponTest {

  /**
   * Initializes the needed fields for the tests.
   */
  @BeforeEach
  void setUp() {
    testWeapon = getWeapon(WeaponType.KNIFE);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getWeapon(WeaponType.KNIFE));
    checkNotEqualsConstruction(new Knife(KNIFE_NAME, 11, 11, WeaponType.KNIFE));
    checkNotEqualsConstruction(getWeapon(WeaponType.BOW));
  }
}
