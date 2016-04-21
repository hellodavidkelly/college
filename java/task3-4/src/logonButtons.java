import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class logonButtons extends JFrame
{
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JTextArea ta1 = new JTextArea ("Enter Username", 1,10);
	JPasswordField password = new JPasswordField ("four", 10);
	JButton ok = new JButton("ok");
	JButton cancel1 = new JButton("cancel");
	Container c = getContentPane();	

	public static void main(String[] args) 
	{
		logonButtons password = new logonButtons();
		
		password.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public logonButtons()
	{
		super ("Logon Buttons");
		setLayout(new FlowLayout());
		
		panel1.add(ta1);
		panel1.add(password);
		c.add(panel1);
		
		panel2.add(ok, BorderLayout.SOUTH);
		panel2.add(cancel1, BorderLayout.SOUTH);
		c.add(panel2);
		
		password.setEchoChar('0');
		
		ta1.setEditable(true);
		password.setEditable(true);
		
		
		setVisible(true);
		setSize(300,200);
		setLocation(100,100);	
	}
}
