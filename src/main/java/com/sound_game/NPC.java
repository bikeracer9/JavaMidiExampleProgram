/*
*   Prescott Lau
*   September 30th 2024
*   This is the NPC Class, the superclass for all the NPC objects (loot & enemies).
*/
package com.sound_game;

public abstract class NPC extends Particle_Object{
    NPC(App main_, float size_, int color_)
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

    //checks to see if there was a collision with the avatar & plays index of midi file..
    void collision(Avatar avatar, int midiIindex)
    {
        if(isHit(avatar))
        {
            spawn();
            melodies.start(midiIindex);
        }
    }

    //subclasses must inherit this function!
    abstract void collision(Avatar avatar);

    //checks to see if there was a collision with the enemy & plays index of midi file.
    void collision(Enemy enemy, int midiIindex)
    {
        if(isHit(enemy))
        {
                reverseDir();
                melodies.start(midiIindex);   
        }
    }
}
