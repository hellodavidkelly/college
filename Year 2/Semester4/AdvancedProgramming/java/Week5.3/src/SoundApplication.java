import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class SoundApplication extends JFrame implements ActionListener 
{

	AudioClip sound;
	URL soundURL;
	String soundName = "bottle-open.wav";
	Thread playThread;
	JButton playButton;
	MediaPreLoader preloader;
	JLabel statusLabel;
	
	public static void main(String[] args) 
	{
		SoundApplication gui = new SoundApplication();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public SoundApplication() 
	{
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

	public void start() 
	{

       try {
            soundURL = new URL("file:" + System.getProperty("user.dir") + "/" + soundName);
            System.out.println("Fetch " + soundURL.toString());
			preloader = new MediaPreLoader(soundURL);

			while(preloader.isAlive()) 
			{
				System.out.println("Waiting to load media");
			}

			if(!preloader.isAlive())
			{
				statusLabel.setText("Ready to play");
			}
            
        } 
       
       catch (MalformedURLException e) 
       {
            System.err.println(e.getMessage());
       }
		
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		
		playThread = new Thread() 
		{
			public void run() 
			{
				preloader.currentMedia.play();
			}
		};
		
		playThread.start();
		
		while(playThread.isAlive()) 
		{
			System.out.println("Playing");				
		}			
		
	}

}


