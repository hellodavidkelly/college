import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.net.*;

public class sound extends JFrame implements ActionListener
{

	JPanel panel1 = new JPanel(new FlowLayout());
	Container c = getContentPane();
	JButton but1 = new JButton("Play Sound");
	AudioClip soundApp;
	URL soundAppURL;
	String soundAppName = "applause.wav";
	
	public static void main(String[] args) 
	{
		sound gui = new sound();
		gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	public sound()
	{
		super ("Applause");

		but1.addActionListener(this);
		panel1.add(but1);	
		c.add(panel1);

		setLocation(100,100);
		setSize(500,100);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==but1)
		{
			try
			{
				 soundAppURL = new URL("file:" + System.getProperty("user.dir") + "/" + soundAppName);
				 soundApp = Applet.newAudioClip(sound.this.soundAppURL);
				 soundApp.play();
			} 
			
			catch (MalformedURLException i) 
			{
	            System.err.println(i.getMessage());
	        }
		}
		
		else
		{
			
		}	
	}
	
}
