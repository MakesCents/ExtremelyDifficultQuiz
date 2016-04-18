package src;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class ClipHandler implements LineListener, Runnable {
    private Clip clip;

    public ClipHandler(Clip clip) {
        this.clip = clip;
        clip.addLineListener(this);
    }

    public void play() {
        clip.start();
    }

    public void update(LineEvent e) {
        if (e.getType() == LineEvent.Type.STOP) {
            System.out.println("stopping!");
            new Thread(this).start();
        }
    }

    public void run() {
        clip.close();
        System.out.println("stopped!");
    }
}