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
  private Enemy testEnemy;
  private Knight testPlayerCharacter;
  private IMage testMage;
  private IWeapon testWeapon;

  @BeforeEach
  void setUp() {
    controller = new GameController(MAX_PLAYER_CHARACTERS, MAX_ENEMIES_CHARACTERS);
    testEnemy = controller.newEnemy(10, 5, 2, 5);
    testPlayerCharacter = controller.newKnight(50, 10, 5,
            new Sword("Sword", 5, 10));
    testMage = controller.newBlackMage(100, 15, 3,
            new Staff("Staff", 10, 10),100);
    testWeapon = new Axe("Axe", 10, 20);
  }

  @Test
  void characterCreation() {
    controller.addToEnemies(testEnemy);
    assertTrue(controller.getEnemies().contains(testEnemy));
    controller.addToParty(testPlayerCharacter);
    assertTrue(controller.getParty().contains(testPlayerCharacter));
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
    assertEquals(50, controller.getCharacterHealthPoint(testPlayerCharacter));
    assertEquals(10, controller.getCharacterAttack(testPlayerCharacter));
    assertEquals(5, controller.getCharacterDefense(testPlayerCharacter));
    assertEquals(100, controller.getMageMana(testMage));
    assertEquals(5, controller.getEnemyWeight(testEnemy));
  }

  @Test
  void equipWeaponTest() {
    assertNotEquals(testWeapon, controller.getPlayerCharacterWeapon(testPlayerCharacter));
    controller.equipWeapon(testWeapon, testPlayerCharacter);
    assertEquals(testWeapon, controller.getPlayerCharacterWeapon(testPlayerCharacter));
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
    controller.attack(godEngineer, testEnemy);
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

  @Test
  void basicPhaseCombatTest() throws InterruptedException {
    assertTrue(controller.isTurnBeginning());
    assertFalse(controller.isGameOver());
    Enemy weakEnemy = controller.newEnemy(1,1,1, 50);
    controller.addToEnemies(weakEnemy);
    controller.addToParty(testPlayerCharacter);
    controller.startGame();
    Thread.sleep(6000);
    controller.tryToStartTurn();
    assertTrue(controller.isPlayerDecisionPhase());
    controller.tryAttackDecision();
    assertTrue(controller.isSelectingAttackTarget());
    controller.setTargetIndex(0);
    controller.tryToAttackTarget();
    assertTrue(controller.isGameOver());
  }

  @Test
  void basicPhaseEnemyCombatTest() throws InterruptedException {
    assertTrue(controller.isTurnBeginning());
    assertFalse(controller.isGameOver());
    Enemy strongEnemy = controller.newEnemy(100000,1000,100, 1);
    controller.addToEnemies(strongEnemy);
    controller.addToParty(testPlayerCharacter);
    controller.startGame();
    Thread.sleep(6000);
    controller.tryToStartTurn();
    assertTrue(controller.isSelectingAttackTarget());
    controller.tryToAttackTarget();
    assertTrue(controller.isGameOver());
  }

  @Test
  void startNewTurnTest() throws InterruptedException {
    controller.addToParty(testPlayerCharacter);
    Enemy newEnemy = controller.newEnemy(10, 10, 1, 1);
    controller.addToEnemies(newEnemy);
    controller.startGame();
    Thread.sleep(3000);
    controller.tryToStartTurn();
    assertEquals(newEnemy, controller.getCurrentCharacter());
    assertTrue(controller.isSelectingAttackTarget());
    controller.tryToAttackTarget();
    assertNotEquals(0, controller.getTurnsQueue().size());
    assertTrue(controller.isTurnBeginning());
    controller.tryToStartTurn();
    assertEquals(testPlayerCharacter, controller.getCurrentCharacter());
  }

  @Test
  void noReadyCharacterTest() throws InterruptedException {
    controller.addToParty(testPlayerCharacter);
    Enemy heavyEnemy = controller.newEnemy(100, 1, 10, 15);
    controller.addToEnemies(heavyEnemy);
    controller.startGame();
    Thread.sleep(2000);
    controller.tryToStartTurn();
    assertEquals(testPlayerCharacter, controller.getCurrentCharacter());
    controller.tryAttackDecision();
    controller.setTargetIndex(0);
    controller.tryToAttackTarget();
    assertTrue(controller.isTurnBeginning());
    controller.tryToStartTurn();
    assertEquals(heavyEnemy, controller.getCurrentCharacter());
    controller.tryToAttackTarget();
    assertEquals(0, controller.getTurnsQueue().size());
    assertTrue(controller.isWaitingForReadyCharacter());
    Thread.sleep(2000);
    assertNotEquals(0, controller.getTurnsQueue().size());
    assertTrue(controller.isTurnBeginning());
  }

  @Test
  void basicCombatTest() throws InterruptedException {
    controller.addToParty(testPlayerCharacter);
    controller.addToEnemies(testEnemy);
    Enemy weakEnemy = controller.newEnemy(1, 1, 1, 1);
    controller.addToEnemies(weakEnemy);
    controller.startGame();
    Thread.sleep(2000);
    controller.tryToStartTurn();
    assertTrue(controller.isSelectingAttackTarget());
    controller.tryToAttackTarget();
    assertTrue(controller.isTurnBeginning());
    controller.tryToStartTurn();
    assertTrue(controller.isSelectingAttackTarget());
    controller.tryToAttackTarget();
    assertTrue(controller.isTurnBeginning());
    controller.tryToStartTurn();
    controller.tryAttackDecision();
    controller.setTargetIndex(1);
    controller.tryToAttackTarget();
    assertFalse(controller.isCharacterAlive(weakEnemy));
    assertTrue(controller.isCharacterAlive(testEnemy));
    assertFalse(controller.isGameOver());
    assertTrue(controller.isTurnBeginning());
    controller.tryToStartTurn();
    assertEquals(testEnemy, controller.getCurrentCharacter());
    controller.tryToAttackTarget();
    assertTrue(controller.isCharacterAlive(testPlayerCharacter));
    assertTrue(controller.isWaitingForReadyCharacter());
    Thread.sleep(2000);
    assertTrue(controller.isTurnBeginning());
    controller.tryToStartTurn();
    assertEquals(testEnemy, controller.getCurrentCharacter());
    controller.tryToAttackTarget();
    assertTrue(controller.isCharacterAlive(testPlayerCharacter));
    assertTrue(controller.isTurnBeginning());
    controller.tryToStartTurn();
    assertEquals(testPlayerCharacter, controller.getCurrentCharacter());
    controller.tryAttackDecision();
    controller.setTargetIndex(0);
    controller.tryToAttackTarget();
    assertTrue(controller.isGameOver());
  }

  @Test
  void changeWeaponDecisionTest() throws InterruptedException {
    controller.addToParty(testPlayerCharacter);
    Enemy heavyEnemy = controller.newEnemy(1, 1, 1, 20);
    controller.addToEnemies(heavyEnemy);
    controller.startGame();
    Thread.sleep(2100);
    assertFalse(controller.isPlayerDecisionPhase());
    assertFalse(controller.isSelectingAttackTarget());
    assertFalse(controller.isGameOver());
    controller.tryToStartTurn();
    assertEquals(testPlayerCharacter, controller.getCurrentCharacter());
    assertTrue(controller.isPlayerDecisionPhase());
    IWeapon godSword = new Sword("BigSword", 10000, 1);
    controller.tryChangeWeaponDecision(godSword);
    assertEquals(godSword, controller.getPlayerCharacterWeapon(testPlayerCharacter));
    assertTrue(controller.isPlayerDecisionPhase());
  }
}
