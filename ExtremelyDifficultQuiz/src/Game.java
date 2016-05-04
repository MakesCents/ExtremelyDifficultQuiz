/*
 * Date: 2/26/2016
 *
 * Adding graphics
 */

package src;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final double WIDTH = 1200, HEIGHT = 900;
	public static double widthRatio = 1, heightRatio = 1;
	public static final String TITLE = "Extremely Difficult Quiz";

	private boolean running = false;
	private int[] highScores;
	private String[] highNames;
	private int playerScore = 0;
	
	private Thread thread;
	private Menu menu;
	private Handler handler;
	private Q1 q1;
	private Q2 q2;
	private Q3 q3;
	private Q4 q4;
	private Q5 q5;
	private Correct correct;
	private Lose lose;
	private Win win;
	private Score score;

	private Timer timer;
	public static PlayAudio PA = new PlayAudio();
	public Stack<Question> stack;

	public Game() {
		score = new Score(this);
		
		highScores = score.getScore();
		highNames = score.getNames();
		
		menu = new Menu(this, highScores, highNames);
		PA.Loop("res/bg.mp3");

		handler = new Handler(this);
		Dimension size = new Dimension((int) WIDTH, (int) HEIGHT);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);

		timer = new Timer(this);

		q1 = new Q1(this, timer);
		q2 = new Q2(this, timer);
		q3 = new Q3(this, timer);
		q4 = new Q4(this, timer);
		q5 = new Q5(this, timer);
		correct = new Correct(this, q2, q3);
		lose = new Lose(this);
		win = new Win(this);
		
		resetStack();

		this.addMouseListener(new MouseInput(menu, this, correct, q1, timer, score));

		this.addComponentListener(new ComponentInput(this));

		JFrame frame = new JFrame(TITLE);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.pack();
		frame.setLocationRelativeTo(null);

		start();
	}

	public void resetStack() {
		ArrayList<Integer> questionList = new ArrayList<Integer>();
		stack = new Stack<Question>();
		Random r = new Random();
		for (int x = 1; x <= 5; x++) {
			questionList.add(x);
		}
		while (stack.size() <= 4) {
			int num = r.nextInt(5) + 1;
			if (questionList.contains(num)) {
				if (num == 1) {
					stack.push(q1);
					questionList.remove(questionList.indexOf(1));
					System.out.println(1);
				} else if (num == 2) {
					stack.push(q2);
					questionList.remove(questionList.indexOf(2));
					System.out.println(2);
				} else if (num == 3) {
					stack.push(q3);
					questionList.remove(questionList.indexOf(3));
					System.out.println(3);
				} else if (num == 4) {
					stack.push(q4);
					questionList.remove(questionList.indexOf(4));
					System.out.println(4);
				} else if (num == 5) {
					stack.push(q5);
					questionList.remove(questionList.indexOf(5));
					System.out.println(5);
				}
			}
		}

	}

	public enum STATE {
		MENU, GAME, Q1, Q2, Q3, Q4, Q5, CORRECT, LOSE, WIN
	};

	public static STATE state = STATE.MENU;

	public void init() {

	}

	private synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop() {
		if (!running)
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

	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " Ticks, Fps " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}

	private void tick() {
		if (state == STATE.MENU) {
			menu.tick();
			highScores = score.getScore();
		} else if (state == STATE.CORRECT) {
			correct.tick();
		} else if (state == STATE.LOSE) {
			lose.tick();
		} else if (state == STATE.Q1) {
			q1.tick();
		} else if (state == STATE.Q2) {
			q2.tick();
		} else if (state == STATE.Q3) {
			q3.tick();
		} else if (state == STATE.WIN) {
			win.tick();
		} else if (state == STATE.Q4) {
			q4.tick();
		} else if (state == STATE.Q5) {
			q5.tick();
		}

		
	}

	public STATE getState() {
		return state;
	}

	private void render() {

		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		if (state == STATE.MENU) {
			menu.render(g);
		} else if (state == STATE.Q1) {
			q1.render(g);
		} else if (state == STATE.CORRECT) {
			correct.render(g);
		} else if (state == STATE.Q2) {
			q2.render(g);
		} else if (state == STATE.Q3) {
			q3.render(g);
		} else if (state == STATE.LOSE) {
			lose.render(g);
		} else if (state == STATE.WIN) {
			win.render(g);
		} else if (state == STATE.Q4) {
			q4.render(g);
		} else if (state == STATE.Q5) {
			q5.render(g);
		}
		
		Font fnt3 = new Font("arial", Font.PLAIN, Math.min((int)(Game.widthRatio*20) * 2, (int)(Game.heightRatio*20) * 2));
		g.setFont(fnt3);
		g.setColor(Color.white);
		g.drawString("" + playerScore, (int)(590 * Game.widthRatio), (int)(50 * Game.heightRatio));
		
		
		g.dispose();
		bs.show();
	}

	public void setRatio(int width, int height) {
		widthRatio = width / WIDTH;
		heightRatio = height / HEIGHT;
	}
	
	public void incrementScore(){
		playerScore++;
	}
	
	public void resetScore(){
		playerScore = 0;
	}
	
	public int getPlayerScore(){
		return playerScore;
	}
	
	public int[] getHighScores(){
		return highScores;
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();

	}

}