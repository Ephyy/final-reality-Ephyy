package com.github.Ephyy.finalreality.model.weapon;

import com.github.Ephyy.finalreality.model.character.CharacterClass;
import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.character.player.*;
import com.github.Ephyy.finalreality.model.character.player.classes.common.Engineer;
import com.github.Ephyy.finalreality.model.character.player.classes.common.Knight;
import com.github.Ephyy.finalreality.model.character.player.classes.common.Thief;
import com.github.Ephyy.finalreality.model.character.player.classes.magic.BlackMage;
import com.github.Ephyy.finalreality.model.character.player.classes.magic.WhiteMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractWeaponTest {

  protected final int TEST_HP = 100;
  protected final int TEST_ATK = 10;
  protected final int TEST_DEF = 5;

  protected static final String AXE_NAME = "Test Axe";
  protected static final String STAFF_NAME = "Test Staff";
  protected static final String SWORD_NAME = "Test Sword";
  protected static final String BOW_NAME = "Test Bow";
  protected static final String KNIFE_NAME = "Test Knife";
  protected static final int DAMAGE = 15;
  protected static final int WEIGHT = 10;

  protected IWeapon testWeapon;
  protected IWeapon testDifferentWeapon;

  protected List<IPlayerCharacter> correctCharacters;
  protected List<IPlayerCharacter> incorrectCharacters;
  protected BlockingQueue<ICharacter> turns;

  protected IPlayerCharacter testKnight;
  protected IPlayerCharacter testEngineer;
  protected IPlayerCharacter testThief;
  protected IPlayerCharacter testBlackMage;
  protected IPlayerCharacter testWhiteMage;

  @BeforeEach
  void setUp() {
    correctCharacters = new ArrayList<>();
    incorrectCharacters = new ArrayList<>();
    turns = new LinkedBlockingQueue<>();
    testKnight = getPlayerCharacter(CharacterClass.KNIGHT);
    testEngineer = getPlayerCharacter(CharacterClass.ENGINEER);
    testThief = getPlayerCharacter(CharacterClass.THIEF);
    testBlackMage = getPlayerCharacter(CharacterClass.BLACK_MAGE);
    testWhiteMage = getPlayerCharacter(CharacterClass.WHITE_MAGE);
  }

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

  @Test
  public void checkCorrectWeapon() {
    for (IPlayerCharacter character : correctCharacters) {
      testWeapon.equipWeapon(character);
      assertEquals(testWeapon, character.getEquippedWeapon());
    }
  }

  @Test
  public void checkIncorrectWeapon() {
    for (IPlayerCharacter character : incorrectCharacters) {
      testWeapon.equipWeapon(character);
      assertNotEquals(testWeapon, character.getEquippedWeapon());
    }
  }

  @Test
  public void checkCantEquip() {
    for (IPlayerCharacter character : correctCharacters) {
      character.setLifeDead();
      testDifferentWeapon.equipWeapon(character);
      assertNotEquals(testDifferentWeapon, character.getEquippedWeapon());
    }
  }

  protected IPlayerCharacter getPlayerCharacter(CharacterClass playerClass) {
    switch (playerClass) {
      case KNIGHT:
        return new Knight(turns, "TestWeaponKnight", TEST_HP, TEST_ATK, TEST_DEF,
                getWeapon(WeaponType.SWORD));
      case ENGINEER:
        return new Engineer(turns, "TestWeaponEngineer", TEST_HP, TEST_ATK, TEST_DEF,
                getWeapon(WeaponType.AXE));
      case THIEF:
        return new Thief(turns, "TestWeaponThief", TEST_HP, TEST_ATK, TEST_DEF,
                getWeapon(WeaponType.KNIFE));
      case BLACK_MAGE:
        return new BlackMage(turns, "TestWeaponBlackMage", TEST_HP, TEST_ATK, TEST_DEF,
                getWeapon(WeaponType.STAFF),50);
      // In the future default can 'catch' an unexpected value.
      default:
        return new WhiteMage(turns, "TestWhiteMage", TEST_HP, TEST_ATK, TEST_DEF,
                getWeapon(WeaponType.STAFF),50);
    }
  }

  protected IWeapon getWeaponWith(WeaponType type, int dmg, int weight) {
    switch (type) {
      case AXE:
        return new Axe(AXE_NAME, dmg, weight);
      case BOW:
        return new Bow(BOW_NAME, dmg, weight);
      case KNIFE:
        return new Knife(KNIFE_NAME, dmg, weight);
      case STAFF:
        return new Staff(STAFF_NAME, dmg, weight);
      default:
        return new Sword(SWORD_NAME, dmg, weight);
      // In the future default can 'catch' an unexpected value.
    }
  }

  protected IWeapon getWeapon(WeaponType type) {
    return getWeaponWith(type, DAMAGE, WEIGHT);
  }
  // endregopn
}