package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Menu {

	private String start = new String("Start");
	private String sound = new String("Sound On");

	public Rectangle startBtn = new Rectangle((Game.WIDTH - 200) / 2, 400, 200, 100);
	public Rectangle soundBtn = new Rectangle(Game.WIDTH - 225, 825, 100, 50);
	private BufferedImage title;
	private BufferedImage back;
	private BufferedImage logo;
	private BufferedImage finger;
	private BufferedImage link;

	private Game game;
	public boolean startClick = false, increasing = true, soundClick = true;
	private int counter;

	public Menu(Game game) {

		this.game = game;

		BufferedImageLoader loader = new BufferedImageLoader();
		try {

			logo = loader.loadImage("/res/sprite_logo1.png");

			title = loader.loadImage("/res/start.png");

			finger = loader.loadImage("/res/finger.png");

			back = loader.loadImage("/res/background.png");

			link = loader.loadImage("/res/linknoback2.PNG");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		Font fnt1 = new Font("arial", Font.ROMAN_BASELINE, 70);
		Font fnt2 = new Font("arial", Font.PLAIN, 20);
		g.setFont(fnt0);
		g.setColor(Color.yellow);
		g.drawImage(back, 0, 0, Game.WIDTH + 20, Game.HEIGHT + 20, game);
		g.drawImage(finger, 420 - counter, 400, 100, 100, game);
		g.setColor(Color.blue);
		g.setFont(fnt1);
		g.drawString(start, startBtn.x + 25, startBtn.y + 70);
		g.setFont(fnt2);
		g.drawImage(title, 105, 200, 1000, 800, game);
		g.drawString(sound, (soundBtn.x + sound.length() / 2 + 3), soundBtn.y + 35);
		g.drawImage(logo, 1100, 800, 100, 100, game);
		g.drawImage(link, 0, -140, 1200, 1000, game);
		if (startClick == true) {
			g.setColor(Color.white);
			g2d.draw(startBtn);
		} else {
			g.setColor(Color.blue);
			g2d.draw(startBtn);
		}
		if (soundClick == true) {
			g.setColor(new Color(0, 128, 13));
			g2d.draw(soundBtn);
		} else {
			g.setColor(Color.red);
			g2d.draw(soundBtn);
		}
	}

	public void setClick() {
		if (startClick == false)
			startClick = true;
		else
			startClick = false;
	}

	public void tick() {
		if (increasing)
			counter++;
		else
			counter--;
		if (counter == 30) {
			increasing = false;
		} else if (counter == 0) {
			increasing = true;
		}
	}

	public void setSound() {
		if (soundClick == false)
			soundClick = true;
		else
			soundClick = false;
	}

}
