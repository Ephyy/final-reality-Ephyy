package com.github.Ephyy.finalreality.controller;

import com.github.Ephyy.finalreality.controller.handler.DeadCharacterHandler;
import com.github.Ephyy.finalreality.controller.handler.CharacterTurnHandler;
import com.github.Ephyy.finalreality.controller.handler.IEventHandler;
import com.github.Ephyy.finalreality.model.character.Enemy;
import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;
import com.github.Ephyy.finalreality.model.character.player.classes.common.Engineer;
import com.github.Ephyy.finalreality.model.character.player.classes.common.Knight;
import com.github.Ephyy.finalreality.model.character.player.classes.common.Thief;
import com.github.Ephyy.finalreality.model.character.player.classes.magic.BlackMage;
import com.github.Ephyy.finalreality.model.character.player.classes.magic.IMage;
import com.github.Ephyy.finalreality.model.character.player.classes.magic.WhiteMage;
import com.github.Ephyy.finalreality.model.weapon.IWeapon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Controller of the game.
 * The controller manages all the input received from de game's GUI.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class GameController {

  private IEventHandler deadCharacterEvent = new DeadCharacterHandler(this);
  private IEventHandler characterTurnEvent = new CharacterTurnHandler(this);

  private final int MAX_PLAYER_CHARACTER;
  private final int MAX_ENEMIES_CHARACTER;
  private List<ICharacter> party;
  private List<IWeapon> inventory;
  private List<ICharacter> enemies;
  protected final BlockingQueue<ICharacter> turnsQueue;

  /**
   * Creates the controller for a new game.
   *
   * @param maxPlayerCharacter the maximum number of characters that the player can have.
   * @param maxEnemies the maximum number of enemies that the cpuPlayer can have.
   */
  public GameController(final int maxPlayerCharacter, final int maxEnemies) {
    this.MAX_PLAYER_CHARACTER = maxPlayerCharacter;
    this.MAX_ENEMIES_CHARACTER = maxEnemies;
    this.party = new ArrayList<>();
    this.inventory = new ArrayList<>();
    this.enemies = new ArrayList<>();
    this.turnsQueue = new LinkedBlockingQueue<>();
  }

  /**
   * The action that the controller will do when a character is ready.
   *
   * @param character the character who is ready to make an action.
   */
  public void onCharacterReady(ICharacter character) {
  }

  /**
   * The action that the controller will do when a character finish his turn.
   *
   * @param character the character who finished his turn.
   */
  public void onTurnEnded(ICharacter character) {
    turnsQueue.remove(character);
    character.waitTurn();
  }

  /**
   * Check if one of the players has lost and declare a winner.
   *
   * @param deadCharacter the character who died.
   */
  public void onCharacterDied(ICharacter deadCharacter) {
    if (charactersDefeated(party)) {
      enemyVictory();
    }
    else if (charactersDefeated(enemies)) {
      playerVictory();
    }
  }

  private boolean charactersDefeated(List<ICharacter> charactersList) {
    for (ICharacter character: charactersList) {
      if (character.isAlive()) {
        return false;
      }
    }
    return true;
  }

  private void enemyVictory() {
  }

  private void playerVictory() {
  }

  /**
   * makes one character attack another.
   *
   * @param attacker the character who is attacking.
   * @param opponent the character who is being attacked.
   */
  public void attack(ICharacter attacker, ICharacter opponent) {
    attacker.attack(opponent);
  }

  /**
   * Equip a weapon to a player character.
   *
   * @param weapon the waeapon the weapon that will be equipped
   * @param playerCharacter the player character who will equip the weapon.
   */
  public void equipWeapon(IWeapon weapon, IPlayerCharacter playerCharacter) {
    weapon.equipWeapon(playerCharacter);
  }

  /**
   * @return all the enemies.
   */
  public List<ICharacter> getEnemies() {
    return enemies;
  }

  /**
   * @return all the player characters
   */
  public List<ICharacter> getParty() {
    return party;
  }

  /**
   * Add a new weapon to the player inventory
   * @param newWeapon the weapon tha will be added.
   */
  public void addWeapon(IWeapon newWeapon) {
    inventory.add(newWeapon);
  }

  /**
   * @return the inventory of the player.
   */
  public List<IWeapon> getInventory() {
    return inventory;
  }

  /**
   * @return the hp of the character.
   */
  public int getCharacterHealthPoint(ICharacter character) {
    return character.getHp();
  }

  /**
   * @return the attack of the character.
   */
  public int getCharacterAttack(ICharacter character) {
    return character.getAtk();
  }

  /**
   * @return the defense of the character.
   */
  public int getCharacterDefense(ICharacter character) {
    return character.getDef();
  }

  /**
   * @return the current weapon of a player character.
   */
  public IWeapon getPlayerCharacterWeapon(IPlayerCharacter playerCharacter) {
    return playerCharacter.getEquippedWeapon();
  }

  /**
   * @return the weight of an enemy character.
   */
  public int getEnemyWeight(Enemy enemy) {
    return enemy.getWeight();
  }

  /**
   * @return the mana of a mage character.
   */
  public int getMageMana(IMage mage) {
    return mage.getMana();
  }

  /**
   * Add a player character to his party.
   *
   * @param newPlayerCharacter the new character that will be added.
   */
  public void addToParty(IPlayerCharacter newPlayerCharacter) {
    if (party.size() < MAX_PLAYER_CHARACTER) {
      party.add(newPlayerCharacter);
    }
  }

  /**
   * Add a enemy character to the list of enemies.
   *
   * @param newEnemy the new enemy character that will be added.
   */
  public void addToEnemies(Enemy newEnemy) {
    if (enemies.size() < MAX_ENEMIES_CHARACTER) {
      enemies.add(newEnemy);
    }
  }

  /**
   * Create a new Knight character.
   *
   * @param hp the health point of the character
   * @param atk the attack of the character
   * @param def the defense of the character
   * @param initialWeapon the initial weapon that the character will have
   * @return the new Knight created
   */
  public Knight newKnight(int hp, int atk, int def, IWeapon initialWeapon) {
    Knight newKnight = new Knight(turnsQueue, "Knight", hp, atk, def, initialWeapon);
    newKnight.addDeathListener(deadCharacterEvent);
    newKnight.addTurnListener(characterTurnEvent);
    return newKnight;
  }

  /**
   * Create a new Thief character.
   *
   * @param hp the health point of the character
   * @param atk the attack of the character
   * @param def the defense of the character
   * @param initialWeapon the initial weapon that the character will have
   * @return the new Thief created
   */
  public Thief newThief(int hp, int atk, int def, IWeapon initialWeapon) {
    Thief newThief = new Thief(turnsQueue, "Thief", hp, atk, def, initialWeapon);
    newThief.addDeathListener(deadCharacterEvent);
    newThief.addTurnListener(characterTurnEvent);
    return newThief;
  }

  /**
   * Create a new Engineer character.
   *
   * @param hp the health point of the character
   * @param atk the attack of the character
   * @param def the defense of the character
   * @param initialWeapon the initial weapon that the character will have
   * @return the new Engineer created
   */
  public Engineer newEngineer(int hp, int atk, int def, IWeapon initialWeapon) {
    Engineer newEngineer = new Engineer(turnsQueue, "Engineer", hp, atk, def, initialWeapon);
    newEngineer.addDeathListener(deadCharacterEvent);
    newEngineer.addTurnListener(characterTurnEvent);
    return newEngineer;
  }

  /**
   * Create a new Black Mage character.
   *
   * @param hp the health point of the character
   * @param atk the attack of the character
   * @param def the defense of the character
   * @param initialWeapon the initial weapon that the character will have
   * @param mana the mana of the character
   * @return the new Black mage created
   */
  public BlackMage newBlackMage(int hp, int atk, int def, IWeapon initialWeapon, int mana) {
    BlackMage newBlackMage = new BlackMage(turnsQueue, "BlackMage", hp, atk, def,
            initialWeapon, mana);
    newBlackMage.addDeathListener(deadCharacterEvent);
    newBlackMage.addTurnListener(characterTurnEvent);
    return newBlackMage;
  }

  /**
   * Create a new Black Mage character.
   *
   * @param hp the health point of the character
   * @param atk the attack of the character
   * @param def the defense of the character
   * @param initialWeapon the initial weapon that the character will have
   * @param mana the mana of the character
   * @return the new Black mage created
   */
  public WhiteMage newWhiteMage(int hp, int atk, int def, IWeapon initialWeapon, int mana) {
    WhiteMage newWhiteMage = new WhiteMage(turnsQueue, "BlackMage", hp, atk, def,
            initialWeapon, mana);
    newWhiteMage.addDeathListener(deadCharacterEvent);
    newWhiteMage.addTurnListener(characterTurnEvent);
    return newWhiteMage;
  }

  /**
   * Create a new Enemy character
   *
   * @param hp the health point of the character
   * @param atk the attack of the character
   * @param def the defense of the character
   * @param weight
   * @return the new enemy created
   */
  public Enemy newEnemy(int hp, int atk, int def, int weight) {
    Enemy newEnemy = new Enemy(turnsQueue, "Goblin", hp, atk, def, weight);
    newEnemy.addDeathListener(deadCharacterEvent);
    newEnemy.addTurnListener(characterTurnEvent);
    return newEnemy;
  }

  /**
   * @return the turns queue of the game
   */
  public BlockingQueue<ICharacter> getTurnsQueue() {
    return turnsQueue;
  }
}
