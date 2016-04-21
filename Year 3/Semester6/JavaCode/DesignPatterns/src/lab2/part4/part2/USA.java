package lab2.part4.part2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class USA extends Address{
	AddressStorage as = new AddressStorage();

	//Attributes
	private String zip;
	
	//JFrame attributes
	JLabel houseNum = new JLabel("House Number:\t\n");
	JLabel streetName = new JLabel("Street Name:\t\n");
	JLabel city = new JLabel("City:\t\n");
	JLabel zipLabel = new JLabel("Zip:\t\n");

	JTextField houseNumField = new JTextField(15);
	JTextField streetNameField = new JTextField(15);
	JTextField cityField = new JTextField(15);
	JTextField zipField = new JTextField(15);
	
	JButton addAddress = new JButton("Add Address");
	
	JPanel usaPanel = new JPanel();

	USA(){
		addAddress.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String holder;
				holder = 	houseNumField.getText() +" "+ streetNameField.getText() +" "+
							cityField.getText() +" "+ zipField.getText();
				as.addAddress(holder);
				System.out.print(as.getAddress());
				new AddressGUI();
			}
		});
		usaPanel.add(houseNum);
		usaPanel.add(houseNumField);
		usaPanel.add(streetName);
		usaPanel.add(streetNameField);
		usaPanel.add(city);
		usaPanel.add(cityField);
		usaPanel.add(zipLabel);
		usaPanel.add(zipField);
		
		usaPanel.add(addAddress);
		usaPanel.setVisible(true);
		this.add(usaPanel);
		this.setVisible(false);
		this.setLocation(500,0);
		this.setSize(200,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}