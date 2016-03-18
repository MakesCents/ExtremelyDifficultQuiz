package src;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.*;

public class PlayAudio {
	static long clipTime;
	static String path;
	static Clip clip;
	static AudioInputStream stream;
	static AudioFormat format;
	static DataLine.Info info;
//	FloatControl volume;
	public PlayAudio(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		this.path = path;
		URL soundUrl = PlayAudio.class.getResource(path);
		stream = AudioSystem.getAudioInputStream(soundUrl);
		format = stream.getFormat();
		info = new DataLine.Info(Clip.class, format);
		clip = (Clip) AudioSystem.getLine(info);
//		volume = (FloatControl) clip.getControl(FloatControl.Type.VOLUME);
	}

	public static Clip getClip() {
		return clip;
	}

	public synchronized static void play() throws LineUnavailableException, IOException {
		clip.open(stream);
		new ClipHandler(clip).play();
	}

	public static synchronized void loop() throws LineUnavailableException, IOException {
		clip.open(stream);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		new ClipHandler(clip).play();
	}

	public static void pause(Boolean loop) throws LineUnavailableException, IOException {
		if(clip.isRunning())
			clip.stop();
		else if(loop){
			clip.open(stream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			new ClipHandler(clip).play();
		}else{
			clip.open(stream);
			new ClipHandler(clip).play();
		}
	}
	
//	public static void resume() throws LineUnavailableException, IOException{
//		if(!clip.isOpen() && !clip.isRunning())
//			play();
//	}
	public void mute(Boolean tof){
//		if (tof == true) { 
//			volume.setValue(-3.0f);
//		}else{
//			volume.setValue(3.0f);
//		}
	}

}