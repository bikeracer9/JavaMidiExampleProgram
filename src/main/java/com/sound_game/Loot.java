/*
 * Prescott Lau
 * September 30th
 * This is the Loot Class, which are coins that allows a user to win the game!
 */
package com.sound_game;

import processing.core.PApplet;

public class Loot extends NPC {

    //loot is yellow and spawns randommly
    Loot(PApplet main_)
    {
        super(main_, 25, main_.color(255,255,0));
    }
    

}
