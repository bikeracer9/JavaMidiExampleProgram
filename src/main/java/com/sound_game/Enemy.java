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

    void move()
    {
        super.move();
        if(y > (main.height - size/2)) //if the value of the ball on the Y axis is greater than
        {                   //the bottom of the screen value, then the ball will change directions.
            melodies.start(App.WALL_ENEMIES_MID);
        }

        if(y < 0) //if the value of the ball on the Y axis is greater than
        {        //the top of the screen value then, the ball will change directions.
            melodies.start(App.WALL_ENEMIES_MID);
        }

        if(x > (main.width - size/2)) //if the value of the ball on the X axis is greater than
        {                   //the right of the screen value, then the ball will change directions.
            melodies.start(App.WALL_ENEMIES_MID);
        }

        if(x < (0 + size/2)) //if the value of the ball on the X axis is greater than
        {        //the left of the screen value then, the ball will change directions.
            melodies.start(App.WALL_ENEMIES_MID);
        } 
    }
    
    //plays Enemy_Touch_Avatar sound when the Avatar touches an Enemy.
    void collision(Avatar avatar)
    {
        super.collision(avatar, App.ENEMY_AVATAR_MID);
    }
}
