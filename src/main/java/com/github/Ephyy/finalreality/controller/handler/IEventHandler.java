package com.github.Ephyy.finalreality.controller.handler;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This represent a Event that will be notified to the game controller.
 *
 * @author Ignacio Slater Muñoz.
 * @author Vicente Ardiles Silva.
 */
public interface IEventHandler extends PropertyChangeListener {

  void propertyChange(PropertyChangeEvent evt);
}
