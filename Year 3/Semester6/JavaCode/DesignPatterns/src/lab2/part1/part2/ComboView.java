package lab2.part1.part2;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComboView extends JFrame{

	private static Vector<Hobby> hobbies = new Vector<Hobby>(0,1);
	private JComboBox<String> jcb = new JComboBox<String>();
	private JButton refreshCombo = new JButton("Refresh");
	private JButton addHobbyCombo = new JButton("Add Hobby");
	private JTextField newHobbyField = new JTextField("add hobby?",10);

	JPanel panel = new JPanel();	
	
	public ComboView(){
		super("Combo Hobby");
		panel.add(newHobbyField);
		panel.add(addHobbyCombo);
		panel.add(refreshCombo);
		panel.add(jcb);
		this.add(panel);
		
		this.setVisible(true);
		this.setSize(300,300);
		this.setLocation(310,0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public String getTextField(){
		return newHobbyField.getText();
	}
	
	//Add to hobbyList
	public void addNewHobbyCombo(Vector<Hobby> hobby){
		
		hobbies.clear();
		for(int i=0; i<hobby.size();i++){	
			hobbies.addElement(hobby.elementAt(i));
		}
	}
	
	//Refresh hobbyList
	public void refreshCombo(Vector<Hobby> hobbies){
		System.out.println("Refreshed");
		newHobbyField.setText("");
		
		for(int i = 0; i < hobbies.size(); i++){
			jcb.removeItem(hobbies.elementAt(i).hobbyName);
		}

		for(int i = 0; i <= hobbies.size(); i++){
			jcb.addItem(hobbies.elementAt(i).hobbyName);
			System.out.println(hobbies.elementAt(i).hobbyName);
		}
	}
	
	
	//ActionListeners 
	public void addNewHobbyButtonListener(ActionListener buttonListener){
		addHobbyCombo.addActionListener(buttonListener);
	}

	public void refreshButtonListener(ActionListener buttonListener){
		refreshCombo.addActionListener(buttonListener);
	}
}
