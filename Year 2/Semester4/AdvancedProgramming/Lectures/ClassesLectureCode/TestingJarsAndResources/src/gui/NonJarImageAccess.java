package gui;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class NonJarImageAccess extends JFrame {
	Icon resourceImage;
	JPanel imagePanel = new JPanel();
	JLabel imageLabel = new JLabel();
	String imageFilePath = "file:///" + System.getProperty("user.dir")+"//images//";
	String imageFileName = "bug1.gif";
	URL imageURL;

	
	public NonJarImageAccess() {
		try {
			imageURL = new URL(imageFilePath + "" + imageFileName);
		}
		catch(MalformedURLException e) {
			JOptionPane.showMessageDialog(this, new String("Can't find image at "+imageFilePath + "" + imageFileName),null, JOptionPane.INFORMATION_MESSAGE);
		}
		resourceImage = new ImageIcon(imageURL);
		imageLabel.setIcon(resourceImage);
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
		new NonJarImageAccess();
	}

}
