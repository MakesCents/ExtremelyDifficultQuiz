package src;

import java.awt.*;

public class Q3 {

	private Timer timer;
	
	public Q3(Game game, Timer timer){
		this.timer = timer;
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
		g.drawString("How much is 10 + 10?", 150, 150);
		g.fillRect(100, 250, 800, 100);
		g.fillRect(100, 400, 800, 100);
		g.fillRect(100, 550, 800, 100);
		g.fillRect(100, 700, 800, 100);
		g.setColor(Color.cyan);
		g.drawString("1010", 120, 290);
		g.drawString("4", 120, 440);
		g.drawString("100", 120, 590);
		g.drawString("20", 120, 740);
		timer.render(g);
	}
	
	public void tick(){
		timer.tick();
		
	}
	
	public void start(){
		timer.setTime(9);
		timer.start();
	}
}
