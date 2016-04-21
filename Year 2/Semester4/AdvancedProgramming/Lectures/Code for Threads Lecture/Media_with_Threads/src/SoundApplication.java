import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class SoundApplication extends JFrame implements ActionListener {

	AudioClip sound;
	URL soundURL;
	String soundName = "1-welcome.wav";
	Thread playThread;
	JButton playButton;
	MediaPreLoader preloader;
	JLabel statusLabel;
	
	public static void main(String[] args) {
		new SoundApplication();
	}
	
	public SoundApplication() {
		setLayout(new FlowLayout());
		playButton = new JButton("Play");
		statusLabel = new JLabel("Media Status");
		getContentPane().add(playButton);
		getContentPane().add(statusLabel);
		
		playButton.addActionListener(this);
		setVisible(true);
		setSize(300,100);
		start();
	}

	public void start() {

       try {
            soundURL = new URL("file:" + System.getProperty("user.dir") + "/" + soundName);
            System.out.println("Fetch " + soundURL.toString());
			preloader = new MediaPreLoader(soundURL);

			while(preloader.isAlive()) {
				System.out.println("Waiting to load media");
			}

			if(!preloader.isAlive()) 
				statusLabel.setText("Ready to play");
            
        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
        }
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
		playThread = new Thread() {
			public void run() {
				preloader.currentMedia.play();
			}
		};
		
		playThread.start();
		
		while(playThread.isAlive()) {
			System.out.println("Playing");				
		}			
		
	}

}


