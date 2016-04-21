package lab5.part3;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StickMan extends AbstractMan{

	URL head = this.getClass().getResource("StickManHead.png");
	URL body = this.getClass().getResource("StickManBody.png");
	URL legs = this.getClass().getResource("StickManLegs.png");
	
	ImageIcon headIcon = new ImageIcon(head); 
	ImageIcon bodyIcon = new ImageIcon(body);
	ImageIcon legsIcon = new ImageIcon(legs);

	JLabel headLabel = new JLabel();
	JLabel bodyLabel = new JLabel();
	JLabel legsLabel = new JLabel();
	JPanel StickManPanel = new JPanel();

	
	public JPanel getPanel() {
		headLabel.setIcon(headIcon);
		bodyLabel.setIcon(bodyIcon);
		legsLabel.setIcon(legsIcon);
		
		StickManPanel = new JPanel(new BorderLayout());
		StickManPanel.add(headLabel, BorderLayout.NORTH);
		StickManPanel.add(bodyLabel, BorderLayout.CENTER);
		StickManPanel.add(legsLabel, BorderLayout.SOUTH);
		return StickManPanel;
	}
	

}
