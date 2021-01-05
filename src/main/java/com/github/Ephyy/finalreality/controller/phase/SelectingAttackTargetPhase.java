package com.github.Ephyy.finalreality.controller.phase;

import com.github.Ephyy.finalreality.model.character.ICharacter;

public class SelectingAttackTargetPhase extends Phase {

  @Override
  public void attackTarget(ICharacter opponent) {
    controller.attack(controller.getCurrentCharacter(), opponent);
  }

  @Override
  public void turnEnded() {
    if (!controller.getTurnsQueue().isEmpty()) {
      controller.setPhase(new TurnBeginningPhase());
    } else {
      controller.setPhase(new WaitingForCharacter());
    }
  }

  @Override
  public boolean isSelectingAttackTarget() {
    return true;
  }
}
