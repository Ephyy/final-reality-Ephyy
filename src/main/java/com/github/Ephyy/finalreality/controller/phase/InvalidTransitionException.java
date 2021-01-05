package com.github.Ephyy.finalreality.controller.phase;

/**
 * Create a exception that its throws when tha game cant change to a certain phase.
 */
public class InvalidTransitionException extends Exception {
  public InvalidTransitionException(String message) {
    super(message);
  }
}
