/*
 * c2017-2024 Courtney Brown 
 * Class: Main Class for Hello World for CC3 Class Projects streaming MIDI, etc.
 * Description: Demonstration of MIDI file manipulations, etc. & 'MelodyPlayer' sequencer, 2024 - add processing/interactivity
 * 
 * Prescott Lau
 * October 10th, 2024
 * This is the Main class for the Java MIDI Project Game.
 * This is based from Courtney Brown's Hello World for CC3 Class Projects 
 * to help setup the MIDI functions.
 * 
 */

 package com.sound_game;

 //importing the JMusic stuff
 import java.nio.file.FileSystem;
 import java.nio.file.FileSystems;
 import java.util.ArrayList;

import processing.core.PApplet;
 
 //make sure this class name matches your file name, if not fix.
 public class App extends PApplet {
	 
	 //make cross-platform
	 static FileSystem sys = FileSystems.getDefault();
 
	 //the getSeperator() creates the appropriate back or forward slash based on the OS in which it is running -- OS X & Windows use same code :) 
	 static String filePath = "mid"  + sys.getSeparator(); // path to the file folder -- you can change this to your file
																 // location/name

	String[] midiFiles = {"Alpha_Value", "Enemy_Touch_Avatar", "Game_Over", "Game_Win", "Power_Up_Gain_Health", "Power_Up_Gain_Coins", "Power_Up_Lose_Coins", "Power_Up_Lose_Health", "Touch_Coins", "Touch_Power_Up", "Wall_Coins" , "Wall_Enemies", "Wall_Power_Up", "Enemy_Enemy", "Fake", "Alpha_Value_Reset"};
 
	MelodyManager melodyManager = new MelodyManager();

	//Static constants that name the different MIDI files for the subclasses.
	
	static final int ALPHA_VALUE_D_MID = 0;
	static final int ENEMY_AVATAR_MID = 1;
	static final int GAME_OVER_MID = 2;
	static final int GAME_WIN_MID = 3;
	static final int PU_GAIN_HEALTH_MID = 4;
	static final int PU_GAIN_COINS_MID = 5;
	static final int PU_LOSE_COINS_MID = 6;
	static final int PU_LOSE_HEALTH_MID = 7;
	static final int AVATAR_COINS_MID = 8;
	static final int AVATAR_POWER_UP_MID = 9;
	static final int WALL_COINS_MID = 10;
	static final int WALL_ENEMIES_MID = 11;
	static final int WALL_POWER_UP_MID = 12;
	static final int ENEMY_ENEMY_MID = 13;
	static final int FAKE_MID = 14;
	static final int ALPHA_VALUE_RESET_MID = 15;
	
	


	//add the game stuff!
	ArrayList<GameController> game = new ArrayList<>();
	int curState = GameController.GAME_PLAY;

	 public static void main(String[] args) {
		 PApplet.main("com.sound_game.App");		
	 }
 
	 public void settings()
	 {
		 size(500, 500);
	 }
 
	 //doing all the setup stuff for the midi and also make the background black and initializes the game.
	 public void setup() {
 
		 background(0);
		 addMidiFiles();
		 melodyManager.start(1); //here to test

		 initGame();
	 }

	 //initialize everything for our game!
	 public void initGame()
	 {
		game.add( new Particle_Container(this) );
		game.add( new GameEndController(this) );
		game.add( new GameWinController(this) );
	 }

	 //add all the midi files to the program!
	 public void addMidiFiles()
	 {
		for(int i = 0; i < midiFiles.length; i++)
		{
			melodyManager.addMidiFile(filePath + midiFiles[i] + ".mid");
		}
	 }
 
	 //play the melody in real-time
	 public void draw()
	 {
		 melodyManager.playMelodies(); 
		 game.get(curState).draw(); //draw the game

		 //change the game state:
		 int next = game.get(curState).switchController();
		 if (next != GameController.DO_NOT_CHANGE)
		 {
			game.get(curState).reset();
			curState = next;
		 }

	 }
 
	 //gets the keyPressed function for each game state
	 public void keyPressed() 
	 {
		 game.get(curState).keyPressed();
	 }

	 //gets the mouseDragged function for each game state
	 public void mouseDragged() 
	 {
		 game.get(curState).mouseDragged();
	 }

	 //provide access to melodyManager
	 public MelodyManager getMelodyManager()
	 {
		return melodyManager;
	 }
 }