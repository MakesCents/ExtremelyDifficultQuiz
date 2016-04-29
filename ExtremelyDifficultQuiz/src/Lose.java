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
		g.fillRect(0, 0, (int)(Game.widthRatio*(game.WIDTH + 12)), (int)(Game.heightRatio*(game.HEIGHT + 12)));
		Font f = new Font("arial black", 1, (int)(50*Math.min(Game.widthRatio, Game.heightRatio)));
		g.setFont(f);
		g.setColor(Color.gray);
		g.drawString("You lost :('", (int)(Game.widthRatio*100), (int)(Game.heightRatio*100));
	}

	public void tick(){
		counter++;
		if (counter == 180){
			counter = 0;
			game.stack.removeAllElements();
			game.resetStack();
			game.state = Game.STATE.MENU;
		}
	}
}