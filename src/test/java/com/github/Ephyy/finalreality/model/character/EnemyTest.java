package com.github.Ephyy.finalreality.model.character;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class that test an enemy character.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
class EnemyTest extends AbstractCharacterTest {

  @BeforeEach
  public void setUp() {
    super.init();
    testEnemy = getEnemy(ENEMY_NAME,10);
    testCharacters.add(testEnemy);
    testCharacters.add(testPlayer);
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getEnemy(ENEMY_NAME, 10));
    checkNotEqualsConstruction(getEnemy(ENEMY_NAME, 11));
    checkNotEqualsConstruction(getEnemy("Skeleton", 10));
    checkNotEqualsConstruction(getCharacter(CharacterClass.THIEF));
  }
}