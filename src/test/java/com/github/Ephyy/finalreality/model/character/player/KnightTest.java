package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.CharacterClass;
import com.github.Ephyy.finalreality.model.character.player.classes.common.Knight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test set for the Knight character.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
class KnightTest extends AbstractPlayerCharacterTest {

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @BeforeEach
  public void setUp() {
    super.init();
    testPlayer = getPlayerCharacter(CharacterClass.KNIGHT);
    testCharacters.add(testPlayer);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getPlayerCharacter(CharacterClass.KNIGHT));
    checkNotEqualsConstruction(new Knight(turns, KNIGHT_NAME, TEST_HP, TEST_ATK, TEST_DEF,
            testAxe));
    checkNotEqualsConstruction(getPlayerCharacter(CharacterClass.THIEF));
  }
}
