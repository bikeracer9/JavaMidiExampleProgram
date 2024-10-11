/*
 * Prescott Lau
 * September 30th
 * This class is the avatar class. It represents the user & moves with mouseDrag.
 */

package com.sound_game;

public class Avatar extends Particle_Object{

    int health = 3; //health, determines when the game ends (loses).
    int coins = 0; //coins - determines when the game ends (wins!)
    float  random_number = (int)main.random(0,4);
    String message = ""; // prints out a message for power up object.

    Avatar(App main_)
    {
        super(main_, 30, main_.color(0,255,0), 255);
        x = main.width/2;
        y = main_.height/2;
    }

    //display the object
    void display()
    {
        super.display();
        main.ellipse(x, y, size, size);
    }

    void setLocation(float x_, float y_)
    {
        x = x_;
        y = y_;
    }

    //if a collision happened, deduct health!
    void collisions(Particle_Object object)
    {   
        hit = isHit(object);
        if (hit)
        {
            if(object instanceof Enemy)
            {
                main.fill(255,0,0, 200); //code to display a red box on the screen when you lose health
                main.rectMode(0);
                main.rect(0,0,800,800);
                health--;
                System.out.println("Health = " + health);
            }

            if(object instanceof Loot)
            {
                coins++;
                System.out.println("Coins = " + coins);
            }

            if(object instanceof Power_Up) //randomly will do something interesting, 
            {                              //look @ power_up class for more information!
                random_number = (int)main.random(0,7);
                if(random_number == 0)
                {
                    health += 2;
                    message = "Gave you 2 extra Lives!";
                    System.out.println("Health = " + health);
                    melodies.start(App.PU_GAIN_HEALTH_MID);
                }
                else if(random_number == 1)
                {
                    coins += 3;
                    message = "Gave you 3 extra Coins!";
                    System.out.println("Coins = " + coins);
                    melodies.start(App.PU_GAIN_COINS_MID);
                }
                else if(random_number == 2)
                {
                    main.fill(255,0,0, 190); //code to display a red box on the screen when you lose health
                    main.rectMode(0);
                    main.rect(0,0,800,800);
                    health -= 2;
                    message = "Took away 2 Lives!";
                    System.out.println("Health = " + health);
                    melodies.start(App.PU_LOSE_HEALTH_MID);
                }
                else if(random_number == 3)
                {
                    coins -= 3;
                    message = "Took away 3 Coins!";
                    System.out.println("Coins = " + coins);
                    melodies.start(App.PU_LOSE_COINS_MID);
                }
                else if(random_number == 4 || random_number == 5  || random_number == 6  || random_number == 7)
                {
                    message = "";
                    System.out.println("Nothing happened...");
                    melodies.start(App.AVATAR_POWER_UP_MID);
                }
                System.out.println("Message = " + message);
                random_number = (int)main.random(0,4);
            }
        }
    }
    

    //getter for the health variable
    float getHealth()
    {
        return health;
    }

    //getter for coins!
    float getCoins()
    {
        return coins;
    }
    
    //getter for message!
    String getMessage()
    {
        return message;
    }
}
