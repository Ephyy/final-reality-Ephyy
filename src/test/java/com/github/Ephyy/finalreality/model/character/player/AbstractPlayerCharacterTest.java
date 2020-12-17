package com.github.Ephyy.finalreality.model.character.player;

import com.github.Ephyy.finalreality.model.character.AbstractCharacterTest;
import com.github.Ephyy.finalreality.model.character.CharacterClass;
import com.github.Ephyy.finalreality.model.character.Enemy;

import java.util.EnumMap;
import java.util.Map;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.weapon.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Abstract class containing the common tests for all the player characters.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva
 * @see AbstractPlayerCharacter
 */
abstract class AbstractPlayerCharacterTest extends AbstractCharacterTest {

  @BeforeEach
  void setUp() {
    super.init();
  }

  @Override
  @Test
  public abstract void constructorTest();

  @Test
  public void attackTest() {
    assertEquals(100, testEnemy.getHp());
    int totalDamage = testPlayer.getEquippedWeapon().getDamage() + testPlayer.getAtk();
    assertEquals(25, totalDamage);
    testPlayer.attack(testEnemy);
    assertEquals(80, testEnemy.getHp());
  }

  @Test
  void killEnemyTest() {
    Enemy weakEnemy = new Enemy(turns, ENEMY_NAME, 1, 1,
            0, 1);
    assertTrue(weakEnemy.isAlive());
    testPlayer.attack(weakEnemy);
    assertFalse(weakEnemy.isAlive());
    assertEquals(0, weakEnemy.getHp());
  }
}