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
        super.collision(avatar, App.AVATAR_COINS_MID);
    }

    void move()
    {
        super.move();
        if(y > (main.height - size/2)) //if the value of the ball on the Y axis is greater than
        {                   //the bottom of the screen value, then the ball will change directions.
            melodies.start(App.WALL_COINS_MID);
        }

        if(y < 0) //if the value of the ball on the Y axis is greater than
        {        //the top of the screen value then, the ball will change directions.
            melodies.start(App.WALL_COINS_MID);
        }

        if(x > (main.width - size/2)) //if the value of the ball on the X axis is greater than
        {                   //the right of the screen value, then the ball will change directions.
            melodies.start(App.WALL_COINS_MID);
        }

        if(x < (0 + size/2)) //if the value of the ball on the X axis is greater than
        {        //the left of the screen value then, the ball will change directions.
            melodies.start(App.WALL_COINS_MID);
        } 
    }
}
