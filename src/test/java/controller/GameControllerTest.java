package controller;

import com.github.Ephyy.finalreality.controller.GameController;
import com.github.Ephyy.finalreality.model.character.Enemy;
import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;
import com.github.Ephyy.finalreality.model.character.player.classes.common.Engineer;
import com.github.Ephyy.finalreality.model.character.player.classes.common.Knight;
import com.github.Ephyy.finalreality.model.character.player.classes.magic.IMage;
import com.github.Ephyy.finalreality.model.character.player.classes.magic.WhiteMage;
import com.github.Ephyy.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class GameControllerTest {

  private final int MAX_PLAYER_CHARACTERS = 2;
  private final int MAX_ENEMIES_CHARACTERS = 3;

  private GameController controller;
  private Enemy enemyTest;
  private Knight playerCharacterTest;
  private IMage mageTest;
  private IWeapon testWeapon;

  @BeforeEach
  void setUp() {
    controller = new GameController(MAX_PLAYER_CHARACTERS, MAX_ENEMIES_CHARACTERS);
    enemyTest = controller.newEnemy(100, 5, 1, 5);
    playerCharacterTest = controller.newKnight(200, 10, 5,
            new Sword("Sword", 5, 10));
    mageTest = controller.newBlackMage(100, 15, 3,
            new Staff("Staff", 10, 10),100);
    testWeapon = new Axe("Axe", 10, 20);
  }

  @Test
  void characterCreation() {
    controller.addToEnemies(enemyTest);
    assertTrue(controller.getEnemies().contains(enemyTest));
    controller.addToParty(playerCharacterTest);
    assertTrue(controller.getParty().contains(playerCharacterTest));
  }

  @Test
  void fullPartyTest() {
    assertEquals(0, controller.getParty().size());
    for (int i = 0; i < 10; i++) {
      IPlayerCharacter playerCharacterTest = controller.newThief(1,1, 1,
              null);
      controller.addToParty(playerCharacterTest);
    }
    assertEquals(MAX_PLAYER_CHARACTERS, controller.getParty().size());
    assertEquals(0, controller.getEnemies().size());
    for (int i = 0; i < 10; i++) {
      Enemy testEnemy = controller.newEnemy(1,1,1,1);
      controller.addToEnemies(testEnemy);
    }
    assertEquals(MAX_ENEMIES_CHARACTERS, controller.getEnemies().size());
  }

  @Test
  void characterAttributesTest() {
    assertEquals(200, controller.getCharacterHealthPoint(playerCharacterTest));
    assertEquals(10, controller.getCharacterAttack(playerCharacterTest));
    assertEquals(5, controller.getCharacterDefense(playerCharacterTest));
    assertEquals(100, controller.getMageMana(mageTest));
    assertEquals(5, controller.getEnemyWeight(enemyTest));
  }

  @Test
  void equipWeaponTest() {
    assertNotEquals(testWeapon, controller.getPlayerCharacterWeapon(playerCharacterTest));
    controller.equipWeapon(testWeapon, playerCharacterTest);
    assertEquals(testWeapon, controller.getPlayerCharacterWeapon(playerCharacterTest));
  }

  @Test
  void inventoryTest() {
    assertTrue(controller.getInventory().isEmpty());
    controller.addWeapon(testWeapon);
    assertTrue(controller.getInventory().contains(testWeapon));
  }

  @Test
  void turnTest() throws InterruptedException {
    Axe heavyAxe = new Axe("Axe", 100000, 20);
    Engineer godEngineer = controller.newEngineer(1000, 1000000, 1000, heavyAxe);
    controller.attack(godEngineer, enemyTest);
    assertFalse(controller.getTurnsQueue().contains(godEngineer));
    Thread.sleep(5000);
    assertTrue(controller.getTurnsQueue().contains(godEngineer));
  }

  @Test
  void victoryTest() {
    for (int i = 0; i < MAX_ENEMIES_CHARACTERS; i++) {
      controller.addToEnemies(controller.newEnemy(1,1,1,1));
    }
    WhiteMage godMage = controller.newWhiteMage(100,1000,1000,
            new Staff("Staff", 1000, 1), 10000);
    controller.addToParty(godMage);
    for (ICharacter enemy : controller.getEnemies()) {
      controller.attack(godMage, enemy);
    }
  }
}
