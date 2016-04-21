package lab2.part1.part2;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ListView extends JFrame{
	
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> hobbyList = new JList<String>(listModel);
	private JButton refreshList = new JButton("Refresh");
	private JButton addHobbyList = new JButton("Add Hobby");
	private JPanel panel = new JPanel();
	private JTextField newHobbyField = new JTextField("add hobby?",10);

	public ListView(){
		super("List Hobby");
		panel.add(newHobbyField);
		panel.add(addHobbyList);
		panel.add(refreshList);
		panel.add(hobbyList);
		this.add(panel);
		
		this.setVisible(true);
		this.setSize(300,300);
		this.setLocation(0,0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//Add to hobbyList
	public void addNewHobby(){
		
	}
	
	public String getTextField(){
		return newHobbyField.getText();
	}
	
	//Refresh hobbyList
	public void refreshList(Vector<Hobby> hobbies){
		System.out.println("Refreshed");
		newHobbyField.setText("");
		listModel.removeAllElements();
		for(int i = 0; i <= hobbies.size(); i++){
			this.listModel.add(i, hobbies.elementAt(i).hobbyName);
			System.out.println(hobbies.elementAt(i).hobbyName);
		}
	}
	
	
	//ActionListeners 
	public void addNewHobbyButtonListener(ActionListener buttonListener){
		addHobbyList.addActionListener(buttonListener);
	}

	public void refreshButtonListener(ActionListener buttonListener){
		refreshList.addActionListener(buttonListener);
	}
}
