package com.github.Ephyy.finalreality.model.character;

import com.github.Ephyy.finalreality.model.character.player.CharacterClass;
import com.github.Ephyy.finalreality.model.character.player.AbstractPlayerCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnemyTest extends AbstractCharacterTest {

  private static final String ENEMY_NAME = "Goblin";

  @BeforeEach
  void setUp() {
    basicSetUp();
    testCharacters.add(new Enemy(ENEMY_NAME, 10, turns));
  }

  @Test
  void constructorTest() {
    checkConstruction(new Enemy(ENEMY_NAME, 10, turns),
        testCharacters.get(0),
        new Enemy(ENEMY_NAME, 11, turns),
        new AbstractPlayerCharacter(ENEMY_NAME, turns, CharacterClass.THIEF));
  }
}