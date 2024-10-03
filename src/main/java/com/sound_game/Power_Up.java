/*
 * Prescott Lau
 * September 30th 2024
 * This class extends the NPC Class and creates small circles that have random abilities!
 * 
 * Random Ability #1 (if the random_number = 0): Can give you 2 extra lives! 
 * Random Ability #2 (if the random_number = 1): Can give you 3 extra coins!
 * Random Ability #3 (if the random_number = 2): Can take away 2 lives from you!
 * Random Ability #4 (if the random_number = 3): Can take away 3 coins from you!
 * Random Ability #5 (if the random_number = 4, 5, 6, or 7): Do nothing!
 */
package com.sound_game;

import processing.core.PApplet;

public class Power_Up extends NPC {

    Power_Up(PApplet main_)
    {
        super(main_, 25, main_.color(0,128,255));
    }

}
