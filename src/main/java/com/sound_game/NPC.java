/*
*   Prescott Lau
*   September 30th 2024
*   This is the NPC Class, the superclass for all the NPC objects (loot & enemies).
*/
package com.sound_game;

import processing.core.PApplet;

public class NPC extends Particle_Object{
    NPC(PApplet main_, float size_, int color_)
    {
        super(main_, size_, color_, 255);
        spawn();
    }

    void spawn()
    {
        x = main.random(main.width);
        y = main.random(main.height);

        xVel = main.random(-5,5);
        yVel = main.random(-5,5);
    }

    void display()
    {
        super.display();
        main.ellipse(x, y, size, size);
    }

    void collision(Avatar avatar)
    {
        if(isHit(avatar))
        {
            spawn();
        }
    }

    void collision(Enemy enemy)
    {
        if(isHit(enemy))
        {
            reverseDir();
        }
    }
}
