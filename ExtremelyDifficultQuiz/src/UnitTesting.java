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
	
	
	public void setUp() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		game = new Game();
		game.setVisible(true);
		
	}

	public void testIsShowing() {
		assertTrue(game.isShowing());
	}

	public void testMoveOntoNextScreen() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		game = new Game();		
		menu = new Menu(game);
		correct = new Correct(game);
		MouseInput sdf = new MouseInput(menu, game, correct);
		MouseEvent me = new MouseEvent(game, 0, 0, 0, ((Game.WIDTH-200)/2)+50, 450, 0, false);
		sdf.mousePressed(me);
		assertTrue(Game.state == STATE.Q1);
	}
	
//	public void testSoundWorking() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
//		game = new Game();
//		assertTrue(PlayAudio.clip.isRunning());
//	}
	
}
