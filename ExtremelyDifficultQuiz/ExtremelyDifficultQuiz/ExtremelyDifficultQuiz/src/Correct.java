package src;

import java.awt.Color;
import java.awt.Graphics;

public class Correct {
	
	public void render(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, Game.WIDTH + 20, Game.HEIGHT + 20);
	}
}
