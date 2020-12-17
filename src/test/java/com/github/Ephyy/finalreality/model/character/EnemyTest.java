package com.github.Ephyy.finalreality.model.character;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    testPlayer = getPlayerCharacter(CharacterClass.KNIGHT);
    testCharacters.add(testEnemy);
  }

  @Test
  void killPlayerCharacterTest() {
    assertTrue(testPlayer.isAlive());
    Enemy bigEnemy = new Enemy(turns, ENEMY_NAME, 1000, 1000,
            50, 10);
    bigEnemy.attack(testPlayer);
    assertFalse(testPlayer.isAlive());
    assertEquals(0, testPlayer.getHp());
  }

  @Test
  void attackTest() {
    assertEquals(100, testPlayer.getHp());
    testEnemy.attack(testPlayer);
    assertEquals(testPlayer.getHp(), 95);
  }

  @Test
  void attackDeadCharacterTest() {
    assertTrue(testEnemy.canAttack(testPlayer));
    testPlayer.setLifeDead();
    assertFalse(testPlayer.isAlive());
    assertFalse(testEnemy.canAttack(testPlayer));
  }

  @Override
  @Test
  public void constructorTest() {
    checkEqualsConstruction(getEnemy(ENEMY_NAME, 10));
    checkNotEqualsConstruction(getEnemy(ENEMY_NAME, 11));
    checkNotEqualsConstruction(getEnemy("Skeleton", 10));
    checkNotEqualsConstruction(getPlayerCharacter(CharacterClass.THIEF));
  }
}