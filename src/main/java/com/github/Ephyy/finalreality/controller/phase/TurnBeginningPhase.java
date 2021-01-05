package com.github.Ephyy.finalreality.controller.phase;

import com.github.Ephyy.finalreality.model.character.ICharacter;

public class TurnBeginningPhase extends Phase {

  @Override
  public boolean isTurnBeginning() {
    return true;
  }

  @Override
  public void beginningTurn() {
    controller.setCurrentCharacter(controller.getTurnsQueue().peek());
    if (controller.getCurrentCharacter().isPlayerCharacter()) {
      changePhase(new PlayerDecisionPhase());
    } else {
      changePhase(new SelectingAttackTargetPhase());
    }
  }
}
