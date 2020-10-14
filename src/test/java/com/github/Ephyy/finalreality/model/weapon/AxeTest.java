package com.github.Ephyy.finalreality.model.weapon;

import com.github.Ephyy.finalreality.model.character.player.Knight;
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
    testWeapon = getWeapon(WeaponType.AXE);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getWeapon(WeaponType.AXE));
    checkNotEqualsConstruction(new Axe(AXE_NAME, 11, WEIGHT, WeaponType.AXE));
    checkNotEqualsConstruction(new Axe(AXE_NAME, DAMAGE, 11, WeaponType.AXE));
    checkNotEqualsConstruction(new Axe(AXE_NAME, DAMAGE, WEIGHT, WeaponType.BOW));
    checkNotEqualsConstruction(getWeapon(WeaponType.BOW));
  }
}
