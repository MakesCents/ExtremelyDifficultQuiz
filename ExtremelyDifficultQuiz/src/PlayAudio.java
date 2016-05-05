package src;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlayAudio {

	FileInputStream FIS;
	BufferedInputStream BIS;
	FileInputStream FISBlip;
	BufferedInputStream BISBlip;
	public Player player;
	public Player playerBlip;

	public long pauseLocation;
	public long songTotalLength;
	public long songTotalLengthBlip;
	public static int count;
	public String fileLocation;
	private int songIndex = 0;
	private ArrayList<String> songs = new ArrayList<String>();
	public Stack<String> stack;


	public void Stop() {
		if (player != null) {
			player.close();
			pauseLocation = 0;
			songTotalLength = 0;

		}
	}

	public void Loop() {
		fileLocation = songs.get(songIndex);
		try {
			FIS = new FileInputStream(fileLocation);
			BIS = new BufferedInputStream(FIS);

			player = new Player(BIS);

			songTotalLength = FIS.available();

		} catch (FileNotFoundException | JavaLayerException ex) {
			Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
		}

		new Thread() {
			@Override
			public void run() {
				try {
					player.play();

					if (player.isComplete()) {
						songIndex++;
						if(songIndex > songs.size() - 1){
							songIndex = 0;
						}
						Loop();
					}
				} catch (JavaLayerException ex) {
					Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}.start();

	}

	public void Pause() {
		if (player != null) {
			try {
				pauseLocation = FIS.available();
				player.close();
			} catch (IOException ex) {
				Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void Resume() {
		try {
			FIS = new FileInputStream(fileLocation);
			BIS = new BufferedInputStream(FIS);

			player = new Player(BIS);

			FIS.skip(songTotalLength - pauseLocation);
		} catch (FileNotFoundException | JavaLayerException ex) {
			Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
		}

		new Thread() {
			@Override
			public void run() {
				try {
					player.play();
					if (player.isComplete()) {
						Loop();
					}
				} catch (JavaLayerException ex) {
					Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}.start();

	}

	public void Blip() {
		String path = "res/Zoops8.mp3";
		try {
			FISBlip = new FileInputStream(path);
			BISBlip = new BufferedInputStream(FISBlip);

			playerBlip = new Player(BISBlip);

			songTotalLengthBlip = FISBlip.available();

		} catch (FileNotFoundException | JavaLayerException ex) {
			Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
		}

		new Thread() {
			@Override
			public void run() {
				try {
					playerBlip.play();
				} catch (JavaLayerException ex) {
					Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}.start();

	}

	public boolean isPlaying() {
		boolean isPlaying;
		if (player == null) {
			isPlaying = false;
		} else {
			isPlaying = true;
		}
		return isPlaying;
	}

	public PlayAudio() {
		songs.add("res/bg.mp3");
//		songs.add("res/bg2.mp3");
		songs.add("res/bg1.mp3");

	}

}
