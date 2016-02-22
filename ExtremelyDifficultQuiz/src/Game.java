/*
 * Author: Timothy Buente
 * Date: 2/18/2016
 * 
 * Gonna try and make a window pop up for the game.
 */

package src;

public class Game {

	public Window window;
	public static int WIDTH = 1200, HEIGHT = 900;
	
	public Game(){
//		BackgroundMusic music = new BackgroundMusic();
//		music.music();
		window = new Window(WIDTH, HEIGHT, "Extremely Difficult Quiz");
	}
	
	public void start(){
		
	}
	
	public void stop(){
		
	}
	
	public void run(){
		
	}
	public static void main(String[] args){
		Game game = new Game();
	}
}
