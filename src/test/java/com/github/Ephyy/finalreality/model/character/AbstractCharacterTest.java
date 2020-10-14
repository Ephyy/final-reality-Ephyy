package com.github.Ephyy.finalreality.model.character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.Ephyy.finalreality.model.character.player.*;
import com.github.Ephyy.finalreality.model.weapon.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Abstract class containing the common tests for all the types of characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 * @see ICharacter
 */
public abstract class AbstractCharacterTest {


  protected static final String BLACK_MAGE_NAME = "Vivi";
  protected static final String KNIGHT_NAME = "Adelbert";
  protected static final String WHITE_MAGE_NAME = "Eiko";
  protected static final String ENGINEER_NAME = "Cid";
  protected static final String THIEF_NAME = "Zidane";
  protected static final String ENEMY_NAME = "Goblin";

  protected final int TEST_HP = 100;
  protected final int TEST_ATK = 10;
  protected final int TEST_DEF = 5;

  protected Sword testSword;
  protected Axe testAxe;
  protected Knife testKnife;
  protected Staff testStaff;
  protected Bow testBow;

  protected BlockingQueue<ICharacter> turns;
  protected List<ICharacter> testCharacters;
  protected Enemy testEnemy;
  protected IPlayerCharacter testPlayer;
  protected IWeapon testWeapon;

  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  protected void init() {
    basicSetUp();
    setWeapons();
  }

  /**
   * Checks that the class' constructor and equals method works properly.
   */
  @Test
  public abstract void constructorTest();

  /**
   * Checks that the character waits the appropriate amount of time for it's turn.
   */
  @Test
  void waitTurnTest() {
    testCharacters.get(0).waitTurn();
    try {
      // Thread.sleep is not accurate so this values may be changed to adjust the
      // acceptable error margin.
      // We're testing that the character waits approximately 1 second.
      Thread.sleep(900);
      Assertions.assertEquals(0, turns.size());
      Thread.sleep(200);
      Assertions.assertEquals(1, turns.size());
      Assertions.assertEquals(testCharacters.get(0), turns.peek());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected void checkConstruction(final ICharacter expectedCharacter,
      final ICharacter testEqualCharacter,
      final ICharacter sameClassDifferentCharacter,
      final ICharacter differentClassCharacter) {
    assertEquals(testEqualCharacter, testEqualCharacter);
    assertEquals(expectedCharacter, testEqualCharacter);
    assertEquals(expectedCharacter.hashCode(), testEqualCharacter.hashCode());
    assertNotEquals(sameClassDifferentCharacter, testEqualCharacter);
    assertNotEquals(testEqualCharacter, differentClassCharacter);
    assertNotEquals(testEqualCharacter, null);
    assertNotEquals(testEqualCharacter, new Object());
  }

  protected void checkEqualsConstruction(final ICharacter expectedCharacter) {
    assertEquals(testCharacters.get(0), testCharacters.get(0));
    assertEquals(expectedCharacter, testCharacters.get(0));
    assertEquals(expectedCharacter.hashCode(), testCharacters.get(0).hashCode());
  }

  protected void checkNotEqualsConstruction(final ICharacter actualCharacter) {
    assertNotEquals(testCharacters.get(0), actualCharacter);
    assertNotEquals(testCharacters.get(0), null);
    assertNotEquals(testCharacters.get(0), new Object());
  }

  protected void basicSetUp() {
    turns = new LinkedBlockingQueue<>();
    testWeapon = new Axe("Test", 15, 10, WeaponType.AXE);
    testCharacters = new ArrayList<>();
  }

  protected ICharacter getCharacter(CharacterClass characterClass) {
    switch (characterClass) {
      case ENEMY: return getEnemy(ENEMY_NAME, 10);
      default:
        return getPlayerCharacter(characterClass);
    }
  }

  protected IPlayerCharacter getPlayerCharacter(CharacterClass playerClass) {
    switch (playerClass) {
      case KNIGHT:
        return new Knight(turns, KNIGHT_NAME, CharacterClass.KNIGHT, TEST_HP, TEST_ATK, TEST_DEF,
                testSword);
      case ENGINEER:
        return new Engineer(turns, ENGINEER_NAME, CharacterClass.ENGINEER, TEST_HP, TEST_ATK,
                TEST_DEF, testAxe);
      case THIEF:
        return new Thief(turns, THIEF_NAME, CharacterClass.THIEF, TEST_HP, TEST_ATK, TEST_DEF,
                testKnife);
      case BLACK_MAGE:
        return new BlackMage(turns, BLACK_MAGE_NAME, CharacterClass.BLACK_MAGE, TEST_HP, TEST_ATK,
                TEST_DEF, testStaff,50);
      // In the future default can 'catch' an unexpected value.
      default:
        return new WhiteMage(turns, WHITE_MAGE_NAME, CharacterClass.WHITE_MAGE, TEST_HP, TEST_ATK,
                TEST_DEF, testStaff,50);
    }
  }

  protected Enemy getEnemy(String name, int weight) {
    return new Enemy(turns, name, CharacterClass.ENEMY, TEST_HP, TEST_ATK, TEST_DEF, weight);
  }

  /**
   * Creates a set of testing weapons
   */
  private void setWeapons() {
    this.testSword = new Sword("Axe", 15, 10, WeaponType.SWORD);
    this.testAxe = new Axe("Sword", 15, 10, WeaponType.AXE);
    this.testKnife = new Knife("Spear", 15, 10, WeaponType.KNIFE);
    this.testStaff = new Staff("Staff", 15, 10, WeaponType.STAFF);
    this.testBow = new Bow("Bow", 15, 10, WeaponType.BOW);
  }
}
