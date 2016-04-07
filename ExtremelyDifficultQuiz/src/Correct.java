package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Correct {
	
	private int counter = 0, previous = 0, cookieX = 450, cookieY = 300, cookieSize = 300;
	private BufferedImage park, cookie1, cookie2, cookie3, cookie4;	
	private Game game;
	
	public Correct(Game game){
		this.game = game;
		
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
		g.drawImage(park, 0, 0, Game.WIDTH, Game.HEIGHT, game);
		Font f = new Font("arial black", 1, 50);
		g.setFont(f);
		g.setColor(Color.blue);
		g.drawString("CORRECT!", 500, 100);
		g.drawString("Here, take a cookie", 350, 700);
		//Every second there is byte taken out of the cookie
		//When the cookie is gone go to the next question
		
		if (counter < 60){
			g.drawImage(cookie1, cookieX, cookieY, cookieSize, cookieSize, game);
		}else if (counter < 120){
			g.drawImage(cookie2, cookieX, cookieY, cookieSize, cookieSize, game);
		}else if (counter < 180){
			g.drawImage(cookie3, cookieX, cookieY, cookieSize, cookieSize, game);
		}else if (counter  < 240){
			g.drawImage(cookie4, cookieX, cookieY, cookieSize, cookieSize, game);
		}
	}
	
	public void tick(){
		counter++;
		if (counter == 300){
			if (!game.stack.isEmpty()) {
				Game.state = Game.STATE.valueOf("Q" + game.stack.pop());
				counter = 0;
			}
			else
				Game.state = Game.STATE.MENU;
		}
		
	}
	
	public void setPrevious(int p){
		previous = p;
	}
}
