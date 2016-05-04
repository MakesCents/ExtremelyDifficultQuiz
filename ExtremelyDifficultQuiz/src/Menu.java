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

	public Rectangle startBtn = new Rectangle(((int)(Game.widthRatio*(Game.WIDTH - 200) / 2)), (int)(Game.heightRatio*400), (int)(Game.widthRatio*200), (int)(Game.heightRatio*100));
	public Rectangle soundBtn = new Rectangle((int)Game.WIDTH - 225, 825, 100, 50);
	private BufferedImage title;
	private BufferedImage back;
	private BufferedImage logo;
	private BufferedImage finger;
	private BufferedImage link;

	private Game game;
	public boolean startClick = false, increasing = true, soundClick = true;
	private int counter;
	private int[] highScores;
	private String[] highNames;

	public Menu(Game game, int[] scores, String[] names) {
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
		
		highScores = scores;
		highNames = names;
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font fnt0 = new Font("arial", Font.BOLD, (int)(50*Math.min(Game.widthRatio, Game.heightRatio)));
		Font fnt1 = new Font("arial", Font.ROMAN_BASELINE, (int)(Math.min(Game.widthRatio, Game.heightRatio)*70));
		Font fnt2 = new Font("arial", Font.PLAIN, (int)(Game.widthRatio*20));
		g.setFont(fnt0);
		g.setColor(Color.yellow);
		g.drawImage(back, 0, 0, (int)(Game.widthRatio *Game.WIDTH) + 20, (int)(Game.heightRatio *Game.HEIGHT) + 20, game);
		g.drawImage(finger, (int)(Game.widthRatio * (420 - counter)), (int)(Game.heightRatio* 400), (int)(100 * Game.widthRatio), (int)(100 * Game.heightRatio), game);
		g.setColor(Color.blue);
		g.setFont(fnt1);
		
		g.drawString(start, ((int)(Game.widthRatio*(Game.WIDTH - (175)) / 2)), (int)(Game.heightRatio*400+(Game.heightRatio*75)));
		
		g.setFont(fnt2);
		g.drawImage(title, (int)(Game.widthRatio*105), (int)(Game.heightRatio*200), (int)(Game.widthRatio*1000), (int)(Game.heightRatio*800), game);
		
		g.drawString(sound, (int)(Game.widthRatio*(Game.WIDTH - 225)), (int)(Game.heightRatio*860));
		
		g.drawImage(logo, (int)(Game.widthRatio*1100), (int)(Game.heightRatio*800), (int)(Game.widthRatio*100), (int)(Game.heightRatio*100), game);
		startBtn.setSize(((int)(Game.widthRatio*200)), (int)(Game.heightRatio*100));
		startBtn.setLocation(((int)(Game.widthRatio*(Game.WIDTH - 200) / 2)), (int)(Game.heightRatio*400));
		soundBtn.setLocation((int)(Game.widthRatio*(Game.WIDTH - 225)), (int)(Game.heightRatio*825));
		soundBtn.setSize((int)(100*Game.widthRatio), (int)(50*Game.heightRatio));
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
		
		
		
		g.setColor(Color.black);
		g.fillRect((int)(1000 * Game.widthRatio), 0, (int)(200 * Game.widthRatio), (int)(220 * Game.heightRatio));
		g.setColor(Color.white);
		
		
		Font fnt3 = new Font("arial", Font.PLAIN, Math.min((int)(Game.widthRatio*20) * 2, (int)(Game.heightRatio*20) * 2));
		
		
		g.setFont(fnt3);
		for (int i = 0; i < 5; i++){
			g.drawString("" + highScores[i], (int)(1125 * Game.widthRatio), (int)((40 * (i + 1)) * Game.heightRatio));
		}
		
		for (int i = 0; i < 5; i++){
			g.drawString("" + highNames[i] + ":", (int)(1025 * Game.widthRatio), (int)((40 * (i + 1)) * Game.heightRatio));
		} 
	}

	public void setClick() {
		startClick = !startClick;
	}

	public void tick() {
		highScores = game.getHighScores();
		
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
		soundClick = !soundClick;
		if(soundClick){
			game.PA.Resume();
		}else{
			game.PA.Pause();
		}
	}
	public boolean getSound(){
		return soundClick;
	}

}