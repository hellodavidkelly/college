package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TestResourceAccessFromJar extends JFrame {

	Image resourceImage;
	Icon resourceIcon;
	JPanel imagePanel = new JPanel();
	JLabel imageLabel = new JLabel();
	String imageFilePath = "file:///" + System.getProperty("user.dir")+"/images/";
	String imageFileName = "bug1.gif";
	URL imageURL;

	
	public TestResourceAccessFromJar() {
		URL imgURL=null;

		try {

	        imgURL = TestResourceAccessFromJar.class.getResource("/images/" + "bug1.GIF");
	        if(imgURL==null) {
	        	System.out.println("No such image found at " + imgURL.toURI().toString());
	        }
	        else {
	        	System.out.println("Image found at " + imgURL.toURI().toString());
	        }
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(this, new String("Can't find image at, working directory is "+System.getProperty("user.dir")+"/images/"+"bug1.gif"),null, JOptionPane.INFORMATION_MESSAGE);
		}
		resourceIcon = new ImageIcon(imgURL);
		imageLabel.setIcon(resourceIcon);

		imagePanel.add(imageLabel);
		getContentPane().add(imagePanel);
		setSize(300,300);
		setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestResourceAccessFromJar();
	}
}
