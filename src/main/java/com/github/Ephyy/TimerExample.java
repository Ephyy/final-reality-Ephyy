package com.github.Ephyy;

import com.github.Ephyy.finalreality.model.character.ICharacter;
import com.github.Ephyy.finalreality.model.character.CharacterClass;
import com.github.Ephyy.finalreality.model.character.player.AbstractPlayerCharacter;
import com.github.Ephyy.finalreality.model.character.player.Thief;
import com.github.Ephyy.finalreality.model.weapon.AbstractWeapon;
import com.github.Ephyy.finalreality.model.weapon.Knife;
import com.github.Ephyy.finalreality.model.weapon.WeaponType;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Ignacio Slater Muñoz.
 */
public class TimerExample {

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<ICharacter> queue = new LinkedBlockingQueue<>();
    Random rng = new Random();
    for (int i = 0; i < 10; i++) {
      // Gives a random speed to each character to generate different waiting times
      var weapon = new Knife("", 0, rng.nextInt(50), WeaponType.KNIFE);
      var character = new Thief(queue, Integer.toString(i),
              CharacterClass.THIEF, 100, 10, 5, null);
      character.equip(weapon);
      character.waitTurn();
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000);
    while (!queue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order
      System.out.println(queue.poll().getName());
    }
  }
}
