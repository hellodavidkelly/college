package lab4.part3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {

	JTextField username = new JTextField("Username", 15);
	JTextField password = new JTextField("Password", 15);
	JButton button = new JButton("Submit");
	JPanel north = new JPanel();
	JPanel south = new JPanel();
	
	LoginFrame(){
		super("Login Frame");
		
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		north.add(username);
		north.add(password);
		south.add(button);
		this.add(north);
		this.add(south, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setSize(300,300);
		this.setLocation(500,0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
