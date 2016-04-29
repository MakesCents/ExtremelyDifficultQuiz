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
		g.fillRect(0, 0, (int)(Game.widthRatio *Game.WIDTH) + 20, (int)(Game.heightRatio *Game.HEIGHT) + 20);
		Font f = new Font("arial black", 1, (int)(50*Math.min(Game.widthRatio, Game.heightRatio)));
		g.setFont(f);
		g.setColor(Color.blue);
		g.drawString("CORRECT!!!!", (int)(Game.widthRatio*100), (int)(Game.heightRatio*100));
		g.drawString("Want a cookie?", (int)(Game.widthRatio*100), (int)(Game.heightRatio*600));
		//Every second there is byte taken out of the cookie
		//When the cookie is gone go to the next question
		g.drawImage(park, (int)(Game.widthRatio*100), (int)(Game.heightRatio*150), (int)(Game.widthRatio*400), (int)(Game.heightRatio*400), game);
		if (counter < 60){
			g.drawImage(cookie1, (int)(Game.widthRatio*100), (int)(Game.heightRatio*700), (int)(Game.widthRatio*200), (int)(Game.heightRatio*200), game);
		}else if (counter < 120){
			g.drawImage(cookie2, (int)(Game.widthRatio*100), (int)(Game.heightRatio*700), (int)(Game.widthRatio*200), (int)(Game.heightRatio*200), game);
		}else if (counter < 180){
			g.drawImage(cookie3, (int)(Game.widthRatio*100), (int)(Game.heightRatio*700), (int)(Game.widthRatio*200), (int)(Game.heightRatio*200), game);
		}else if (counter  < 240){
			g.drawImage(cookie4, (int)(Game.widthRatio*100), (int)(Game.heightRatio*700), (int)(Game.widthRatio*200), (int)(Game.heightRatio*200), game);
		}
	}
	
	public void tick(){
		counter++;
		if (counter == 300){
			if(!game.stack.isEmpty()){
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