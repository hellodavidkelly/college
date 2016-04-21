package lab2.part1;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class ComboView extends JFrame{
	
	//Attributes
	private JTextField newHobby = new JTextField("add hobby?",10);
	private JComboBox<Hobby> hobbyJCB = new JComboBox<Hobby>(HobbyList.getHobby());
	private JButton addHobby = new JButton("Add Hobby");
	private JButton refreshList = new JButton("Refresh");
	private JPanel hobbyP = new JPanel();

	//Constructor
	public ComboView(){
		super("Combobox View");
		hobbyP.add(addHobby);
		hobbyP.add(refreshList);
		hobbyP.add(newHobby);
		hobbyP.add(hobbyJCB, BorderLayout.SOUTH);
		this.add(hobbyP);
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(500,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	
	//Methods
	public void setTextField(){
		this.newHobby.setText("");
	}
	
	public String getNewHobby(){
		return newHobby.getText();
	}
	
	public void setCombo(){
	}
	

	//Adding listeners to JButtons
	void addHobbyListener(ActionListener listenForButton){
		addHobby.addActionListener(listenForButton);
	}
	
	void refreshHobbyListener(ActionListener listenForButton){
		refreshList.addActionListener(listenForButton);
	}
}
