import javax.swing.*;
import java.awt.*;

public class twoTextAreas extends JFrame
{
	JPanel panel1 = new JPanel();
	JTextArea ta1 = new JTextArea ("My first text area", 5,15);
	JTextArea ta2 = new JTextArea ("My second text area", 5,15);
	Container c = getContentPane();	
	
	public static void main(String[] args) 
	{

		twoTextAreas fourthProg = new twoTextAreas();
		
		fourthProg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	
	}

	public twoTextAreas()
	{		
		
		super("Round 4");
		
		panel1.add(ta1);
		panel1.add(ta2);
		c.add(panel1);
		
		ta1.setEditable(true);
		ta2.setEditable(false);
		
		setVisible(true);
		setSize(600,200);
		setLocation(100,200);		
		
	}
}
