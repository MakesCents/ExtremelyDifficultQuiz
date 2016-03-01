package src;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class Menu {

	private String start = new String("Start");
	private String sound = new String("Sound On");

	public Rectangle startBtn = new Rectangle((Game.WIDTH-200)/2, 400,200,100);
	public Rectangle soundBtn = new Rectangle(Game.WIDTH-225, 825,100,50);
	private Graphics newg;
	private Graphics2D newg2d;

	private BufferedImage image = new BufferedImage(Game.WIDTH,Game.HEIGHT,BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage background = null;

	private BufferedImage back;
	private BufferedImage logo;
	private BufferedImage title;
	private BufferedImage finger;
	private Menu menu;
	private Game game;
	private boolean startClick=false,increasing = true,soundClick=true;
	private int counter;



	public Menu(Game game){

		this.game=game;




		BufferedImageLoader loader = new BufferedImageLoader();
		try{

			logo = loader.loadImage("/sprite_logo1.png");

			title=loader.loadImage("/Start.png");

			finger = loader.loadImage("/finger.png");

			back=loader.loadImage("/background.png");



		}catch(IOException e){
			e.printStackTrace();
		}


	}

	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.black);
		g.fillRect(0, 0, 1300, 1000);
		Font fnt0 = new Font("arial",Font.BOLD,50);
		Font fnt1 = new Font("arial", Font.ROMAN_BASELINE,70);
		Font fnt2 = new Font("arial",Font.PLAIN,20);
		g.setFont(fnt0);
		g.setColor(Color.yellow);
		g.drawImage(back,0,0,1210,910, game);
		g.drawImage(finger, 420-counter, 400, 100, 100, game);
		g.setColor(Color.blue);
		g.setFont(fnt1);
		g.drawString(start, startBtn.x+25, startBtn.y+70);
		g.setFont(fnt2);
		
		g.drawString(sound, (soundBtn.x+sound.length()/2+3), soundBtn.y+35);
		g.drawImage(logo, 1100, 800, 100, 100, game);
		if(startClick == true){
			g.setColor(Color.white);
			g2d.draw(startBtn);
		}
		else{
			g.setColor(Color.blue);
			g2d.draw(startBtn);
		}
		if(soundClick == true){
			g.setColor(new Color(0, 128, 13));
			g2d.draw(soundBtn);
		}
		else{
			g.setColor(Color.red);
			g2d.draw(soundBtn);
		}
	}

	public void setClick(){
		if(startClick == false)
			startClick=true;
		else
			startClick = false;
	}

	public void tick(){
		if(increasing)
			counter++;
		else
			counter--;
		if(counter==30){
			increasing =false;
		}	
		else if(counter==0){
			increasing =true;
		}
	}
	public void setSound(){
		if(soundClick == false)
			soundClick=true;
		else
			soundClick = false;
	}

}
