package lab2.part4.part2;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddressGUI extends JFrame implements ActionListener{

	USA usa = new USA();
	Ireland ireland = new Ireland();

	String[] countriesString = {"USA", "IRELAND"};
	JComboBox countries = new JComboBox(countriesString);
	JButton select = new JButton("Select");
	JPanel panel = new JPanel();
	
	AddressFactory aFac = new AddressFactory();
	
	AddressGUI(){
		super("Address GUI");
		select.addActionListener(this);
		panel.add(countries);
		panel.add(select);
		this.add(panel);
		this.setVisible(true);
		this.setLocation(500,0);
		this.setSize(200,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("\n");
		aFac.setAddressLocation(countries.getSelectedIndex());
		this.setVisible(false);
	}

}
