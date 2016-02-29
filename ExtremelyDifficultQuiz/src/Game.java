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
	private boolean running = false;
	
	public Game(){
//		BackgroundMusic music = new BackgroundMusic();
//		music.music();
		StartMenu start = new StartMenu(WIDTH,HEIGHT,"EXTREMELY DIFFICULT QUIZ");
		//window = new Window(WIDTH, HEIGHT, "Extremely Difficult Quiz");
		start();
	}
	
	public void start(){
		running = true;
		run();
	}
	
	public void stop(){
		running = false;
	}
	
	public void run(){
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1){
				tick();
				delta--;
			}
			if (running){
				render();
			}
			frames++;
			
			//Display the FPS in the console
			if (System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	public void tick(){
		
	}
	
	public void render(){
		
	}
	
	public static void main(String[] args){
		Game game = new Game();
	}
}
