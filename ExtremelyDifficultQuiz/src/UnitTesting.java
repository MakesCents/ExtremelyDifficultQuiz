package src;


import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import junit.framework.TestCase;
import src.Game.STATE;

public class UnitTesting extends TestCase {
	Menu menu;
	Game game;
	Correct correct;
	Q1 q1;
	Q2 q2;
	Q3 q3;
	Timer timer;
	MouseInput mi;
	MouseEvent meMenu;
	MouseEvent meQ1;
	MouseEvent meQ3;
	MouseEvent meQ4;

	
	
	
	public void setUp() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		game = new Game();
		menu = new Menu(game);
		
		correct = new Correct(game, q2, q3);
//		game.setVisible(true);
		timer = new Timer(game);
		mi = new MouseInput(menu, game, correct, q1, timer);
		meMenu = new MouseEvent(game, 0, 0, 0, 612, 450, 0, false);
		meQ1 = new MouseEvent(game, 0, 0, 0, 600, 600, 0, false);
		meQ3 = new MouseEvent(game, 0, 0, 0, 600, 450, 0, false);
		meQ4 = new MouseEvent(game, 0, 0, 0, 600, 300, 0, false);
	}

	
	public void testcorrectScreen(){
		mi.mouseReleased(meMenu);
		if(game.getState() == (Game.STATE.Q1)|| game.getState() == Game.STATE.Q2){
			mi.mouseReleased(meQ1);
		}else if(game.getState() == Game.STATE.Q3){
			mi.mouseReleased(meQ3);
		}else if(game.getState()== Game.STATE.Q4 || game.getState() == Game.STATE.Q5){
			mi.mouseReleased(meQ4);
		}
		assertTrue(game.getState() == Game.STATE.CORRECT);
	}
	public void testLoseScreen() throws InterruptedException{
		Thread.sleep(5000);
		assertTrue(game.getState() == STATE.GAME.LOSE);
	}
	public void testSoundClick(){
		
	}
}
