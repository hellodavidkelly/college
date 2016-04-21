package lab4.part3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GreetingDisplay extends JFrame {

	AppWelcome appWelcome = new SecuredApp();
	
	String[] options = {"Returning User", "New User"};
	JComboBox select = new JComboBox(options);
	JPanel panel = new JPanel();
	
	GreetingDisplay(){
		super("Welcome Display");
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				appWelcome.getGUI(select.getSelectedItem().toString());
			}
		});
		panel.add(select);
		this.add(panel);
		this.setVisible(true);
		this.setLocation(500,0);
		this.setSize(300,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
