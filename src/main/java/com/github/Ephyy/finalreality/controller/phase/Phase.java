package com.github.Ephyy.finalreality.controller.phase;

import com.github.Ephyy.finalreality.controller.GameController;
import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.weapon.IWeapon;

import java.util.Random;

/**
 * Class that represent a phase in the game (State Pattern)
 */
public class Phase {
  protected GameController controller;

  /**
   * Set the controller that will implement the phases of the game.
   * @param controller controller of the game
   */
  public void setController(GameController controller) {
    this.controller = controller;
  }

  protected void changePhase(final Phase phase) {
    controller.setPhase(phase);
  }

  protected void toTurnBeginningError() throws InvalidTransitionException {
    throw new InvalidTransitionException("Can't change to the turn beginning phase");
  }

  protected void toDecisionPhaseError() throws InvalidTransitionException {
    throw new InvalidTransitionException("Can't change to Decision phase");
  }

  protected void toAttackTargetError() throws InvalidTransitionException {
    throw new InvalidTransitionException("Can't change to the attack target phase");
  }

  protected void changeWeaponError() throws InvalidTransitionException {
    throw new InvalidTransitionException("Can't change weapon at this phase");
  }

  /**
   * Try to start a new turn and move to the decision phase or selecting target phase.
   * @throws InvalidTransitionException
   */
  public void beginningTurn() throws InvalidTransitionException {
    toDecisionPhaseError();
  }

  /**
   * Try to make the attack decision of the player.
   * @throws InvalidTransitionException
   */
  public void attackDecision() throws InvalidTransitionException {
    toAttackTargetError();
  }

  /**
   * Try to change weapon to the current player character.
   * @throws InvalidTransitionException
   */
  public void changeWeaponDecision(IWeapon newWeapon) throws InvalidTransitionException {
    changeWeaponError();
  }

  /**
   * Try to attack the target that the player/enemy want to attack
   * @param opponent the opponent that its under attack
   * @throws InvalidTransitionException
   */
  public void attackTarget(ICharacter opponent) throws InvalidTransitionException {
    toTurnBeginningError();
  }

  /**
   * Try to start a new turn or wait for a ready character.
   */
  public void turnEnded() {
  }

  /**
   * Start a new turn if the turn queue is empty.
   */
  public void characterReady() {
  }

  /**
   * if this is the turn beginning phase.
   */
  public boolean isTurnBeginning() {
    return false;
  }

  /**
   * if this is the player decision phase.
   */
  public boolean isPlayerDecisionPhase() {
    return false;
  }

  /**
   * if this is the selecting target to attack phase.
   */
  public boolean isSelectingAttackTarget() {
    return false;
  }

  /**
   * if this is the waiting for a ready character phase.
   */
  public boolean isWaitingForReadyCharacter() {
    return false;
  }

  /**
   * if this is the game over phase.
   */
  public boolean isGameOver() {
    return false;
  }

  /**
   * Move to game over phase when all the player characters are defeated.
   */
  public void enemyVictory() {
    changePhase(new GameOverPhase());
  }

  /**
   * Move to game over phase when all the enemies characters are defeated.
   */
  public void playerVictory() {
    changePhase(new GameOverPhase());
  }
}