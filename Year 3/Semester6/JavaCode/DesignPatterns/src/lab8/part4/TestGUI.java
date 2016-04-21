package lab8.part4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestGUI extends JFrame{
	URL footballImg = this.getClass().getResource("football.png");
	URL basketballImg = this.getClass().getResource("basketball.png");
	URL rugbyImg = this.getClass().getResource("rugby.png");
	URL unknownImg = this.getClass().getResource("unknown.png");
	
	ImageIcon football = new ImageIcon(footballImg);
	ImageIcon basketball = new ImageIcon(basketballImg);
	ImageIcon rugby = new ImageIcon(rugbyImg);
	ImageIcon unknown = new ImageIcon(unknownImg);
	
	ImageIcons f = new ImageIcons(football, 0);
	ImageIcons b = new ImageIcons(basketball, 0);
	ImageIcons r = new ImageIcons(rugby, 0);
	ImageIcons u = new ImageIcons(unknown, 0);
	
	String[] string = {"Football","Basketball","Rugby","Unknown"};
	JComboBox combo = new JComboBox(string);
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	JLabel label = new JLabel();
	JLabel footballLabel = new JLabel("FOOTBALL");
	JLabel footballLabelImg = new JLabel();
	JLabel basketballLabel = new JLabel("BASKETBALL");
	JLabel basketballLabelImg = new JLabel();
	JLabel rugbyLabel = new JLabel("RUGBY");
	JLabel rugbyLabelImg = new JLabel();
	JLabel unknownLabel = new JLabel("UNKNOWN");
	JLabel unknownLabelImg = new JLabel();

	
	Chain chainImg0 = new Football();
	Chain chainImg1 = new BasketBall();
	Chain chainImg2 = new Rugby();
	Chain chainImg3 = new Unknown();	
	
	public TestGUI(){
		this.setLayout(new GridLayout());	
		chainImg0.setNextChain(chainImg1);
		chainImg1.setNextChain(chainImg2);
		chainImg2.setNextChain(chainImg3);
		
		panel1.setLayout(new BorderLayout());
		panel2.setLayout(new BorderLayout());
		panel3.setLayout(new BorderLayout());
		panel4.setLayout(new BorderLayout());
		panel5.setLayout(new BorderLayout());

		///////////////////////////////////////////////
		combo.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if(combo.getSelectedIndex()==0){
		    		label.setIcon(football);
		    		footballLabelImg.setIcon(chainImg0.addImage(f));
		    		panel1.add(label, BorderLayout.SOUTH);
					revalidate();
		    	}
		    	if(combo.getSelectedIndex()==1){
		    		label.setIcon(basketball);
		    		basketballLabelImg.setIcon(chainImg0.addImage(b));
		    		panel1.remove(label);
		    		panel1.add(label, BorderLayout.SOUTH);
					revalidate();
		    	}
		    	if(combo.getSelectedIndex()==2){
		    		label.setIcon(rugby);
		    		rugbyLabelImg.setIcon(chainImg0.addImage(r));
		    		panel1.remove(label);
		    		panel1.add(label, BorderLayout.SOUTH);
					revalidate();
		    	}
		    	if(combo.getSelectedIndex()==3){
		    		label.setIcon(unknown);
		    		unknownLabelImg.setIcon(chainImg0.addImage(u));
		    		panel1.remove(label);
		    		panel1.add(label, BorderLayout.SOUTH);
					revalidate();
		    	}
		    }
		});
		
		panel1.add(combo, BorderLayout.NORTH);
		panel2.add(footballLabel, BorderLayout.NORTH);
		panel2.add(footballLabelImg, BorderLayout.SOUTH);
		panel3.add(basketballLabel, BorderLayout.NORTH);
		panel3.add(basketballLabelImg, BorderLayout.SOUTH);
		panel4.add(rugbyLabel, BorderLayout.NORTH);
		panel4.add(rugbyLabelImg, BorderLayout.SOUTH);
		panel5.add(unknownLabel, BorderLayout.NORTH);
		panel5.add(unknownLabelImg, BorderLayout.SOUTH);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		this.add(panel5);
		
		
		
		///////////////////////////////////////////////
		this.setVisible(true);
		this.setSize(1290,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {	
		TestGUI gui = new TestGUI();
	}

}
