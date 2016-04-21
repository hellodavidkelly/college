package lab2.part4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddressGUI extends JFrame{

	//Attributes
	static String[] countriesString = {"IRELAND", "USA"};
	static JComboBox countries = new JComboBox(countriesString);
	JButton selectCountry = new JButton("Select");
	JPanel panel = new JPanel();
	
	//Constructor
	AddressGUI(){
		super("Country Selecet GUI");
		panel.add(countries);
		panel.add(selectCountry);
		this.add(panel);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(200,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//Methods
	///////////////////////////////////Event
	void addButtonListener(ActionListener listenForButton){
		selectCountry.addActionListener(listenForButton);
	}
	
	public static String getSelectedItem(){
		String country = countries.getSelectedItem().toString();
		return country;
	}
	
	//Main
	public static void main(String[] args) {

	}

}