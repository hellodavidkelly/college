package lab4.part3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterFrame extends JFrame {
	
	JTextField name = new JTextField("Name", 15);
	JTextField address1 = new JTextField("Address 1", 15);
	JTextField address2 = new JTextField("Address 2", 15);
	JTextField email = new JTextField("Email", 15);
	JButton submit = new JButton("Submit");
	JPanel north = new JPanel();
	JPanel south = new JPanel();
	
	RegisterFrame(){
		super("Register Frame");
		
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		north.add(name);
		north.add(address1);
		north.add(address2);
		north.add(email);
		south.add(submit);
		this.add(north);
		this.add(south, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setSize(300,300);
		this.setLocation(500,0);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
