package lab2.part1;

import java.awt.Container;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class ListView extends JFrame{

	//Attributes
	private JList<Hobby> hobbyL = new JList<Hobby>(HobbyList.getHobby());
	private JPanel hobbyP = new JPanel();
	//private JButton addHobby = new JButton("Add Hobby");
	private JButton refreshList = new JButton("Refresh");
	//Container pane = this.getContentPane();

	//Constructors
	public ListView(){
		super("Hobbies List View");
		hobbyL.setVisible(true);
		hobbyP.add(hobbyL);
		//hobbyP.add(addHobby);
		hobbyP.add(refreshList);
		this.add(hobbyP);
	
		
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(300,300);
		this.setLocation(510,0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	//Methods
	/*public void addHobbiesToList(String hobbies){
		HobbyList.addHobby(HobbyList.getHobby());
	}*/
	
	public Hobby getNewHobby(){
		return hobbyL.getSelectedValue();
	}
	
	public void refreshList(){
		hobbyL.repaint();
		hobbyL.validate();
	}
	
	
	//Adding listeners to JButtons
	/*void addHobbyListener(ActionListener listenForButton){
		this.addHobby.addActionListener(listenForButton);
	}*/
	
	void refreshHobbyListener(ActionListener listenForButton){
		refreshList.addActionListener(listenForButton);
	}	
}
