package lab5.part3;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LegoMan extends AbstractMan{

	URL head = this.getClass().getResource("LegoHead.png");
	URL body = this.getClass().getResource("LegoBody.png");
	URL legs = this.getClass().getResource("LegoLegs.png");
	
	ImageIcon headIcon = new ImageIcon(head); 
	ImageIcon bodyIcon = new ImageIcon(body);
	ImageIcon legsIcon = new ImageIcon(legs);
	
	JLabel headLabel = new JLabel();
	JLabel bodyLabel = new JLabel();
	JLabel legsLabel = new JLabel();
	
	JPanel legoPanel = new JPanel();

	public JPanel getPanel() {
		headLabel.setIcon(headIcon);
		bodyLabel.setIcon(bodyIcon);
		legsLabel.setIcon(legsIcon);
		
		legoPanel = new JPanel(new BorderLayout());
		legoPanel.add(headLabel, BorderLayout.NORTH);
		legoPanel.add(bodyLabel, BorderLayout.CENTER);
		legoPanel.add(legsLabel, BorderLayout.SOUTH);
		return legoPanel;
	}
	

}
