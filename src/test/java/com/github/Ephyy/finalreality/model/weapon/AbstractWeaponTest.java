package com.github.Ephyy.finalreality.model.weapon;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractWeaponTest {

  protected static final String AXE_NAME = "Test Axe";
  protected static final String STAFF_NAME = "Test Staff";
  protected static final String SWORD_NAME = "Test Sword";
  protected static final String BOW_NAME = "Test Bow";
  protected static final String KNIFE_NAME = "Test Knife";
  protected static final int DAMAGE = 15;
  protected static final int WEIGHT = 10;

  protected IWeapon testWeapon;

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  public abstract void constructorTest();

  protected void checkEqualsConstruction(final IWeapon expectedWeapon) {
    assertEquals(testWeapon, testWeapon);
    assertEquals(expectedWeapon, testWeapon);
    assertEquals(expectedWeapon.hashCode(), testWeapon.hashCode());
  }

  protected void checkNotEqualsConstruction(final IWeapon actualWeapon) {
    assertNotEquals(testWeapon, actualWeapon);
    assertNotEquals(testWeapon, null);
    assertNotEquals(testWeapon, new Object());
  }

  protected IWeapon getWeapon(WeaponType type) {
    switch (type) {
      case AXE:
        return new Axe(AXE_NAME, DAMAGE, WEIGHT, type);
      case BOW:
        return new Bow(BOW_NAME, DAMAGE, WEIGHT, type);
      case KNIFE:
        return new Knife(KNIFE_NAME, DAMAGE, WEIGHT, type);
      case STAFF:
        return new Staff(STAFF_NAME, DAMAGE, WEIGHT, type);
      default:
        return new Sword(SWORD_NAME, DAMAGE, WEIGHT, type);
      // In the future default can 'catch' an unexpected value.
    }
  }
  // endregopn
}