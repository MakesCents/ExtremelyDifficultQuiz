package src;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.Timer;


public class Time {

	private int clock = 0;
	private BufferedImage[] time = new BufferedImage[10];
	private Game game;
	private int num;
	private int done;
	private Timer timer;
	private int clockTens;
	private int clockOnes;

	private int tens;
	private int ones;

	public Time(Game g){
		game=g;
		ActionListener timerAction = new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				clock++;
				num--;
			}
		};
		timer=new Timer(1000,timerAction);
		BufferedImageLoader load = new BufferedImageLoader();
		try {
			for(int i =0; i<10;i++){
				time[i]=load.loadImage("/res/number"+i+".png");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void start(Graphics g, int num){
		this.num=num;
		g.drawImage(time[this.num-clock],20,20,game);
		tick();
	}
	public void render(Graphics g, int num){
		
		if(clock==0){
			this.num = num;
			done=num;
		}
		if(this.num>=10){
			tens=Integer.parseInt(Integer.toString(this.num).substring(0,1));
			ones=Integer.parseInt(Integer.toString(this.num).substring(1));
			
			g.drawImage(time[tens], 12, 17, game);
			g.drawImage(time[ones], 30, 17, game);
		}
		else{
			g.drawImage(time[this.num], 20, 17, game);
		}
		
		tick();
	}




	public void tick(){
		if(clock==done){
			clock=0;
			num=done+1;
			System.out.println("Time's Up!");
			game.state=Game.state.MENU;
		}
		else{
			timer.start();
		}
	}
}

