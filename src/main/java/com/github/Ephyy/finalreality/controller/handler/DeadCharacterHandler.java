package com.github.Ephyy.finalreality.controller.handler;

import com.github.Ephyy.finalreality.controller.GameController;
import com.github.Ephyy.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeEvent;

/**
 * Class that notify controller when a character dies.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class DeadCharacterHandler implements IEventHandler {
  private GameController controller;

  public DeadCharacterHandler(GameController c) {
    this.controller = c;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    controller.onCharacterDied((ICharacter) evt.getNewValue());
  }
}
