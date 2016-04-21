import javax.swing.*;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.Locale;
import java.util.ResourceBundle;


public class GUI extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	JPanel topPanel = new JPanel(new GridLayout(2,3));
	//JPanel bottomPanel = new JPanel();
	ResourceBundle res;
	Locale loc;
	Font fontStyle = new Font("Helvetica", Font.PLAIN, 20);
	String english = "English";
	String french = "French";
	String german = "German";
	JComboBox<String> combo = new JComboBox<String>();
	JLabel select = new JLabel("Select Language");
	
	
	///HORSE PANEL
	Icon horse = new ImageIcon(System.getProperty("user.dir") + "/images/" + "horse.png");
	JLabel horseImg = new JLabel(horse);
	JButton horseAudio;
	JPanel horsePanel = new JPanel(new BorderLayout());
	///
	///DOG PANEL
	Icon dog = new ImageIcon(System.getProperty("user.dir") + "/images/" + "dog.png");
	JLabel dogImg = new JLabel(dog);
	JButton dogAudio;
	JPanel dogPanel = new JPanel(new BorderLayout());
	///
	///CAT PANEL
	Icon cat = new ImageIcon(System.getProperty("user.dir") + "/images/" + "cat.png");
	JLabel catImg = new JLabel(cat);
	JButton catAudio;
	JPanel catPanel = new JPanel(new BorderLayout());
	///
	///PARROT PANEL
	Icon parrot = new ImageIcon(System.getProperty("user.dir") + "/images/" + "parrot.png");
	JLabel parrotImg = new JLabel(parrot);
	JButton parrotAudio;
	JPanel parrotPanel = new JPanel(new BorderLayout());
	///
	///PIG PANEL
	Icon pig = new ImageIcon(System.getProperty("user.dir") + "/images/" + "pig.png");
	JLabel pigImg = new JLabel(pig);
	JButton pigAudio;
	JPanel pigPanel = new JPanel(new BorderLayout());
	///Menu Panel
	JPanel menuPanel = new JPanel(new FlowLayout());
	
	
	AudioClip soundApp;
	URL soundAppURL;
	String horseWav = "horse.wav";
	String dogWav = "dog.wav";
	String catWav = "cat.wav";
	String parrotWav = "parrot.wav";
	String pigWav = "pig.wav";
	
	
	Container c = getContentPane();
	
	public static void main(String[] args) 
	{
		GUI languageGUI = new GUI();
		languageGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public GUI() 
	{
		super ("Assignment 2");
		loc = new Locale("en");
		res = ResourceBundle.getBundle("ProgramProperties", loc);
		combo.addActionListener(this);
		select.setFont(fontStyle);

		
		//HORSE
		horseAudio = new JButton(res.getString("tag1"));
		horseAudio.addActionListener(this);
		horsePanel.add(horseImg, BorderLayout.NORTH);
		horsePanel.add(horseAudio, BorderLayout.SOUTH);
		//DOG
		dogAudio = new JButton(res.getString("tag2"));
		dogAudio.addActionListener(this);
		dogPanel.add(dogImg, BorderLayout.NORTH);
		dogPanel.add(dogAudio, BorderLayout.SOUTH);
		//CAT
		catAudio = new JButton(res.getString("tag3"));
		catAudio.addActionListener(this);
		catPanel.add(catImg, BorderLayout.NORTH);
		catPanel.add(catAudio, BorderLayout.SOUTH);		
		//PARROT
		parrotAudio = new JButton(res.getString("tag4"));
		parrotAudio.addActionListener(this);
		parrotPanel.add(parrotImg, BorderLayout.NORTH);
		parrotPanel.add(parrotAudio, BorderLayout.SOUTH);
		//PARROT
		pigAudio = new JButton(res.getString("tag5"));
		pigAudio.addActionListener(this);
		pigPanel.add(pigImg, BorderLayout.NORTH);
		pigPanel.add(pigAudio, BorderLayout.SOUTH);
		//MENU
		menuPanel.add(combo);
		menuPanel.add(select);
		
		//SET FONT
		horseAudio.setFont(fontStyle);
		dogAudio.setFont(fontStyle);
		catAudio.setFont(fontStyle);
		parrotAudio.setFont(fontStyle);
		pigAudio.setFont(fontStyle);
		
		//ADD PANELS
		topPanel.add(horsePanel);
		topPanel.add(dogPanel);		
		topPanel.add(catPanel);		
		topPanel.add(parrotPanel);
		topPanel.add(pigPanel);
		topPanel.add(menuPanel);
		
		//SET UP THE COMBOBOX
		combo.addItem(english);

		//ADD PANEL TO CONTAINER
		c.add(topPanel);

		//GUI Properties
		setSize(900,450);
		setVisible(true);
		setLocation(50,0);
		}

	public void getLanguage()
	{
		//MANAGE COMBOBOX OPTIONS
		if(combo.getSelectedIndex()==0)
		{
			//RESET THE LOCAL 
			loc = new Locale("en");
			//RESET THE res TO RECEIVE THE NEW LOCAL VARIABLE
			res =ResourceBundle.getBundle("ProgramProperties", loc);

			horseWav=(res.getString("tag11"));
			dogWav=(res.getString("tag12"));
			catWav=(res.getString("tag13"));
			parrotWav=(res.getString("tag14"));
			pigWav=(res.getString("tag15"));
			
			horseAudio.setText(res.getString("tag1"));
			dogAudio.setText(res.getString("tag2"));
			catAudio.setText(res.getString("tag3"));
			parrotAudio.setText(res.getString("tag4"));
			pigAudio.setText(res.getString("tag5"));
			select.setText(res.getString("tag6"));
			
			//CHANGING THE OPTIONS IN THE COMBOBOX
			combo.removeAllItems();
			combo.addItem("English");
			combo.addItem("French");
			combo.addItem("German");
			combo.setSelectedItem("English");
		}
		
		else if(combo.getSelectedIndex()==1)
		{
			//RESET THE LOCAL 
			loc = new Locale("fr");
			//RESET THE res TO RECEIVE THE NEW LOCAL VARIABLE
			res =ResourceBundle.getBundle("ProgramProperties", loc);

			horseWav=(res.getString("tag11"));
			dogWav=(res.getString("tag12"));
			catWav=(res.getString("tag13"));
			parrotWav=(res.getString("tag14"));
			pigWav=(res.getString("tag15"));
			
			horseAudio.setText(res.getString("tag1"));
			dogAudio.setText(res.getString("tag2"));
			catAudio.setText(res.getString("tag3"));
			parrotAudio.setText(res.getString("tag4"));
			pigAudio.setText(res.getString("tag5"));
			select.setText(res.getString("tag6"));
			
			//CHANGING THE OPTIONS IN THE COMBOBOX
			combo.removeAllItems();
			combo.addItem("Anglais");
			combo.addItem("Francais");
			combo.addItem("Allemand");
			combo.setSelectedItem("Francais");
		}
		
		else if(combo.getSelectedIndex()==2)
		{
			//RESET THE LOCAL 
			loc = new Locale("de");
			//RESET THE res TO RECEIVE THE NEW LOCAL VARIABLE
			res =ResourceBundle.getBundle("ProgramProperties", loc);

			horseWav=(res.getString("tag11"));
			dogWav=(res.getString("tag12"));
			catWav=(res.getString("tag13"));
			parrotWav=(res.getString("tag14"));
			pigWav=(res.getString("tag15"));
			
			horseAudio.setText(res.getString("tag1"));
			dogAudio.setText(res.getString("tag2"));
			catAudio.setText(res.getString("tag3"));
			parrotAudio.setText(res.getString("tag4"));
			pigAudio.setText(res.getString("tag5"));
			select.setText(res.getString("tag6"));			
			
			//CHANGING THE OPTIONS IN THE COMBOBOX
			combo.removeAllItems();
			combo.addItem("Englisch");
			combo.addItem("Franzoisisch");
			combo.addItem("Deutsch");
			combo.setSelectedItem("Deutsch");
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==horseAudio)
		{
			try
			{
				 soundAppURL = new URL("file:" + System.getProperty("user.dir") + "/audio/" + horseWav);
				 soundApp = Applet.newAudioClip(GUI.this.soundAppURL);
				 soundApp.play();
			} 
			
			catch (MalformedURLException i) 
			{
				JOptionPane.showMessageDialog(null,"Path File Error with Audio");
	        }
		}
		
		//
		
		if(e.getSource()==dogAudio)
		{
			try
			{
				 soundAppURL = new URL("file:" + System.getProperty("user.dir") + "/audio/" + dogWav);
				 soundApp = Applet.newAudioClip(GUI.this.soundAppURL);
				 soundApp.play();
			} 
			
			catch (MalformedURLException i) 
			{
				JOptionPane.showMessageDialog(null,"Path File Error with Audio");
	        }
			
		}
		
		//
		
		if(e.getSource()==catAudio)
		{
			try
			{
				 soundAppURL = new URL("file:" + System.getProperty("user.dir") + "/audio/" + catWav);
				 soundApp = Applet.newAudioClip(GUI.this.soundAppURL);
				 soundApp.play();
			} 
			
			catch (MalformedURLException i) 
			{
				JOptionPane.showMessageDialog(null,"Path File Error with Audio");
	        }
		}
		
		//
		
		if(e.getSource()==parrotAudio)
		{
			try
			{
				 soundAppURL = new URL("file:" + System.getProperty("user.dir") + "/audio/" + parrotWav);
				 soundApp = Applet.newAudioClip(GUI.this.soundAppURL);
				 soundApp.play();
			} 
			
			catch (MalformedURLException i) 
			{
				JOptionPane.showMessageDialog(null,"Path File Error with Audio");
	        }
		}
		
		//
		
		if(e.getSource()==pigAudio)
		{
			try
			{
				 soundAppURL = new URL("file:" + System.getProperty("user.dir") + "/audio/" + pigWav);
				 soundApp = Applet.newAudioClip(GUI.this.soundAppURL);
				 soundApp.play();
			} 
			
			catch (MalformedURLException i) 
			{
				JOptionPane.showMessageDialog(null,"Path File Error with Audio");
	        }
		}


		
		//////////////////////////
		if(e.getSource()==combo)
		{
			getLanguage();
		}
	}
}
