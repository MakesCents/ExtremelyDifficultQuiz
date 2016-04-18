package src;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import src.Game.STATE;

public class Timer {

	private int time = 0, counter = 0;
	private boolean running = false;
	private BufferedImage[] images = new BufferedImage[10];
	private Game game;

	public Timer(Game game){
		this.game = game;

		BufferedImageLoader load = new BufferedImageLoader();
		try {
			for(int i =0; i<10;i++){
				images[i]=load.loadImage("/res/number"+i+".png");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void render(Graphics g){
		int tens = time/10;
		int ones = time%10;

		if (tens > 0 && running){
			g.drawImage(images[tens], 12, 17, game);
			g.drawImage(images[ones], 30, 17, game);
		}else if (running){
			g.drawImage(images[ones], 20, 17, game);
		}
	}

	public void tick(){
		counter++;
		if (counter == 60 && running){
			time--;
			counter = 0;
		}else if (running == false){
			counter = 0;
		}
	}

	public void stop(){
		running = false;
	}

	public void start(){
		running = true;
	}

	public void setTime(int time){
		this.time = time;
	}

	public int getTime(){
		return time;
	}
}
