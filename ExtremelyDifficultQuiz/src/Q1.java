package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Q1 {

	private Game game;
	private Time timer;

	public Q1(Game g){
		game=g;
		
		BufferedImageLoader load = new BufferedImageLoader();
		
		timer = new Time(game);
		
	}
	public void render(Graphics g){
		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, Game.WIDTH + 20, Game.HEIGHT + 20);
		g.setColor(Color.white);
		g.fillOval(10, 10, 50, 50);
		g.setColor(Color.white);
		Font fnt = new Font("arial black", 1, 40);
		g.setFont(fnt);
		//g.drawString("1", 20, 50);
		g.fillRect(100, 100, 1000, 100);
		g.setColor(Color.red);
		g.drawString("How many legs does an octopus have?", 150, 150);
		g.fillRect(100, 250, 800, 100);
		g.fillRect(100, 400, 800, 100);
		g.fillRect(100, 550, 800, 100);
		g.fillRect(100, 700, 800, 100);
		g.setColor(Color.cyan);
		g.drawString("4", 120, 290);
		g.drawString("8", 120, 440);
		g.drawString("7", 120, 590);
		g.drawString("Taco", 120, 740);
		timer.render(g, 15);
	}

	public void tick(){

	}
}
