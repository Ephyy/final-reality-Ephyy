package com.github.Ephyy.finalreality.controller.handler;

import com.github.Ephyy.finalreality.controller.GameController;
import com.github.Ephyy.finalreality.model.character.ICharacter;

import java.beans.PropertyChangeEvent;

/**
 * Class that notify controller when a character start or finish their turn.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public class CharacterTurnHandler implements IEventHandler {
  private GameController controller;

  public CharacterTurnHandler(GameController c) {
    this.controller = c;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    if (evt.getPropertyName().equals("CharacterReady")) {
      controller.onCharacterReady((ICharacter) evt.getNewValue());
    } else {
      controller.onTurnEnded((ICharacter) evt.getNewValue());
    }
  }
}
