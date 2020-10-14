package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.CharacterClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test set for the Thief character.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
class ThiefTest extends AbstractPlayerCharacterTest {

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @BeforeEach
  public void setUp() {
    super.init();
    testPlayer = getPlayerCharacter(CharacterClass.THIEF);
    testCharacters.add(testPlayer);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getPlayerCharacter(CharacterClass.THIEF));
    checkNotEqualsConstruction(new Thief(turns, THIEF_NAME, CharacterClass.THIEF,TEST_HP, TEST_ATK,
            TEST_DEF, testBow));
    checkNotEqualsConstruction(getCharacter(CharacterClass.KNIGHT));
  }

  @Override
  @Test
  public void equipWeaponTest() {
    equipWeapon(testKnife);
  }
}
