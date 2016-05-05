package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
 


public class Win {

	private Game game;
	private int count = 0;
	private BufferedImage victory;
	public Win(Game game){
		this.game = game;
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			victory = loader.loadImage("/res/Victory Screen.png");
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public void render (Graphics g){
		g.drawImage(victory, 0, 0, (int)(Game.widthRatio *Game.WIDTH) + 20, (int)(Game.heightRatio *Game.HEIGHT) + 20, game);
		Font fnt = new Font("arial black", 1, (int)(40*Math.min(Game.widthRatio, Game.heightRatio)));
		g.setColor(Color.white);
		g.setFont(fnt);
		g.drawString("You WINNNNN!!!!", (int)(Game.widthRatio*425), (int)(Game.heightRatio*500));
	}

	public void tick(){
		count++;
		if (count == 240){
			count = 0;
			game.resetStack();
			game.state = Game.STATE.MENU;
		}
	}
}
