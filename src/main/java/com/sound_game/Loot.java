/*
 * Prescott Lau
 * September 30th
 * This is the Loot Class, which are coins that allows a user to win the game!
 */
package com.sound_game;

public class Loot extends NPC {

    //loot is yellow and spawns randommly
    Loot(App main_)
    {
        super(main_, 25, main_.color(255,255,0));
    }
    
    //plays Touch_Coins sound when Avatar touches Coins (Loot) object.
    void collision(Avatar avatar)
    {
        super.collision(avatar, 8);
    }
}
