/*
 * Author: Matthew Kinzler
 * Date: 2/26/2016
 * 
 * Adding graphics
 */

package src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public Window window;
	public static final int WIDTH = 1200, HEIGHT = 900;
	public static final String TITLE = "Extremely Difficult Quiz";

	private boolean running = false;
	private Thread thread;
	private Menu menu;
	private Handler handler;
	private Q1 q1;
	private Correct correct;

	public Game(){
		menu = new Menu(this);
		
		this.addMouseListener(new MouseInput(menu, this));
		handler=new Handler(this);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setMaximumSize(new Dimension(WIDTH,HEIGHT));
		setMinimumSize(new Dimension(WIDTH,HEIGHT));
		
		q1=new Q1(this);
		
		correct = new Correct();
		
		JFrame frame = new JFrame(TITLE);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	
		start();
	}
	
	
	public enum STATE{
		MENU,
		GAME,
		Q1,
		CORRECT
	};
	
	public static STATE state = STATE.MENU;

	public void init(){
	
		
	
	}
	private synchronized void start(){
		if(running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop(){
		if(!running)
			return;

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
	}

	public void run(){
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();

		while (running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + " Ticks, Fps " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	private void tick(){
		if(state == STATE.MENU){
			menu.tick();
		}
		
	}
	
	public STATE getState(){
		return STATE.MENU;
	}

	private void render(){

		BufferStrategy bs = this.getBufferStrategy();

		if(bs == null){
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		if(state==STATE.MENU){
		/////////////////////////////
//			g.setColor(Color.black);
//			g.fillRect(0, 0, 1200, 900);
		menu.render(g);
			
			
		/////////////////////////////
		}else if (state == STATE.Q1){
			q1.render(g);
		}else if (state == STATE.CORRECT){
			correct.render(g);
		}
		g.dispose();
		bs.show();
	}

	public static void main(String[] args){
		Game game = new Game();
		game.start();
		
	}
}
