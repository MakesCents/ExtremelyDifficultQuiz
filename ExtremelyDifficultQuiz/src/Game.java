/*
 * Date: 2/26/2016
 *
 * Adding graphics
 */

package src;
import java.awt.Canvas;
import java.awt.Dimension;
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

	private Timer timer;
//	public static PlayAudio PA = new PlayAudio();
	public Stack<Integer> stack;



	public Game(){
		menu = new Menu(this);
//		PA.Loop("res/bg.mp3");

		handler=new Handler(this);
		Dimension size = new Dimension((int) WIDTH, (int)HEIGHT);
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


		this.addMouseListener(new MouseInput(menu, this, correct, q1, timer));

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
	public void resetStack(){
		ArrayList<Integer> questionList = new ArrayList<Integer>();
		stack = new Stack<Integer>();
		Random r = new Random();
		for(int x = 1; x <= 5; x++){
			questionList.add(x);
		}
		while(stack.size()<=4)
		{
			int num = r.nextInt(5) + 1;
			if(questionList.contains(num)){
				stack.push(num);
				questionList.remove(questionList.indexOf(num));
				System.out.println(num);
			}
		}

	}

	public enum STATE{
		MENU,
		GAME,
		Q1,
		Q2,
		Q3,
		Q4,
		Q5,
		CORRECT,
		LOSE,
		WIN
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
		}else if (state == STATE.CORRECT){
			correct.tick();
		}else if (state == STATE.LOSE){
			lose.tick();
		}else if (state == STATE.Q1){
			q1.tick();
		}else if (state == STATE.Q2){
			q2.tick();
		}else if (state == STATE.Q3){
			q3.tick();
		}else if (state == STATE.WIN){
			win.tick();
		}else if (state == STATE.Q4){
			q4.tick();
		}else if (state == STATE.Q5){
			q5.tick();
		}

	}

	public STATE getState(){
		return state;
	}

	private void render(){

		BufferStrategy bs = this.getBufferStrategy();

		if(bs == null){
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		if(state==STATE.MENU){
			menu.render(g);
		}else if (state == STATE.Q1){
			q1.render(g);
		}else if (state == STATE.CORRECT){
			correct.render(g);
		}else if (state == STATE.Q2){
			q2.render(g);
		}else if (state == STATE.Q3){
			q3.render(g);
		}else if (state == STATE.LOSE){
			lose.render(g);
		}else if (state == STATE.WIN){
			win.render(g);
		}else if (state == STATE.Q4){
			q4.render(g);
		}else if (state == STATE.Q5){
			q5.render(g);
		}

		g.dispose();
		bs.show();
	}
	public void setRatio(int width, int height){
		widthRatio  = width/WIDTH;
		heightRatio = height/HEIGHT;
	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.start();

	}

}