import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;


public class MediaPreLoader extends Thread {
    URL completeURL;
    String relativeURL;
    AudioClip currentMedia;

    public MediaPreLoader(URL mediaURL) {

    	completeURL = mediaURL;
    	
        start();
    }

    public void run() {
        AudioClip audioClip = Applet.newAudioClip(completeURL);
        currentMedia = audioClip;
    }
}
