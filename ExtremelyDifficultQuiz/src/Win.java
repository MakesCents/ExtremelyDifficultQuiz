package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Win {

	private Game game;
	private int count = 0;

	public Win(Game game){
		this.game = game;

	}

	public void render (Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		Font fnt = new Font("arial black", 1, 40);
		g.setColor(Color.white);
		g.setFont(fnt);
		g.drawString("You WINNNNN!!!!", 100, 100);
		g.drawString("Score: " + game.score, 100, 300);
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
