/*
 * Prescott Lau
 * Sepetember 30th 2024
 * This is the enemy class, it is an extension of the NPC class
 */
package com.sound_game;

public class Enemy extends NPC
{
    Enemy(App main_)
    {
        super(main_, 45, main_.color(255,0,0));
    }

    //plays Enemy_Touch_Avatar sound when the Avatar touches an Enemy.
    void collision(Avatar avatar)
    {
        super.collision(avatar, 1);
    }
}
