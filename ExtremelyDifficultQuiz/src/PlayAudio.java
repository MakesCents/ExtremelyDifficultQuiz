package src;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlayAudio {

	FileInputStream FIS;
	BufferedInputStream BIS;

	public Player player;

	public long pauseLocation;
	public long songTotalLength;
	public static int count;
	public String fileLocation;

	public void Stop() {
		if (player != null) {
			player.close();
			pauseLocation = 0;
			songTotalLength = 0;

		}
	}

	public void Play(String path) {
		try {
			FIS = new FileInputStream(path);
			BIS = new BufferedInputStream(FIS);

			player = new Player(BIS);

			songTotalLength = FIS.available();

			fileLocation = path + "";
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
				} catch (JavaLayerException ex) {
					Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}.start();

	}
	
    public void Loop(String path) {
        try {
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);

            player = new Player(BIS);

            songTotalLength = FIS.available();

            fileLocation = path + "";
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
                        Loop(fileLocation);
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
                        Loop(fileLocation);
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
			FIS = new FileInputStream(path);
			BIS = new BufferedInputStream(FIS);

			player = new Player(BIS);

			songTotalLength = FIS.available();

			fileLocation = path + "";
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
				} catch (JavaLayerException ex) {
					Logger.getLogger(PlayAudio.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}.start();
		
	}
	public boolean isPlaying(){
		boolean isPlaying;
		if(player == null){
			isPlaying = false;
		}else{
			isPlaying = true;
		}
		return isPlaying;
	}

}
