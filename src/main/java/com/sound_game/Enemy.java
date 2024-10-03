/*
 * Prescott Lau
 * Sepetember 30th 2024
 * This is the enemy class, it is an extension of the NPC class
 */
package com.sound_game;

import processing.core.PApplet;

public class Enemy extends NPC
{
    Enemy(PApplet main_)
    {
        super(main_, 45, main_.color(255,0,0));
    }
}
