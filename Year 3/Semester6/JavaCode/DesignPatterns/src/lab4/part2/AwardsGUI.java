package lab4.part2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AwardsGUI extends JFrame {
	Prize prize = new Prize();
	AwardingBody athleticsAwardingBody = new AthleticsAwardingBody();
	AwardingBody horseShowAwardingBody = new HorseShowAwardingBody();
	
	String[] placing = {"1", "2", "3"};
	String[] events = {"Athletics", "HorseShow"};
	JPanel panel = new JPanel();
	JPanel north = new JPanel();
	JPanel center = new JPanel();
	JPanel south = new JPanel();
	JLabel image = new JLabel();
	JTextField textField = new JTextField(20);
	JComboBox<String> award = new JComboBox<String>(placing);
	JComboBox<String> sport = new JComboBox<String>(events);
	
	AwardsGUI(){
		
		award.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(sport.getSelectedIndex()==0){
					athleticsAwardingBody.getPrize(award.getSelectedIndex());
					textField.setText(athleticsAwardingBody.getMessage(award.getSelectedIndex()));
					image.setIcon(athleticsAwardingBody.getPrize(award.getSelectedIndex()));
					image.repaint();
				}
				if(sport.getSelectedIndex()==1){
					horseShowAwardingBody.getPrize(award.getSelectedIndex());
					textField.setText(athleticsAwardingBody.getMessage(award.getSelectedIndex()));
					image.setIcon(horseShowAwardingBody.getPrize(award.getSelectedIndex()));
					image.repaint();
				}
			}	
		});
		
		north.add(textField, BorderLayout.NORTH);
		center.add(image, BorderLayout.SOUTH);
		south.add(award, BorderLayout.SOUTH);
		south.add(sport, BorderLayout.SOUTH);
		panel.add(north, BorderLayout.NORTH);
		panel.add(center, BorderLayout.SOUTH);
		panel.add(south, BorderLayout.SOUTH);
		this.add(panel);
		this.setVisible(true);
		this.setSize(300,500);
		this.setLocation(500,0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public int getAward(){
		return award.getSelectedIndex();
	}
}
