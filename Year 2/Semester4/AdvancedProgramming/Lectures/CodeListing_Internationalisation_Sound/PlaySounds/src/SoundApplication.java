import javax.swing.JFrame;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;


public class SoundApplication {

	AudioClip sound;
	URL soundURL;
	String soundName = "bottle-open.wav";
	
	public static void main(String[] args) {

		SoundApplication test = new SoundApplication();
		test.start();
	}

	public void start() {

       try {
    	   
            soundURL = new URL("file:" + System.getProperty("user.dir") + "/" + soundName);
            System.out.println("Fetch " + soundURL.toString());
			sound = Applet.newAudioClip(SoundApplication.this.soundURL);

			sound.play();	

            
        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
        }
		
	}

}


