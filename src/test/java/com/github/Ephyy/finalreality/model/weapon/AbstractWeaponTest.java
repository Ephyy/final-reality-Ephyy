package com.github.Ephyy.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractWeaponTest {

  private static final String AXE_NAME = "Test Axe";
  private static final String STAFF_NAME = "Test Staff";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int SPEED = 10;

  private AbstractWeapon testAxe;
  private AbstractWeapon testStaff;
  private AbstractWeapon testSword;
  private AbstractWeapon testBow;
  private AbstractWeapon testKnife;

  @BeforeEach
  void setUp() {
    testAxe = new AbstractWeapon(AXE_NAME, DAMAGE, SPEED, WeaponType.AXE);
    testStaff = new AbstractWeapon(STAFF_NAME, DAMAGE, SPEED, WeaponType.STAFF);
    testSword = new AbstractWeapon(SWORD_NAME, DAMAGE, SPEED, WeaponType.SWORD);
    testBow = new AbstractWeapon(BOW_NAME, DAMAGE, SPEED, WeaponType.BOW);
    testKnife = new AbstractWeapon(KNIFE_NAME, DAMAGE, SPEED, WeaponType.KNIFE);
  }

  @Test
  void constructorTest() {
    var expectedAxe = new AbstractWeapon(AXE_NAME, DAMAGE, SPEED, WeaponType.AXE);
    var expectedStaff = new AbstractWeapon(STAFF_NAME, DAMAGE, SPEED, WeaponType.STAFF);
    var expectedSword = new AbstractWeapon(SWORD_NAME, DAMAGE, SPEED, WeaponType.SWORD);
    var expectedBow = new AbstractWeapon(BOW_NAME, DAMAGE, SPEED, WeaponType.BOW);
    var expectedKnife = new AbstractWeapon(KNIFE_NAME, DAMAGE, SPEED, WeaponType.KNIFE);

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
  }
}