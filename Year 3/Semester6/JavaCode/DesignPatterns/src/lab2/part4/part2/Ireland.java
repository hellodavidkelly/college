package lab2.part4.part2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ireland extends Address{
	AddressStorage as = new AddressStorage();

	//Attributes
	private String county;
	
	//JFrame attributes
	JLabel houseNum = new JLabel("House Number:\t\n");
	JLabel streetName = new JLabel("Street Name:\t\n");
	JLabel city = new JLabel("City:\t\n");
	JLabel countyLabel = new JLabel("County:\t\n");

	JTextField houseNumField = new JTextField(15);
	JTextField streetNameField = new JTextField(15);
	JTextField cityField = new JTextField(15);
	JTextField countyField = new JTextField(15);
	
	JButton addAddress = new JButton("Add Address");
	
	JPanel irelandPanel = new JPanel();

	Ireland(){
		addAddress.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String holder;
				holder = 	houseNumField.getText() +" "+ streetNameField.getText() +" "+
							cityField.getText() +" "+ countyField.getText();
				as.addAddress(holder);
				System.out.print(as.getAddress());
				new AddressGUI();
			}
		});
		irelandPanel.add(houseNum);
		irelandPanel.add(houseNumField);
		irelandPanel.add(streetName);
		irelandPanel.add(streetNameField);
		irelandPanel.add(city);
		irelandPanel.add(cityField);
		irelandPanel.add(countyLabel);
		irelandPanel.add(countyField);
		
		irelandPanel.add(addAddress);
		this.add(irelandPanel);
		this.setVisible(false);
		this.setLocation(500,0);
		this.setSize(200,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


}