package lab2.part4;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class USAddress extends JFrame{
	
	//Attributes
	private String zip;
	private String state;
	
	//JFrame attributes
	JLabel houseNum = new JLabel("House Number: ");
	JLabel streetName = new JLabel("Street Name: ");
	JLabel city = new JLabel("City: ");
	JLabel zipLabel = new JLabel("Zip: ");
	JLabel stateLabel = new JLabel("State: ");	

	JTextField houseNumField = new JTextField(15);
	JTextField streetNameField = new JTextField(15);
	JTextField cityField = new JTextField(15);
	JTextField zipField = new JTextField(15);
	JTextField stateField = new JTextField(15);
	
	JButton addAddress = new JButton("Add Address");
	JButton refresh = new JButton("Refresh");
	
	JPanel panel = new JPanel();
	
	//Constructor
	USAddress(){
		super("US Address GUI");
		panel.add(houseNum);
		panel.add(houseNumField);
		panel.add(streetName);
		panel.add(streetNameField);
		panel.add(city);
		panel.add(cityField);
		panel.add(zipLabel);
		panel.add(zipField);
		panel.add(stateLabel);
		panel.add(stateField);
		panel.add(addAddress);
		panel.add(refresh);
		this.add(panel);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(200,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//Empty Default Constructor
	
	USAddress(String houseNumber,String streetName,String city,String zip, String state){
	}
	
	//Methods
	public void setZip(String zip){
		this.zip = zip;
	}
	
	public String getZip(){
		return zip;
	}
	
	public void setStateName(String state){
		this.state = state;
	}
	
	public String getStateName(){ 
		return state;
	}

	public void clearFields(){
		houseNumField.setText("");
		streetNameField.setText("");
		cityField.setText("");
		zipField.setText("");
		stateField.setText("");
	}
	
	///////////////////////////////////Event
	
	void addHobbyListener(ActionListener listenForButton){
		addAddress.addActionListener(listenForButton);
	}
	
	void refreshButtonListener(ActionListener listenForButton){
		refresh.addActionListener(listenForButton);
	}
}
