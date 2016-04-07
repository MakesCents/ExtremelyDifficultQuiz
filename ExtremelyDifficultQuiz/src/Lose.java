package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Lose {

	private Game game;
	private BufferedImage lost;
	private int counter = 0;
	
	public Lose (Game game){
		this.game = game;
		
//		BufferedImageLoader load = new BufferedImageLoader();
//		try{
//			lost = load.loadImage("...");
//			
//		}catch(IOException e){
//			e.printStackTrace();
//		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, game.WIDTH + 12, game.HEIGHT + 12);
		Font f = new Font("arial black", 1, 50);
		g.setFont(f);
		g.setColor(Color.gray);
		g.drawString("You lost :('", 100, 100);
	}
	
	public void tick(){
		counter++;
		if (counter == 180){
			counter = 0;
			game.state = Game.STATE.MENU;
		}
	}
}
