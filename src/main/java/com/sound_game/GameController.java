/*
 * Prescott Lau
 * September 30th
 * This class controls the gameplay and everything related to it.
 */
package com.sound_game;

public abstract class GameController {
    App main; //reference to the main class
    
    static final int DO_NOT_CHANGE = -1;
    static final int GAME_PLAY = 0;
    static final int GAME_END = 1;
    static final int GAME_WIN = 2;

    int nextController = DO_NOT_CHANGE;

    GameController(App main_)
    {
        main = main_;
    }

    public abstract void draw();
    public void mouseDragged()
    {
        //do nothing by default!
    }
    public void mousePressed()
    {
        //do nothing by default!
    }
    public void keyPressed()
    {
        //do nothing by default!
    }

    public int switchController()
    {
        return nextController;
    }

    //resets the next controller 
    public void reset()
    {
        nextController = DO_NOT_CHANGE; 
    }
}
