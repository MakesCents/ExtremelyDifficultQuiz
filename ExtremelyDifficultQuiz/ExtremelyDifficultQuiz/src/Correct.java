package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Correct {
	
	private int counter = 0, previous = 0;
	private BufferedImage park, cookie1, cookie2, cookie3, cookie4;	
	private Game game;
	private Q2 q2;
	private Q3 q3;
	
	public Correct(Game game, Q2 q2, Q3 q3){
		this.game = game;
		this.q2 = q2;
		this.q3 = q3;
		
		BufferedImageLoader load = new BufferedImageLoader();
		try{
			park = load.loadImage("/res/DrParkonGiraffe.jpg");
			cookie1 = load.loadImage("/res/cookie1.png");
			cookie2 = load.loadImage("/res/cookie2.png");
			cookie3 = load.loadImage("/res/cookie3.png");
			cookie4 = load.loadImage("/res/cookie4.png");
			load.loadImage("/res/cookie5.png");
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void render(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Game.WIDTH + 20, Game.HEIGHT + 20);
		Font f = new Font("arial black", 1, 50);
		g.setFont(f);
		g.setColor(Color.blue);
		g.drawString("CORRECT!!!!", 100, 100);
		g.drawString("Want a cookie?", 100, 600);
		//Every second there is byte taken out of the cookie
		//When the cookie is gone go to the next question
		g.drawImage(park, 100, 150, 400, 400, game);
		if (counter < 60){
			g.drawImage(cookie1, 100, 700, 200, 200, game);
		}else if (counter < 120){
			g.drawImage(cookie2, 100, 700, 200, 200, game);
		}else if (counter < 180){
			g.drawImage(cookie3, 100, 700, 200, 200, game);
		}else if (counter  < 240){
			g.drawImage(cookie4, 100, 700, 200, 200, game);
		}
	}
	
	public void tick(){
		counter++;
		if (counter == 300){
			if (previous == 1){				//The mouselistener should pass the number of the last question so the correct class knows which class to change to
				Game.state = Game.STATE.Q2;
				q2.start();
			}else if (previous == 2){
				Game.state = Game.STATE.Q3;
				q3.start();
			}else if (previous == 50){
				Game.state = Game.STATE.MENU;
			}
			counter = 0;
		}
		
	}
	
	public void setPrevious(int p){
		previous = p;
	}
}
