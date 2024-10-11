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

public class Power_Up extends NPC {

    Power_Up(App main_)
    {
        super(main_, 25, main_.color(0,128,255));
    }

    //plays Touch_Power_Up sound when the Avatar touches a Power Up.
    void collision(Avatar avatar)
    {
        super.collision(avatar, App.FAKE_MID);
    }

    void move()
    {
        super.move();
        if(y > (main.height - size/2)) //if the value of the ball on the Y axis is greater than
        {                   //the bottom of the screen value, then the ball will change directions.
            melodies.start(App.WALL_POWER_UP_MID);
        }

        if(y < 0) //if the value of the ball on the Y axis is greater than
        {        //the top of the screen value then, the ball will change directions.
            melodies.start(App.WALL_POWER_UP_MID);
        }

        if(x > (main.width - size/2)) //if the value of the ball on the X axis is greater than
        {                   //the right of the screen value, then the ball will change directions.
            melodies.start(App.WALL_POWER_UP_MID);
        }

        if(x < (0 + size/2)) //if the value of the ball on the X axis is greater than
        {        //the left of the screen value then, the ball will change directions.
            melodies.start(App.WALL_POWER_UP_MID);
        } 
    }

}
