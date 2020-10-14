package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.CharacterClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test set for the White mage character.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
class WhiteMageTest extends AbstractPlayerCharacterTest {

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @BeforeEach
  public void setUp() {
    super.init();
    testPlayer = getPlayerCharacter(CharacterClass.WHITE_MAGE);
    testCharacters.add(testPlayer);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getPlayerCharacter(CharacterClass.WHITE_MAGE));
    checkNotEqualsConstruction(new WhiteMage(turns, WHITE_MAGE_NAME, CharacterClass.WHITE_MAGE,
            TEST_HP, TEST_ATK, TEST_DEF, testStaff, 100));
    checkNotEqualsConstruction(getCharacter(CharacterClass.THIEF));
  }

  @Override
  @Test
  public void equipWeaponTest() {
    equipWeapon(testStaff);
  }
}
