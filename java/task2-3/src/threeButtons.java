import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class threeButtons extends JFrame
{
	
	JPanel panel1 = new JPanel();
	JButton button1 = new JButton("My First Button");
	JButton button2 = new JButton("My Second Button");
	JButton button3 = new JButton("My Third Button");
	Font fontStyleOne = new Font("Arial", Font.BOLD, 12);
	Font fontStyleTwo = new Font("Serif", Font.ITALIC, 14);
	Container c = getContentPane();	
	
	public static void main(String[] args) 
	{

		threeButtons thirdProg = new threeButtons();
		
		thirdProg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}

	
	public threeButtons()
	{
		
		super("Round 3");
		
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		c.add(panel1);

		button2.setFont(fontStyleOne);
		button3.setFont(fontStyleTwo);
		button3.setEnabled(false);
		
		setVisible(true);
		setSize(600,200);
		setLocation(200,100);
		
	}
}
