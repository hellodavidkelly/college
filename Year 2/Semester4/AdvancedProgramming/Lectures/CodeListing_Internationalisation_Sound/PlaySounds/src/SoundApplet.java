import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;


public class SoundApplet extends JApplet {

	AudioClip sound;
	URL soundURL;
	String soundFile="spacemusic.au";
	
	public void startPlaying() {
        try {
            soundURL = getCodeBase(); //this will return where the .class runs
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
		sound = getAudioClip(soundURL, soundFile);
		
		sound.play();
	}
	
	public void init() {

		startPlaying();
	}
	
}
