package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Q5 {


	//This is the spyro question


	private Game game;
	private Timer timer;

	public Q5(Game game, Timer timer){
		this.game = game;
		this.timer = timer;
	}

	public void render(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, Game.WIDTH + 20, Game.HEIGHT + 20);
		g.setColor(Color.white);
		g.fillOval(10, 10, 50, 50);
		g.setColor(Color.blue);
		Font fnt = new Font("arial black", 1, 40);
		g.setFont(fnt);
		//g.drawString("1", 20, 50);
		g.fillRect(100, 100, 1000, 100);
		g.setColor(Color.white);
		g.drawString("Where does Spyro want to go on vacation at the beginning of Spyro 2?", 150, 150);
		g.setColor(Color.blue);
		g.fillRect(100, 250, 800, 100);
		g.fillRect(100, 400, 800, 100);
		g.fillRect(100, 550, 800, 100);
		g.fillRect(100, 700, 800, 100);
		g.setColor(Color.white);
		g.drawString("To Sleep", 120, 290);
		g.drawString("Dragon Shore", 120, 440);
		g.drawString("Bed", 120, 590);
		g.drawString("Alabama", 120, 740);
		timer.render(g);
	}

	public void tick(){
		if (timer.getTime() == 0){
			game.state = Game.STATE.LOSE;
		}
	}

	public void start(){
		timer.setTime(9);
		timer.start();
	}
}
