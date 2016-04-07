package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Q2 {

	private Game game;
	private Timer timer;

	public Q2(Game g, Timer timer) {
		game = g;
		this.timer = timer;
	}

	public void render(Graphics g) {

		g.setColor(Color.cyan);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		g.setColor(Color.white);
		g.fillOval(10, 10, 50, 50);
		g.setColor(Color.white);
		Font fnt = new Font("arial black", 1, 40);
		g.setFont(fnt);
		// g.drawString("1", 20, 50);
		g.fillRect(100, 100, 1000, 100);
		g.setColor(Color.red);
		g.drawString("What nationality is Mario?", 150, 150);
		g.fillRect(100, 250, 800, 100);
		g.fillRect(100, 400, 800, 100);
		g.fillRect(100, 550, 800, 100);
		g.fillRect(100, 700, 800, 100);
		g.setColor(Color.cyan);
		g.drawString("American", 120, 290);
		g.drawString("Japanese", 120, 440);
		g.drawString("Italian", 120, 590);
		g.drawString("Mexican", 120, 740);
		timer.render(g);
	}

	public void tick() {
		timer.tick();
		
	}
	
	public void start(){
		timer.setTime(9);
		timer.start();
	}
}
