package com.github.Ephyy.finalreality.controller.phase;

public class WaitingForCharacter extends Phase {

  @Override
  public void characterReady() {
    controller.setPhase(new TurnBeginningPhase());
  }

  @Override
  public boolean isWaitingForReadyCharacter() {
    return true;
  }
}
