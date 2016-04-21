import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class logon extends JFrame
{
	JPanel panel1 = new JPanel();
	JTextArea ta1 = new JTextArea ("Enter Username", 1,10);
	JPasswordField password = new JPasswordField ("four", 10);
	Container c = getContentPane();	

	public static void main(String[] args) 
	{
		logon password = new logon();
		
		password.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public logon()
	{
		super ("logon");
		setLayout(new FlowLayout());
		
		panel1.add(ta1);
		panel1.add(password);
		c.add(panel1);
		
		password.setEchoChar('0');
		
		ta1.setEditable(true);
		password.setEditable(true);
		
		
		setVisible(true);
		setSize(300,200);
		setLocation(100,100);	
	}
}
