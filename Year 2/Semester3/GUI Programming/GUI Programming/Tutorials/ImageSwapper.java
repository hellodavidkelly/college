import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ImageSwapper extends JFrame implements ActionListener {

	JLabel imageLabel;

	JPanel buttonPanel = new JPanel();

	JButton onButton=new JButton("On"), offButton=new JButton("Off");

	final static double PI = 3.14159265; //Nothing to do with program, is sample final static variable

	ImageIcon testImage = new ImageIcon("bug1.gif");

	public ImageSwapper() {



		imageLabel = new JLabel();

		imageLabel.setIcon(testImage);

		getContentPane().add(imageLabel, BorderLayout.CENTER);

		buttonPanel.add(onButton);
		buttonPanel.add(offButton);

		onButton.addActionListener(this);

		offButton.addActionListener(this);

		getContentPane().add(buttonPanel, BorderLayout.SOUTH);


		setSize(250,250);
		setVisible(true);

	}


	public static void main(String[] args) {
	  new ImageSwapper();

	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==onButton) {
			imageLabel.setIcon(testImage);
		}
		else {
			imageLabel.setIcon(null);

		}

	}



}