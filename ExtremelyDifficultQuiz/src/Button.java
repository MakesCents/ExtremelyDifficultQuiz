package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Button {
	
	public Button(Graphics g, String s, int x, int y, int length, int width){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.white);
		g.drawString(s, x+s.length()/2, y+width/2);
		g.drawRect(x, y, length, width);
		
	}

}
