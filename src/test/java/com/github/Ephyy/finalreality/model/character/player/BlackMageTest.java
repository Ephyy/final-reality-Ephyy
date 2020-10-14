package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.CharacterClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test set for the Black mage character.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
class BlackMageTest extends AbstractPlayerCharacterTest {

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @BeforeEach
  public void setUp() {
    super.init();
    testPlayer = getPlayerCharacter(CharacterClass.BLACK_MAGE);
    testCharacters.add(testPlayer);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getPlayerCharacter(CharacterClass.BLACK_MAGE));
    checkNotEqualsConstruction(new BlackMage(turns, BLACK_MAGE_NAME, CharacterClass.BLACK_MAGE,
            TEST_HP, TEST_ATK, TEST_DEF, testStaff, 100));
    checkNotEqualsConstruction(getCharacter(CharacterClass.THIEF));
  }

  @Override
  @Test
  public void equipWeaponTest() {
    equipWeapon(testKnife);
  }
}
