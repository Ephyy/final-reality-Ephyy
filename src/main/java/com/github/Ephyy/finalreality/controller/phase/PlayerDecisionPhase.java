package com.github.Ephyy.finalreality.controller.phase;

import com.github.Ephyy.finalreality.model.character.player.IPlayerCharacter;
import com.github.Ephyy.finalreality.model.weapon.IWeapon;

public class PlayerDecisionPhase extends Phase {

  @Override
  public boolean isPlayerDecisionPhase() {
    return true;
  }

  @Override
  public void attackDecision() {
    controller.setPhase(new SelectingAttackTargetPhase());
  }

  @Override
  public void changeWeaponDecision(IWeapon newWeapon) {
    controller.equipWeapon(newWeapon, (IPlayerCharacter) controller.getCurrentCharacter());
  }
}
