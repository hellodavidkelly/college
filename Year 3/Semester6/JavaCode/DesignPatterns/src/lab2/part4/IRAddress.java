package lab2.part4;

import java.awt.event.ActionListener;

import javax.swing.*;

public class IRAddress extends JFrame{

	//Attributes
	private String county;
	
	//JFrame attributes
	JLabel houseNum = new JLabel("House Number: ");
	JLabel streetName = new JLabel("Street Name: ");
	JLabel city = new JLabel("City: ");
	JLabel countyLabel = new JLabel("County: ");

	JTextField houseNumField = new JTextField(15);
	JTextField streetNameField = new JTextField(15);
	JTextField cityField = new JTextField(15);
	JTextField countyField = new JTextField(15);
	
	JButton addAddress = new JButton("Add Address");
	JButton refresh = new JButton("Refresh");
	
	JPanel panel = new JPanel();
	
	//Constructor
	IRAddress(){
		super("Ireland Address GUI");
		panel.add(houseNum);
		panel.add(houseNumField);
		panel.add(streetName);
		panel.add(streetNameField);
		panel.add(city);
		panel.add(cityField);
		panel.add(countyLabel);
		panel.add(countyField);
		panel.add(addAddress);
		panel.add(refresh);
		this.add(panel);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(200,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//Empty Default Constructor
	
	IRAddress(String houseNumber,String streetName,String city,String county){
	}
	
	//Methods
	public void setCounty(String county){
		this.county = county;
	}
	
	public String getCounty(){
		return county;
	}
	
	public void clearFields(){
		houseNumField.setText("");
		streetNameField.setText("");
		cityField.setText("");
		countyField.setText("");
	}
	
	///////////////////////////////////Event
	void addListener(ActionListener listenForButton){
		addAddress.addActionListener(listenForButton);
	}
	
	void refreshButtonListener(ActionListener listenForButton){
		refresh.addActionListener(listenForButton);
	}
}
