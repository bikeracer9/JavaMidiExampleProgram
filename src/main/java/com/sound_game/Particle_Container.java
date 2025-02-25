/*
 * Prescott Lau
 * Particle Engine 3 Assignment
 * September 24th, 2024
 * This file controls the particles!
 */

package com.sound_game;

import java.util.ArrayList;

public class Particle_Container extends GameController {
    //PApplet main; //the main class, which has all the processing functionality.

    /*
     * Below are all the ArrayLists for each of the different objects.
     */

    MelodyManager melodies = null; 
    Avatar avatar;

    ArrayList<NPC> npc;

    ArrayList<Loot> loot;
    int loot_count = 9;

    ArrayList<Enemy> enemies;
    int enemy_count = 8; //15

    ArrayList<Power_Up> PowerUp;
    int PowerUpCount = 3;
    
        ArrayList<Particle_Object> particle_Objects;
    
        public Particle_Container(App main_) 
        {
            super(main_);
            init(); //initialize all the objects
        }
    
    /*
     * This function initializes all the objects in the code.
     */
        public void init()
        {    
            melodies = main.getMelodyManager();

            avatar = new Avatar(main);
            npc = new ArrayList();
            loot = new ArrayList();
            enemies = new ArrayList();
            PowerUp = new ArrayList();
    
            for(int i = 0; i < loot_count; i++)
            {
                loot.add( new Loot(main) );
            }
    
            for(int i = 0; i < PowerUpCount; i++)
            {
                PowerUp.add( new Power_Up(main) );
            }
           
            for(int i = 0; i < enemy_count; i++)
            {
                enemies.add( new Enemy(main) );
            }
    
            //add all the NPC
            npc.addAll(loot);
            npc.addAll(enemies);
            npc.addAll(PowerUp);
            
            //add all the small particles to the big particle object ArrayList
            particle_Objects = new ArrayList();
            particle_Objects.add(avatar);
            particle_Objects.addAll(npc);
        }
    
        /*
         * This is the draw function, it calls other functions to make the code cleaner and easier to read.
         */
        public void draw()
        {
            main.background(0); //draw the background
            display(); //display all objects
            move(); //move the objects
            collisions(); //check collisions btwn circles
            text(); //add the text onto the screen.
    
            //check to see if we need to end the game
            nextController = GameController.DO_NOT_CHANGE;
    
            if( avatar.getHealth() <= 0 || avatar.getCoins() <= -5)//if the player dies, player loses or if the player gets a negative amount of coins
            {
                melodies.start(App.GAME_OVER_MID);
                nextController = GameController.GAME_END; //draws the end game screen
            }
    
            if( avatar.getCoins() >= 25) //if the player has more than 15 coins, player wins
            {
                melodies.start(App.GAME_WIN_MID);
                nextController = GameController.GAME_WIN; //draws the win game screen
            }
        }
    
        /*
         * This is the function that draws (displays) all the objects.
         */
        public void display()
        {
            main.rectMode(3);
            main.noStroke();
            for(int i = 0; i < particle_Objects.size(); i++)
            {
                particle_Objects.get(i).display();
            }
        }
        
        /*
         * This is the collision function for the avatar & npc objects & for the enemies to bounce off each other.
         */
        public void collisions()
        {
            for(int i = 0; i < npc.size(); i++)
            {
                avatar.collisions(npc.get(i));
                npc.get(i).collision(avatar);
            }
    
            for(int i = 0; i < enemies.size(); i++)
            {
                for(int j = i; j < enemies.size(); j++)
                {
                    if (enemies.get(i) != enemies.get(j))
                    {
                        enemies.get(i).collision(enemies.get(j), App.ENEMY_ENEMY_MID);
                    }
                }   
            }
    
        }
    
        public void move()
        {
            for(int i = 0; i < particle_Objects.size(); i++)
            {
                particle_Objects.get(i).move();
            }
        }
    
        //change the location of the avatar, hooked up w mouseDragged in main.
        public void setAvatarLocation(float x, float y)
        {
            avatar.setLocation(x, y);
        }
       
        //move avatar when mouse is dragged.
        public void mouseDragged()
        {
            setAvatarLocation(main.mouseX, main.mouseY);
        }
    

        //make the game harder! — Pressing the letter 'Q' on the keyboard changes the alpha value of the particles.
        //Pressing the 'W' key resets it
        public void keyPressed()
        {
            if (main.keyPressed)
            {
                if(main.key == 'Q' || main.key == 'q')
                {
                    for(int i = 0; i < npc.size(); i++)
                    {
                        npc.get(i).alphaValue = npc.get(i).alphaValue / 2;
                        melodies.start(App.ALPHA_VALUE_D_MID);
                        //particle_Objects.get(i).getAlpha() = particle_Objects.get(i).getAlpha() - 50;
                    }
                }

                if(main.key == 'E' || main.key == 'e')
                {
                    for(int i = 0; i < npc.size(); i++)
                    {
                        if(npc.get(i).alphaValue < 255)
                        {
                            npc.get(i).resetAlpha();
                            melodies.start(App.ALPHA_VALUE_RESET_MID);
                        }
                    }
                    
                }
            }
        }

        /*
         * Resets the game!
         */
        public void reset()
        {
            super.reset();
            init();
        }
        
        /*
         * Function to add text onto the screen.
         */
        public void text()
        {
            main.textSize(15);
            main.fill(255);
            main.text("Health: " + (int)avatar.getHealth(), 35, 35);
            main.text("Coins: " + (int)avatar.getCoins(), 35, 65);
            main.text("" + avatar.getMessage(), 35, 95);
        }

}
